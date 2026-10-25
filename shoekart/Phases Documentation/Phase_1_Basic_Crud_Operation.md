# Phase 1 – Setup and CRUD

## ✅ What We Did
- Installed PostgreSQL on port 5433
- Configured Spring Boot datasource
- Created `Shoe.java` model
- Implemented CRUD with JdbcTemplate

## 📚 What We Learned
- Difference between JPA and pure JDBC
- How to fix 415 Unsupported Media Type (Content-Type header)
- Debugging DB connection errors (port mismatch, password issues)

## 🧪 Outputs
- POST /shoes → Added Air Max
- GET /shoes → Returned seeded rows
- PUT /shoes/1 → Updated Nike Air Max
- DELETE /shoes/1 → Removed shoe successfully
