# GradeFlow — Distributed Academic Performance System

GradeFlow is a Java-based academic performance system that builds on an existing Grade Analyser and evolves towards a distributed application. The project explores academic performance analysis, service communication, asynchronous messaging, fault tolerance, and data consistency.

The goal is to apply practical software engineering and distributed-systems concepts incrementally while keeping the application understandable and testable.

## 🎯 Project Objectives

- Calculate student grades and analyse academic performance.
- Store student and grade data persistently.
- Introduce independent services with clearly defined responsibilities.
- Enable synchronous communication through REST APIs.
- Explore asynchronous communication using message queues.
- Handle partial failures and duplicate messages.
- Investigate data consistency and service recovery.
- Implement automated testing and health monitoring.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java | Application development |
| Maven | Dependency management and builds |
| Spring Boot | REST APIs and service development |
| SQLite | Lightweight relational database |
| JDBC | Database connectivity |
| RabbitMQ | Asynchronous messaging |
| Docker & Docker Compose | Containerisation and service orchestration |
| JUnit | Automated testing |
| Spring Boot Actuator | Health checks and monitoring |

Technologies will be introduced progressively as the project develops.

## 🏗️ Proposed Architecture

GradeFlow will evolve from a single application into a system of independent services.

### Planned Services

**1. Student Service**
- Manage student information.
- Retrieve student records through REST endpoints.

**2. Grade Service**
- Record and retrieve marks.
- Calculate grades and performance metrics.
- Publish relevant grade events.

**3. Report Service**
- Generate academic performance reports.
- Combine student and grade information.

**4. Alert Service**
- Process academic performance events.
- Demonstrate asynchronous notifications and failure handling.

REST APIs will support request-response communication, while RabbitMQ will support asynchronous messaging.

### Database Design

SQLite will provide relational data storage using a local database file.

The initial database may contain:

- `students` — student identifiers and basic information.
- `grades` — marks and assessment results linked to students.
- `reports` — generated report data, if persistence is required.

Foreign keys and appropriate constraints will help maintain data integrity.

As the application becomes distributed, we will deliberately define which service owns each dataset and how other services access the information. We will avoid assuming that a single shared SQLite database is automatically suitable for every service.

## 🔄 Development Roadmap

### Phase 1 — Existing Grade Analyser
- Review the existing Java codebase.
- Understand the grading logic.
- Configure Maven and automated tests.
- Introduce SQLite persistence.

### Phase 2 — REST APIs
- Introduce Spring Boot where appropriate.
- Define API endpoints and service responsibilities.
- Validate requests and handle errors.

### Phase 3 — Distributed Communication
- Introduce RabbitMQ.
- Publish and consume grade-related events.
- Handle unavailable services and failed messages.

### Phase 4 — Reliability and Consistency
- Explore duplicate message handling and idempotency.
- Handle partial failures.
- Investigate consistency between independently managed services.

### Phase 5 — Monitoring and Deployment
- Add health checks and monitoring endpoints.
- Containerise applicable components with Docker.
- Automate testing and document the architecture.

## 🧪 Testing Strategy

- **Unit tests:** Verify grading calculations and business rules.
- **Integration tests:** Test database operations and messaging.
- **API tests:** Verify HTTP responses and request validation.
- **Failure tests:** Examine behaviour when services or dependencies become unavailable.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Apache Maven
- IntelliJ IDEA
- Git

Docker and RabbitMQ will be required when the relevant distributed-system components are introduced.

### Build the project

From the project root:

```bash
mvn clean install
```

Run the tests:

```bash
mvn test
```

The application-specific run instructions will be documented once the current project structure and entry point have been confirmed.

## 📌 Project Status

**Status:** In development.

GradeFlow builds on an existing Grade Analyser. SQLite persistence and the distributed architecture will be implemented incrementally; planned features are not assumed to be complete.

## 👩‍💻 Author

Developed as a Java and distributed-systems learning project, with a focus on maintainable code, database fundamentals, reliable communication, and fault tolerance.
