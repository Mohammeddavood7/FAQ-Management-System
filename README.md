# FAQ-Management-System
Overview
The FAQ Management System is a RESTful Spring Boot application that allows users to:

Add FAQs with automatic translations (Hindi & Bengali).
Retrieve FAQs in different languages.
Delete FAQs.
Use caching for optimized performance.

Technology Stack
=====================
Backend: Java, Spring Boot, Spring Data JPA, Spring Cache
Database: H2 (In-memory, can be configured for MySQL/PostgreSQL)
Cloud API: Google Cloud Translation API
Build Tool: Maven
Containerization: Docker, Docker Compose

Installation Step
================
1. Clone the Repository

git clone <repository-url>
cd faq-management

2. Build the Project

mvn clean install
3. Run the Application


java -jar target/faq-app.jar
4. Run with Docker


docker-compose up --build

API Endpoints
============
1. Add an FAQ
================
Method: POST /api/faqs
Request Body:

{
  "question": "What is Spring Boot?",
  "answer": "Spring Boot is a framework for Java development."
}

Response:

{
  "id": 1,
  "question": "What is Spring Boot?",
  "answer": "Spring Boot is a framework for Java development.",
  "questionHi": "स्प्रिंग बूट क्या है?",
  "questionBn": "Spring Boot কী?"
}

2. Get FAQs
   ====================
Method: GET /api/faqs?lang={language_code}
Example: GET /api/faqs?lang=hi
Supported Languages:
en (English - default)
hi (Hindi)
bn (Bengali)
Response Example:

[
  {
    "question": "स्प्रिंग बूट क्या है?",
    "answer": "Spring Boot is a framework for Java development."
  },
  {
    "question": "Java क्या है?",
    "answer": "Java is a programming language."}
]

3. Delete an FAQ
==================
Method: DELETE /api/faqs/{id}
Example: DELETE /api/faqs/1
Response: 204 No Content
Running Tests
Run unit tests using:
mvn test

Deployment
====================
The application can be deployed using Docker.
The docker-compose.yml file helps in running the application inside a container.
To deploy on a cloud service, configure the database and API keys accordingly.
Contribution Guidelines
Follow Java best practices and Spring Boot conventions.
Use conventional commits (feat:, fix:, docs:, etc.).
