import axios from "axios";

const API_URL = "http://localhost:9090/api/parcels";

// Get all parcels
export const getAllParcels = () => {
    return axios.get(API_URL).then((response) => response.data);
};

// Get parcel by trackingId
export const getParcelByTrackingId = (trackingId) => {
    return axios.get(`${API_URL}/tracking/${trackingId}`).then((response) => response.data);
};

// Create a parcel
export const createParcel = (parcel) => {
    return axios.post(API_URL, parcel).then((response) => response.data);
};

// Update parcel by ID
export const updateParcel = (id, parcel) => {
    return axios.put(`${API_URL}/${id}`, parcel).then((response) => response.data);
};

// Delete parcel by ID
export const deleteParcel = (id) => {
    return axios.delete(`${API_URL}/${id}`).then((response) => response.data);
};
