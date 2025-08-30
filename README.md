# E-WALLET (Like Paytm)

A microservices-based digital wallet application inspired by Paytm. This project enables users to create accounts, manage their wallets, perform transactions, and receive notifications, all built using **Java Spring Boot**, **Kafka**, and **Microservices Architecture**.

---

## 🚀 Features

- **User Management** – Create, update, and manage user profiles.
- **Wallet Management** – Add, withdraw, and view wallet balance.
- **Transaction Service** – Secure and track all transactions.
- **Notification Service** – Kafka-based notifications for user actions.
- **Microservices Architecture** – Independent, scalable services for each module.
- **Spring Security Integration** – Secured APIs for authentication and authorization.

---

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot
- **Database**: (Specify your DB, e.g., MySQL / PostgreSQL / MongoDB)
- **Messaging**: Apache Kafka
- **Build Tool**: Maven
- **Version Control**: Git & GitHub

---

## 📂 Project Structure
```
E-WALLET-like-Paytm-main/
│── Notification-service/ # Handles user notifications
│── Transaction-Service/ # Manages transactions
│── User-Service/ # Manages user data
│── Wallet-Service/ # Handles wallet balance and updates
│── utils/ # Common utilities
│── pom.xml # Parent Maven configuration
│── .gitignore
```

# 📡 APIs Overview

## User Service

- **POST** `/user/create`  
  Create a new user.

- **GET** `/user/{id}`  
  Get user details by user ID.

## Wallet Service

- **POST** `/wallet/create`  
  Initialize a wallet for a user.

- **GET** `/wallet/balance/{userId}`  
  Retrieve the wallet balance for a given user.

## Transaction Service

- **POST** `/txn/initiate`  
  Initiate a transaction.

- **GET** `/txn/{id}`  
  Get the status of a specific transaction.

## License
This E-Wallet is open source and released under the MIT License. Feel free to use, modify, and distribute it as per the terms of the license.