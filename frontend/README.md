# 📦 Parcel Management Frontend

This is the **frontend React application** for the Parcel Management system.  
It allows users to create, update, delete, and search parcels via a REST API.

---

## 🚀 Features

✅ Create new parcel  
✅ Edit existing parcel  
✅ Delete parcel  
✅ Search parcel by Tracking ID  
✅ Responsive Bootstrap UI  
✅ Table showing all parcels with actions  


## 🛠️ Tech Stack

- React 18+
- Bootstrap 5
- Axios

## ⚙️ Setup & Run

### 1️⃣ Install dependencies
npm install
### 2️⃣ Start the development server
npm start
-App will run at: http://localhost:3000
- Make sure your backend is running at the same time.
- By default, the frontend expects backend endpoints at: http://localhost:8080/api/parcels
- You can adjust API_URL in src/service/ParcelService.js if needed.

### 📞 API Endpoints Used
- Method	Endpoint	Description
- GET	/api/parcels	Get all parcels
- GET	/api/parcels/tracking/{id}	Get parcel by tracking ID
- POST	/api/parcels	Create new parcel
- PUT	/api/parcels/{id}	Update parcel by ID
- DELETE	/api/parcels/{id}	Delete parcel by ID


