# 📦 Parcel Management Backend

Spring Boot REST API for managing parcels with in-memory H2 database.  
Supports create, read, update, delete (CRUD) operations for parcels.  

## 🛠️ Tech Stack
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database

  
## 📝 API Endpoints

| Method | Endpoint                     | Description                |
|--------|-------------------------------|----------------------------|
| GET    | `/api/parcels`              | Get all parcels            |
| GET    | `/api/parcels/tracking/{id}`| Get parcel by tracking ID  |
| POST   | `/api/parcels`              | Create a new parcel        |
| PUT    | `/api/parcels/{id}`         | Update parcel by ID        |
| DELETE | `/api/parcels/{id}`         | Delete parcel by ID        |


## 🗄️ H2 Database Console

Available at: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Username: root
- Password: root




