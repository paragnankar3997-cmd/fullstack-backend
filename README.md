# Full Stack Backend - Spring Boot + Kotlin

RESTful API backend built with Spring Boot, Kotlin, and PostgreSQL (Neon.tech).

## 🚀 Tech Stack

- **Spring Boot 3.2.2** with **Kotlin**
- **Maven** for build management
- **Spring Data JPA** for database operations
- **PostgreSQL** on **Neon.tech**
- RESTful API architecture

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/items` | Get all items |
| GET | `/api/items/{id}` | Get single item |
| POST | `/api/items` | Create new item |
| PUT | `/api/items/{id}` | Update item |
| DELETE | `/api/items/{id}` | Delete item |

## 🛠️ Local Development

### Prerequisites
- Java 17 or higher
- Maven

### Setup

1. **Set up environment variables**:
   ```bash
   cp .env.example .env
   ```
   
   Edit `.env` and add your database credentials:
   ```
   DATABASE_URL=jdbc:postgresql://your-neon-host/neondb?sslmode=require
   DATABASE_USERNAME=your_username
   DATABASE_PASSWORD=your_password
   PORT=8080
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

## 🔧 Maven Commands

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package application
mvn clean package

# Run application
mvn spring-boot:run

# Skip tests during build
mvn clean package -DskipTests
```

## 🌐 Deployment (Render)

1. Push this repository to GitHub
2. Create a new Web Service on Render
3. Configure:
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/demo-0.0.1-SNAPSHOT.jar`
4. Set environment variables:
   - `DATABASE_URL`: Your Neon connection string
   - `DATABASE_USERNAME`: Your Neon username
   - `DATABASE_PASSWORD`: Your Neon password
   - `PORT`: `8080`
5. Deploy!

## 🗄️ Database

This application uses PostgreSQL on Neon.tech. The connection is configured via environment variables.

### Schema

The application uses JPA with `ddl-auto: update`, so tables are created automatically.

**Item Entity**:
- `id` (Long, auto-generated)
- `name` (String, required)
- `description` (String, required, max 1000 chars)

## 🔗 Frontend Repository

This backend serves a React frontend. See the frontend repository for UI details.

## 📝 License

MIT
