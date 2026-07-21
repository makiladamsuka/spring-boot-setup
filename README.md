# IN2201 - Software Engineering

**Name:** RPDMD Rajapaksha  
**Registration Number:** 245534U  

---

## Project Overview

This repository contains a Spring Boot web application designed for managing a personal bookstore collection using Spring Boot Web, Spring Data JPA, an in-memory H2 Database, and Thymeleaf for template rendering.

---

## Summary of Tasks & Implementation

### 1. View Engine & Dependency Configuration
* **Purpose:** Enable dynamic HTML template rendering and model attribute binding.
* **Implementation:** Added the `spring-boot-starter-thymeleaf` starter dependency in `pom.xml`.

### 2. Form Handling & Routing Fixes
* **Purpose:** Resolve form submission errors (such as 405 Method Not Allowed) caused by mismatched endpoint routes and static resource handling.
* **Implementation:**
  * Created `HomeController` to redirect the root path (`/`) to `/books`.
  * Updated `BookController` view resolutions to return template identifiers (`index` and `book-details`) instead of hardcoded `.html` strings.
  * Corrected form actions in `index.html` to submit via `POST /books`.
  * Implemented full CRUD functionality in `book-details.html` using HTTP `PUT` (updates) and `DELETE` (removals) to `/books/{id}`.

### 3. Server Configuration & UI Enhancements
* **Purpose:** Ensure form hidden method filter support, avoid port collisions, and deliver a modern responsive user interface.
* **Implementation:**
  * Updated `application.properties` with `server.port=8085` and enabled `spring.mvc.hiddenmethod.filter.enabled=true`.
  * Designed modern, glassmorphic UI templates (`index.html` and `book-details.html`) featuring Google Fonts (Inter) and CSS custom properties.

---

## Instructions to Build and Run

### Prerequisites
* Java JDK 17 or higher installed.
* Internet connection (for initial Maven dependency downloads).

### 1. Run Automated Tests
To verify the application build and run unit tests, execute:
```powershell
.\mvnw.cmd clean test
```

### 2. Start the Application
To run the Spring Boot web application locally:
```powershell
.\mvnw.cmd spring-boot:run
```

### 3. Access the Application
Once Tomcat starts up, open your web browser and navigate to:
```text
http://localhost:8085/
```
From here, you can view the collection, add new books, edit existing details, and delete entries.
