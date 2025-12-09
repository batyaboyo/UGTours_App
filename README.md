# UGTours: Integrated Mobile Tourism Guide for Uganda

**Final Year Project Report**

**Developer:** Batya Tonny Boyo  
**GitHub:** [@batyaboyo](https://github.com/batyaboyo)  
**Platform:** Android (Kotlin)

---

## Abstract

**UGTours** is a native Android application developed as a comprehensive digital solution to promote tourism in Uganda, "The Pearl of Africa." The project aims to bridge the information gap for tourists by providing a centralized, offline-accessible platform for exploring Uganda's premier national parks, cultural heritage sites, and natural landmarks. The application integrates geolocation data, detailed attraction descriptions, and a robust accommodation finder to enhance the travel planning experience.

---

## 1. Introduction

### 1.1 Background
Uganda possesses immense tourism potential, ranging from the mountain gorillas of Bwindi to the powerful Murchison Falls. However, tourists often struggle to find consolidated, reliable information regarding these destinations and nearby amenities. Existing solutions are often fragmented web-based platforms that require consistent internet connectivity, which can be unreliable in remote safari locations.

### 1.2 Problem Statement
Travelers to Uganda face significant challenges in:
1.  Accessing reliable, offline information about attractions.
2.  Finding verified accommodation options near specific parks or sites.
3.  Understanding pricing structures in both local (UGX) and international (USD) currencies.
4.  Navigating without a centralized digital guide.

### 1.3 Objectives
**Main Objective:**  
To develop a user-friendly mobile application that serves as a definitive digital guide for tourists visiting Uganda.

**Specific Objectives:**
-   To design a catalog of major tourist attractions with rich media and detailed metadata.
-   To implement an accommodation finder that lists lodges and hotels sorted by proximity to attractions.
-   To provide a dual-currency pricing system (USD and UGX) to aid financial planning for both local and international tourists.
-   To utilize modern Android architecture (MVVM) for a robust, maintainable, and scalable application.

---

## 2. System Analysis & Requirements

### 2.1 Functional Requirements
-   **Attraction Discovery:** Users can view a list of attractions, filter by category (National Park, Cultural, Adventure), and search by name.
-   **Detail View:** Users can access deep details about an attraction, including history, unique features, and image galleries.
-   **Accommodation Listing:** The system displays accommodations linked to specific attractions.
-   **Currency Conversion:** Pricing must be displayed in both USD and UGX (Rate: 1 USD = 3540 UGX).
-   **Contact Integration:** Users can view contact details for bookings.

### 2.2 Non-Functional Requirements
-   **Usability:** The interface must be intuitive and follow Material Design guidelines.
-   **Performance:** The app should load detailed views instantly and handle image caching efficiently.
-   **Reliability:** The system must function correctly and handle errors gracefully.

### 2.3 Technology Stack
The project leverages the modern Android ecosystem:
-   **Language:** Kotlin (First-class support for Android).
-   **Architecture:** MVVM (Model-View-ViewModel) for separation of concerns.
-   **UI Toolkit:** XML with ViewBinding.
-   **Data Persistence:** Room Database (SQLite abstraction) for offline capabilities.
-   **Concurrency:** Kotlin Coroutines & Flow for asynchronous operations.
-   **Image Processing:** Glide library for efficient image loading and caching.
-   **Dependency Injection:** Manual DI / Koin (Simulated for this scope).

---

## 3. System Design

### 3.1 Architectural Pattern
The application follows the **MVVM (Model-View-ViewModel)** architectural pattern:
-   **Model:** Represents the data layer (Accommodation, Attraction data classes) and business logic.
-   **ViewModel:** Acts as a bridge between the UI and data, handling state and UI logic (e.g., `AttractionViewModel`).
-   **View:** The UI components (Activities/Fragments) that observe the ViewModel and react to changes.

### 3.2 Data Models
**Attraction Entity:**
-   `id`: Unique identifier
-   `name`: Name of the destination
-   `description`: comprehensive narrative
-   `location`: Geographic details
-   `imageUrls`: List of media links

**Accommodation Entity:**
-   `name`: Establishment name
-   `priceRange`: Cost in USD
-   `type`: Luxury, Mid-range, Budget
-   `distance`: Proximity to the attraction

---

## 4. Implementation

### 4.1 Core Features Implemented

#### 4.1.1 Attraction Catalog
The home screen presents a RecyclerView displaying card views of attractions. Each card features a high-quality thumbnail, title, and brief category description.

#### 4.1.2 Dual Currency Pricing Engine
To support international travelers, a custom pricing logic was implemented in `AccommodationAdapter`. It automatically parses USD price strings and calculates accurate UGX equivalents, displaying them side-by-side.

*Code Snippet (Logic):*
```kotlin
// Example Logic
val rate = 3540
val ugxValue = usdValue * rate
return "$usdValue (UGX $ugxValue)"
```

#### 4.1.3 Search & Filter
An optimized search algorithm allows users to query attractions by name or keyword. The filtering system sorts data based on categories like "National Park" or "Cultural Site."

### 4.2 Project Structure
```
com.ugtours
├── data            # Repository pattern implementation & Data sources
├── models          # Kotlin Data Classes
├── ui              # User Interface Layer
│   ├── attractions # Attraction listing, details, and adapters
│   └── ...
└── utils           # Utility functions (Currency formatters, etc.)
```

---

## 5. Conclusion & Future Work

### 5.1 Conclusion
The **UGTours** project successfully demonstrates the application of modern mobile computing techniques to solve a real-world problem in the tourism sector. By providing a structured, easy-to-use digital guide, the app potentially increases tourist engagement and simplifies the logistical challenges of traveling in Uganda.

### 5.2 Future Scope
-   **Map Integration:** Direct integration with Google Maps API for turn-by-turn navigation.
-   **User Reviews:** A backend system to allow users to leave real-time reviews and photos.
-   **Booking System:** Payment gateway integration (Mobile Money/Visa) for direct accommodation booking.

---

## 6. Setup & Installation

### Prerequisites
-   Android Studio Iguana or newer.
-   Java Development Kit (JDK) 17+.

### Installation Steps
1.  Clone the repository:
    ```bash
    git clone https://github.com/batyaboyo/UGTours_App.git
    ```
2.  Open the project in Android Studio.
3.  Sync Gradle files to download dependencies.
4.  Run on an Emulator or Physical Device (Min SDK 24).

---

&copy; 2025 Batya Tonny Boyo. All Rights Reserved.
