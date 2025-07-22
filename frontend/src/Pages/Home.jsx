import React, { useEffect, useState } from 'react';
import {
    getAllParcels,
    getParcelByTrackingId,
    createParcel,
    updateParcel,
    deleteParcel
} from '../service/ParcelService';

const Home = () => {
    const [parcels, setParcels] = useState([]);
    const [form, setForm] = useState({
        sender: '',
        recipient: '',
        address: '',
        weight: '',
        status: '',
        trackingId: ''
    });
    const [editingId, setEditingId] = useState(null);

    const [trackingIdInput, setTrackingIdInput] = useState('');
    const [trackingResult, setTrackingResult] = useState(null);
    const [trackingSearched, setTrackingSearched] = useState(false);

    const loadParcels = () => {
        getAllParcels()
            .then((data) => {
                setParcels(Array.isArray(data) ? data : []);
            })
            .catch(() => setParcels([]));
    };

    useEffect(() => {
        loadParcels();
    }, []);

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (editingId) {
            updateParcel(editingId, form).then(() => {
                resetForm();
                loadParcels();
            });
        } else {
            createParcel(form).then(() => {
                resetForm();
                loadParcels();
            });
        }
    };

    const handleEdit = (parcel) => {
        setForm({
            sender: parcel.sender,
            recipient: parcel.recipient,
            address: parcel.address,
            weight: parcel.weight,
            status: parcel.status,
            trackingId: parcel.trackingId
        });
        setEditingId(parcel.id);
    };

    const handleDelete = (id) => {
        deleteParcel(id).then(() => loadParcels());
    };

    const resetForm = () => {
        setForm({
            sender: '',
            recipient: '',
            address: '',
            weight: '',
            status: ''
        });
        setEditingId(null);
    };

    const handleTrackingSearch = () => {
        setTrackingSearched(true);
        setTrackingResult(null);

        if (!trackingIdInput.trim()) return;

        getParcelByTrackingId(trackingIdInput.trim())
            .then((result) => setTrackingResult(result))
            .catch(() => setTrackingResult(null));
    };

    return (
        <div className="container mt-4">
            <h2>Parcel Management</h2>

            <form onSubmit={handleSubmit} className="row g-3 mt-3">
                <div className="col-md-4">
                    <input
                        type="text"
                        name="sender"
                        value={form.sender}
                        onChange={handleChange}
                        placeholder="Sender"
                        className="form-control"
                        required
                    />
                </div>
                <div className="col-md-4">
                    <input
                        type="text"
                        name="recipient"
                        value={form.recipient}
                        onChange={handleChange}
                        placeholder="Recipient"
                        className="form-control"
                        required
                    />
                </div>
                <div className="col-md-4">
                    <input
                        type="text"
                        name="address"
                        value={form.address}
                        onChange={handleChange}
                        placeholder="Address"
                        className="form-control"
                        required
                    />
                </div>
                <div className="col-md-3">
                    <input
                        type="number"
                        name="weight"
                        value={form.weight}
                        onChange={handleChange}
                        placeholder="Weight"
                        className="form-control"
                        required
                    />
                </div>
                <div className="col-md-3">
                    <select
                        name="status"
                        value={form.status || 'Pending'}
                        onChange={handleChange}
                        className="form-select"
                        required
                    >
                        <option value="Pending">Pending</option>
                        <option value="Shipped">Shipped</option>
                        <option value="Delivered">Delivered</option>
                        <option value="Cancelled">Cancelled</option>
                    </select>
                </div>

                <div className="col-12">
                    <button type="submit" className="btn btn-primary">
                        {editingId ? 'Update Parcel' : 'Add Parcel'}
                    </button>
                    {editingId && (
                        <button
                            type="button"
                            onClick={resetForm}
                            className="btn btn-secondary ms-2"
                        >
                            Cancel
                        </button>
                    )}
                </div>
            </form>

            <div className="mt-4">
                <h5>Find Parcel by Tracking ID</h5>
                <div className="input-group mb-3">
                    <input
                        type="text"
                        value={trackingIdInput}
                        onChange={(e) => {
                            setTrackingIdInput(e.target.value);
                            setTrackingSearched(false);
                            setTrackingResult(null);
                        }}
                        placeholder="Enter Tracking ID"
                        className="form-control"
                    />
                    <button className="btn btn-info" onClick={handleTrackingSearch}>
                        Search
                    </button>
                </div>

                {trackingSearched && trackingResult === null && (
                    <div className="alert alert-danger">Parcel not found</div>
                )}

                {trackingResult && (
                    <div className="alert alert-success">
                        <strong>Found:</strong> {trackingResult.sender} →{' '}
                        {trackingResult.recipient} ({trackingResult.status})
                    </div>
                )}
            </div>

            <h4 className="mt-4">All Parcels</h4>
            <div className="table-responsive">
                <table className="table table-bordered mt-3">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tracking ID</th>
                            <th>Sender</th>
                            <th>Recipient</th>
                            <th>Address</th>
                            <th>Weight</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {parcels.length > 0 ? (
                            parcels.map((parcel) => (
                                <tr key={parcel.id}>
                                    <td>{parcel.id}</td>
                                    <td>{parcel.trackingId}</td>
                                    <td>{parcel.sender}</td>
                                    <td>{parcel.recipient}</td>
                                    <td>{parcel.address}</td>
                                    <td>{parcel.weight}</td>
                                    <td>{parcel.status}</td>
                                    <td>
                                        <button
                                            className="btn btn-sm btn-warning me-2"
                                            onClick={() => handleEdit(parcel)}
                                        >
                                            Edit
                                        </button>
                                        <button
                                            className="btn btn-sm btn-danger"
                                            onClick={() => handleDelete(parcel.id)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="8" className="text-center">
                                    No parcels found.
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Home;
