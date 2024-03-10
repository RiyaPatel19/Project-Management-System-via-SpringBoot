# Project Management System API

Welcome to the Project Management System API! This RESTful API allows users to manage projects by performing CRUD (Create, Read, Update, Delete) operations. The application is built using Java 17 and Spring Boot, with an in-memory H2 database for data persistence.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java 17
- Spring Boot
- Maven

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/project-management-api.git
   cd project-management-api
Build and run the application:
bash
mvn spring-boot:run
The API should now be running at http://localhost:8080.

CRUD Operations
Create: Add a new project using the endpoint POST /project.
Read: Retrieve all projects with GET /projects and a single project by ID with GET /project/{id}.
Update: Update an existing project with PUT /project/{id}.
Delete: Delete a project by ID using DELETE /project/{id}.

Exception Handling
Global exception handling is implemented to manage exceptions and provide meaningful error messages.
