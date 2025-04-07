# 🏨 Hotel Management System Backend

This repository contains the backend implementation of the Hotel Management System using PostgreSQL.

## ✨ Features

- 🔒 User authentication and authorization
- 🛏️ Room booking and management
- 💳 Payment processing
- 📊 Admin dashboard for managing hotel operations
- 🌐 RESTful API endpoints
- 🛡️ API Gateway for centralized API management
- 🔍 Service discovery using Eureka

## 🛠️ Technologies Used

- **Backend**: Node.js, Express.js
- **Database**: PostgreSQL
- **Authentication**: JSON Web Tokens (JWT)
- **API Documentation**: Swagger
- **API Testing**: Postman
- **Other Tools**: Sequelize ORM, dotenv, Eureka

## ⚙️ Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/surya752/Hotel-Management-System-Backend-PostgressSQL.git
   cd Hotel-Management-System-Backend-PostgressSQL
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Set up environment variables:
   Create a `.env` file in the root directory and configure the following:

   ```
   DB_HOST=your_database_host
   DB_USER=your_database_user
   DB_PASSWORD=your_database_password
   ```

4. Run database migrations:

   ```bash
   npx sequelize-cli db:migrate
   ```

5. Start the server:
   ```bash
   npm start
   ```

## 📖 API Documentation

Refer to the [📄 API Documentation](docs/api-documentation.md) for detailed information about the available endpoints.

## 🤝 Contributing

Contributions are welcome! Please follow the [📜 contribution guidelines](CONTRIBUTING.md).

## 📜 License

This project is licensed under the [📄 MIT License](LICENSE).

## 📧 Contact

For any inquiries, please contact 📧 suryarekhapalli752@gmail.com.
