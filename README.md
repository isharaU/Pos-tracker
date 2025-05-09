
# 🧾 Sales Tracker API

A simple Sales Tracking REST API built with **Spring Boot**, **MySQL**, and **Spring Security**, including scheduled tasks for generating hourly sales summaries.

---

## 📌 Features

- Manage Products (CRUD)
- Record Sales (assumed implemented)
- Generate hourly Sales Summaries per Store
- Role-based access control with Basic Authentication
- Scheduled background job using `@Scheduled`

---

## 🧠 Assumptions

- Authentication uses Basic Auth.
- Admin users, products, stores, and sales data are pre-inserted manually or via SQL.
- Roles defined: `CASHIER`, `STORE_MANAGER`, `HEAD_OFFICE_MANAGER`
- Application runs on `localhost:8080`
- You are using **Java 17+**, **Maven**, and **MySQL** as the database.

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Security (Basic Auth)
- MySQL
- Lombok

---

## 🚀 How to Run the Application

### 1. 🧩 Prerequisites

- Java 17+
- Maven
- MySQL (running)

### 2. 🗂️ Clone the Project

```bash
git clone https://github.com/isharaU/Pos-tracker.git
cd tracker
````

### 3. 🛠️ Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sales_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ✅ Ensure that the `sales_tracker` database is created beforehand.

### 4. 📦 Install Dependencies & Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🔐 Authentication

All protected endpoints require **Basic Authentication**.

### Sample Users

| Username | Password | Role                  |
| -------- | -------- | --------------------- |
| admin    | adminpass | HEAD\_OFFICE\_MANAGER |
| cashier  | pass | CASHIER               |

> You can insert users manually in the `user` table.

---

## 📬 API Endpoints

### 🧾 Products

| Method | Endpoint             | Description       |
| ------ | -------------------- | ----------------- |
| GET    | `/api/products`      | Get all products  |
| GET    | `/api/products/{id}` | Get product by ID |
| PUT    | `/api/products/{id}` | Update product    |

---

## 🕐 Scheduled Task

### 🧮 Hourly Sales Summary

* Runs every hour (`0 0 * * * *`)
* Calculates total sales amount per store in the past hour
* Inserts summary into `sales_summary` table

#### Optional: Manually Trigger (for testing)

You can add this to a controller:

```java
@GetMapping("/manual-summary")
public void triggerManualSummary() {
    salesSummaryService.generateHourlySummaries();
}
```

---

## 🧪 Testing

Use Postman or cURL with Basic Auth:

```bash
curl -u admin:admin123 http://localhost:8080/api/products
```

---

## 📎 Useful Commands

### Rebuild and Run:

```bash
mvn clean install
mvn spring-boot:run
```

### Test DB Connection:

```bash
mysql -u root -p
SHOW DATABASES;
USE sales_tracker;
SHOW TABLES;
```


