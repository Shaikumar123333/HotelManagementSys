Hotel Management System Backend

A RESTful backend application for managing hotel operations such as hotels, rooms, users, and bookings. The application is built using Java and Spring Boot following a layered architecture.

-> Features
User Management
Hotel Management
Room Management
Booking Management
User Registration and Login
DTO-based data transfer
Global Exception Handling
Room availability and booking validation
Repository-based database operations
Clean layered architecture

-> Technologies Used
Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
Maven
REST APIs

-> Project Strucutre

src/main/java
│
└── org.example.hotelmanagesys
    │
    ├── controller
    │   ├── HotelController
    │   ├── RoomController
    │   └── UserController
    │
    ├── dto
    │   ├── BookingDTO
    │   ├── HotelDTO
    │   ├── LoginRequest
    │   ├── RegisterRequest
    │   ├── RoomDTO
    │   └── UserDTO
    │
    ├── entity
    │
    ├── exception
    │   ├── GlobalExceptionHandler
    │   ├── ResourceNotFoundException
    │   └── RoomAlreadyBookedException
    │
    ├── mapper
    │   ├── BookingMapper
    │   ├── HotelMapper
    │   ├── RoomMapper
    │   └── UserMapper
    │
    ├── repository
    │   ├── BookingRepository
    │   ├── HotelRepository
    │   ├── RoomRepository
    │   └── UserRepository
    │
    ├── service
    │   ├── BookingService
    │   ├── HotelService
    │   ├── RoomService
    │   └── UserService
    │
    └── HotelManagesysApplication.java

-> Architecture

Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database

Main Modules

User Management

Handles user registration, login, and user-related operations.

Hotel Management

Handles creating and managing hotel information.

Room Management

Handles room-related operations and room details.

Booking Management

Handles hotel room bookings and validates booking-related operations.
