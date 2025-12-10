# UGTours: Integrated Mobile Tourism Guide for Uganda

<div align="center">

![Android](https://img.shields.io/badge/Platform-Android-green.svg)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg)
![MVVM](https://img.shields.io/badge/Architecture-MVVM-blue.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

**A comprehensive native Android application for exploring Uganda's tourism destinations**

**Developer:** Batya Tonny Boyo  
**GitHub:** [@batyaboyo](https://github.com/batyaboyo)  
**Platform:** Android (Kotlin)  
**Architecture:** MVVM with Room Database

</div>

---

## 📋 Table of Contents

- [Abstract](#abstract)
- [Introduction](#introduction)
- [System Analysis & Requirements](#system-analysis--requirements)
- [Architecture & Design](#architecture--design)
- [Implementation](#implementation)
- [Key Features](#key-features)
- [Technical Stack](#technical-stack)
- [Setup & Installation](#setup--installation)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Future Enhancements](#future-enhancements)
- [Conclusion](#conclusion)

---

## 📄 Abstract

**UGTours** is a native Android application developed as a comprehensive digital solution to promote tourism in Uganda, "The Pearl of Africa." The project bridges the information gap for tourists by providing a centralized, offline-accessible platform for exploring Uganda's premier national parks, cultural heritage sites, and natural landmarks. 

Built using modern Android development practices with **MVVM architecture**, **Room database** for offline persistence, and **Kotlin Coroutines** for asynchronous operations, the application integrates geolocation data, detailed attraction descriptions, accommodation listings, and a robust booking system to enhance the travel planning experience.

**Key Achievements:**
- 16+ curated tourist attractions with rich media content
- Dual-currency pricing system (USD/UGX) with automatic conversion
- Offline-first architecture using Room database
- Secure authentication with password hashing
- Real-time booking management system
- Favorites and recently viewed tracking

---

## 1. Introduction

### 1.1 Background

Uganda possesses immense tourism potential, ranging from the mountain gorillas of Bwindi Impenetrable Forest to the powerful Murchison Falls on the Nile River. The country hosts diverse ecosystems including savannah plains, tropical rainforests, and the snow-capped Rwenzori Mountains. Despite this wealth of natural and cultural attractions, tourists often struggle to find consolidated, reliable information regarding these destinations and nearby amenities.

Existing solutions are typically:
- **Fragmented web-based platforms** requiring consistent internet connectivity
- **Unreliable in remote safari locations** where network coverage is limited
- **Lacking integrated booking systems** for accommodations
- **Not optimized for mobile-first experiences**

### 1.2 Problem Statement

Travelers to Uganda face significant challenges:

1. **Information Accessibility:** No centralized offline database of attractions with comprehensive details
2. **Accommodation Discovery:** Difficulty finding verified lodging options near specific parks or sites
3. **Currency Confusion:** Pricing structures unclear for both local (UGX) and international (USD) tourists
4. **Booking Complexity:** No integrated system for managing accommodation reservations
5. **Navigation Challenges:** Limited digital guides for route planning

### 1.3 Objectives

**Main Objective:**  
To develop a user-friendly, offline-capable mobile application that serves as a definitive digital guide for tourists visiting Uganda.

**Specific Objectives:**
1. Design and implement a catalog of 16+ major tourist attractions with rich media (images, descriptions, features)
2. Develop an accommodation finder with proximity-based sorting and detailed pricing
3. Create a dual-currency pricing system (USD and UGX) with automatic conversion (1 USD = 3540 UGX)
4. Implement secure user authentication with password hashing
5. Build a booking management system for accommodation reservations
6. Utilize modern Android architecture (MVVM) with Room database for offline-first functionality
7. Implement favorites and recently viewed tracking for personalized user experience

---

## 2. System Analysis & Requirements

### 2.1 Functional Requirements

#### Core Features
- **User Authentication**
  - User registration with email validation
  - Secure login with bcrypt password hashing
  - Session management with DataStore preferences
  - Profile management

- **Attraction Discovery**
  - Browse 16+ curated attractions
  - Filter by category (National Park, Cultural Site, Waterfall, Adventure)
  - Search by name or keyword
  - View detailed information including history, unique features, and location

- **Accommodation System**
  - View accommodations linked to specific attractions
  - Filter by type (Luxury, Mid-range, Budget)
  - See proximity information (distance from attraction)
  - Dual-currency pricing display (USD and UGX)

- **Booking Management**
  - Create accommodation bookings with date selection
  - Specify number of guests and special requests
  - View booking history and status
  - Calculate total costs with automatic currency conversion
  - Manage booking status (Pending, Confirmed, Cancelled)

- **Personalization**
  - Add attractions to favorites
  - Track recently viewed attractions
  - Personalized home screen with recommendations

### 2.2 Non-Functional Requirements

- **Usability:** Intuitive interface following Material Design 3 guidelines
- **Performance:** 
  - Instant load times for attraction details
  - Efficient image caching with Glide
  - Smooth scrolling with RecyclerView optimization
- **Reliability:** 
  - Graceful error handling
  - Offline-first architecture
  - Data persistence across app restarts
- **Security:**
  - Password hashing with bcrypt
  - Secure session management
  - Input validation for all user data
- **Scalability:** 
  - MVVM architecture for easy feature additions
  - Repository pattern for flexible data sources
  - Modular code structure

### 2.3 Technology Stack

| Category | Technology | Purpose |
|----------|-----------|---------|
| **Language** | Kotlin | Modern, concise, null-safe Android development |
| **Architecture** | MVVM | Separation of concerns, testability |
| **UI Framework** | XML + ViewBinding | Type-safe view access |
| **Database** | Room (SQLite) | Offline data persistence |
| **Async Operations** | Kotlin Coroutines + Flow | Non-blocking operations, reactive streams |
| **Image Loading** | Glide | Efficient image caching and loading |
| **Preferences** | DataStore | Modern SharedPreferences replacement |
| **Security** | BCrypt | Password hashing |
| **Navigation** | Navigation Component | Fragment navigation |
| **Dependency Injection** | ViewModelFactory | Manual DI for ViewModels |

---

## 3. Architecture & Design

### 3.1 MVVM Architectural Pattern

The application follows the **Model-View-ViewModel (MVVM)** pattern with a clean architecture approach:

```
┌─────────────────────────────────────────────────────────┐
│                         VIEW LAYER                       │
│  (Activities, Fragments, XML Layouts, ViewBinding)      │
└────────────────────┬────────────────────────────────────┘
                     │ observes LiveData/Flow
                     ▼
┌─────────────────────────────────────────────────────────┐
│                     VIEWMODEL LAYER                      │
│  (Business Logic, UI State Management, Data Formatting) │
└────────────────────┬────────────────────────────────────┘
                     │ calls repository methods
                     ▼
┌─────────────────────────────────────────────────────────┐
│                    REPOSITORY LAYER                      │
│      (Data Source Abstraction, Business Logic)          │
└────────────────────┬────────────────────────────────────┘
                     │ accesses DAOs
                     ▼
┌─────────────────────────────────────────────────────────┐
│                      DATA LAYER                          │
│         (Room Database, DAOs, Entities)                  │
└─────────────────────────────────────────────────────────┘
```

**Benefits:**
- **Separation of Concerns:** Each layer has a single responsibility
- **Testability:** ViewModels can be unit tested independently
- **Lifecycle Awareness:** ViewModels survive configuration changes
- **Reactive UI:** LiveData/Flow automatically updates UI on data changes

### 3.2 Data Models

#### Core Entities

**Attraction (Domain Model)**
```kotlin
data class Attraction(
    val id: Int,
    val name: String,
    val category: String,
    val location: String,
    val description: String,
    val uniqueFeatures: List<String>,
    val imageUrls: List<String>,
    val thumbnailUrl: String,
    val nearbyAccommodations: List<Accommodation>,
    var isFavorite: Boolean = false
)
```

**Accommodation (Domain Model)**
```kotlin
data class Accommodation(
    val name: String,
    val type: String,              // Luxury, Mid-range, Budget
    val priceRange: String,         // "$400-600/night"
    val distance: String,           // "5km from park entrance"
    val amenities: List<String>,
    val contactEmail: String,
    val contactPhone: String
)
```

**Booking (Domain & Entity)**
```kotlin
data class Booking(
    val id: Long = 0,
    val userId: Long,
    val attractionId: String,
    val attractionName: String,
    val accommodationName: String,
    val accommodationType: String,
    val checkInDate: String,
    val checkOutDate: String,
    val numberOfGuests: Int,
    val numberOfNights: Int,
    val pricePerNightUSD: Double,
    val totalPriceUSD: Double,
    val totalPriceUGX: Double,
    val status: BookingStatus,
    val contactEmail: String,
    val contactPhone: String,
    val specialRequests: String = ""
)
```

**User Entity (Room Database)**
```kotlin
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String,
    val phone: String = "",
    val passwordHash: String,
    val passwordSalt: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
```

### 3.3 Database Schema

The Room database consists of the following tables:

- **users:** User authentication and profile data
- **favorites:** User's favorite attractions
- **recently_viewed:** Tracking of recently viewed attractions
- **bookings:** Accommodation booking records

**Relationships:**
- One-to-Many: User → Bookings
- Many-to-Many: User ↔ Attractions (Favorites)

---

## 4. Implementation

### 4.1 Core Features Implemented

#### 4.1.1 Authentication System

**Password Security:**
- Implements bcrypt hashing with salt for password storage
- Never stores plain-text passwords
- Secure session management using DataStore

```kotlin
// Password hashing implementation
object PasswordHasher {
    fun hashPasswordWithSalt(password: String): Pair<String, String> {
        val salt = BCrypt.gensalt(12)
        val hash = BCrypt.hashpw(password, salt)
        return Pair(hash, salt)
    }
    
    fun verifyPassword(password: String, hash: String, salt: String): Boolean {
        return BCrypt.checkpw(password, hash)
    }
}
```

#### 4.1.2 Dual Currency Pricing Engine

Automatic conversion between USD and UGX with intelligent price parsing:

```kotlin
private fun extractPriceFromRange(priceRange: String): Double {
    // Handles formats: "$400-600/night" or "$150/night"
    val regex = Regex("\\$(\\d+)")
    val match = regex.find(priceRange)
    return match?.groupValues?.get(1)?.toDoubleOrNull() ?: 250.0
}

private fun calculatePricing(priceUSD: Double): String {
    val priceUGX = priceUSD * 3540
    return "$${\"%.2f\".format(priceUSD)} (UGX ${\"%,.0f\".format(priceUGX)})"
}
```

#### 4.1.3 Booking System

Complete booking workflow with:
- Date selection with DatePickerDialog
- Guest count specification
- Special requests handling
- Automatic price calculation
- Real-time booking status tracking

#### 4.1.4 Offline-First Architecture

- All attraction data stored in Room database
- Favorites and recently viewed persist locally
- App functions fully offline after initial data load
- Efficient data caching with Glide for images

### 4.2 ViewModels

**Key ViewModels:**
- `AuthViewModel`: Handles login/registration logic
- `AttractionsViewModel`: Manages attraction list, search, and filtering
- `AttractionDetailViewModel`: Handles single attraction details and favorites
- `HomeViewModel`: Manages home screen data (featured, recently viewed)
- `FavoritesViewModel`: Tracks and displays favorite attractions
- `BookingsViewModel`: Manages booking creation and retrieval
- `ProfileViewModel`: Handles user profile and logout

---

## 5. Key Features

### 🏞️ Attraction Catalog
- **16+ Curated Destinations:** Bwindi, Murchison Falls, Queen Elizabeth NP, and more
- **Rich Media:** High-resolution image galleries for each location
- **Detailed Information:** History, unique features, location data
- **Category Filtering:** National Parks, Cultural Sites, Waterfalls, Adventure

### 🏨 Accommodation Finder
- **Proximity-Based Sorting:** Find lodges near specific attractions
- **Type Classification:** Luxury, Mid-range, Budget options
- **Comprehensive Details:** Amenities, contact information, distance
- **Dual Pricing:** Automatic USD to UGX conversion

### 📅 Booking Management
- **Date Selection:** Interactive calendar for check-in/check-out
- **Guest Management:** Specify number of guests
- **Price Calculation:** Automatic total calculation with currency conversion
- **Booking History:** Track all bookings with status updates
- **Special Requests:** Add custom notes for accommodations

### 💰 Dual Currency System
- **Automatic Conversion:** 1 USD = 3540 UGX
- **Transparent Pricing:** Both currencies displayed side-by-side
- **Intelligent Parsing:** Handles various price format strings

### ⭐ Personalization
- **Favorites:** Save attractions for quick access
- **Recently Viewed:** Track browsing history
- **Personalized Home:** Featured attractions and recommendations

### 🔒 Security
- **Password Hashing:** BCrypt with salt
- **Secure Sessions:** DataStore for session management
- **Input Validation:** Email, password strength checks

---

## 6. Technical Stack

### Development Environment
- **IDE:** Android Studio Iguana (2023.2.1) or newer
- **Build System:** Gradle 9.0
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **Compile SDK:** 34

### Core Dependencies

```gradle
dependencies {
    // Core Android
    implementation "androidx.core:core-ktx:1.12.0"
    implementation "androidx.appcompat:appcompat:1.6.1"
    implementation "com.google.android.material:material:1.11.0"
    
    // Architecture Components
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.7.0"
    
    // Room Database
    implementation "androidx.room:room-runtime:2.6.1"
    implementation "androidx.room:room-ktx:2.6.1"
    kapt "androidx.room:room-compiler:2.6.1"
    
    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
    
    // DataStore
    implementation "androidx.datastore:datastore-preferences:1.0.0"
    
    // Navigation
    implementation "androidx.navigation:navigation-fragment-ktx:2.7.6"
    implementation "androidx.navigation:navigation-ui-ktx:2.7.6"
    
    // Image Loading
    implementation "com.github.bumptech.glide:glide:4.16.0"
    
    // Security
    implementation "at.favre.lib:bcrypt:0.10.2"
    
    // Gson
    implementation "com.google.code.gson:gson:2.10.1"
}
```

---

## 7. Setup & Installation

### Prerequisites
- **Android Studio:** Iguana (2023.2.1) or newer
- **JDK:** 17 or higher
- **Android SDK:** API 24-34
- **Gradle:** 9.0+

### Installation Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/batyaboyo/UGTours_App.git
   cd UGTours_App
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory

3. **Sync Gradle**
   - Android Studio will automatically prompt to sync
   - Or manually: File → Sync Project with Gradle Files

4. **Build the Project**
   ```bash
   ./gradlew build
   ```

5. **Run on Device/Emulator**
   - Connect an Android device (USB debugging enabled)
   - Or start an Android emulator (API 24+)
   - Click Run (▶️) or press Shift+F10

### Build Variants
- **Debug:** Development build with debugging enabled
- **Release:** Production build (requires signing configuration)

---

## 8. Project Structure

```
com.ugtours/
├── data/
│   ├── local/
│   │   ├── AppDatabase.kt              # Room database configuration
│   │   ├── dao/                        # Data Access Objects
│   │   │   ├── UserDao.kt
│   │   │   ├── FavoritesDao.kt
│   │   │   ├── RecentlyViewedDao.kt
│   │   │   └── BookingsDao.kt
│   │   └── entities/                   # Room entities
│   │       ├── UserEntity.kt
│   │       ├── FavoriteEntity.kt
│   │       ├── RecentlyViewedEntity.kt
│   │       └── BookingEntity.kt
│   ├── repository/                     # Repository pattern
│   │   ├── AuthRepository.kt
│   │   ├── AttractionsRepository.kt
│   │   ├── BookingsRepository.kt
│   │   └── UserPreferencesRepository.kt
│   └── AttractionsData.kt              # Static attraction data
├── models/                             # Domain models
│   ├── Attraction.kt
│   ├── Accommodation.kt
│   ├── Booking.kt
│   ├── User.kt
│   └── BookingStatus.kt
├── ui/                                 # UI layer
│   ├── auth/                           # Authentication screens
│   │   ├── LoginFragment.kt
│   │   ├── RegisterFragment.kt
│   │   └── AuthViewModel.kt
│   ├── home/                           # Home screen
│   │   ├── HomeFragment.kt
│   │   ├── HomeViewModel.kt
│   │   └── FeaturedAttractionAdapter.kt
│   ├── attractions/                    # Attractions module
│   │   ├── AttractionsListFragment.kt
│   │   ├── AttractionsViewModel.kt
│   │   ├── AttractionDetailActivity.kt
│   │   ├── AttractionDetailViewModel.kt
│   │   ├── AttractionAdapter.kt
│   │   ├── AccommodationAdapter.kt
│   │   ├── FeaturesAdapter.kt
│   │   └── ImageSliderAdapter.kt
│   ├── favorites/                      # Favorites screen
│   │   ├── FavoritesFragment.kt
│   │   └── FavoritesViewModel.kt
│   ├── bookings/                       # Booking system
│   │   ├── BookingsFragment.kt
│   │   ├── BookingsViewModel.kt
│   │   ├── BookingDialogHelper.kt
│   │   └── BookingAdapter.kt
│   ├── profile/                        # User profile
│   │   ├── ProfileFragment.kt
│   │   └── ProfileViewModel.kt
│   ├── common/                         # Shared UI components
│   │   └── UiState.kt
│   ├── ViewModelFactory.kt             # ViewModel factory
│   └── MainActivity.kt                 # Main activity
├── utils/                              # Utility classes
│   ├── PasswordHasher.kt               # Password security
│   ├── Validators.kt                   # Input validation
│   └── ValidationResult.kt
└── res/                                # Resources
    ├── layout/                         # XML layouts
    ├── drawable/                       # Images and icons
    ├── values/                         # Strings, colors, themes
    └── navigation/                     # Navigation graphs
```

---

## 9. Testing

### Manual Testing Checklist

- [x] User registration with email validation
- [x] User login with password verification
- [x] Attraction browsing and filtering
- [x] Search functionality
- [x] Attraction detail view with image gallery
- [x] Add/remove favorites
- [x] Recently viewed tracking
- [x] Booking creation with date selection
- [x] Booking history display
- [x] Currency conversion accuracy
- [x] Offline functionality
- [x] Session persistence
- [x] Logout functionality

### Test Scenarios

**Authentication:**
- Register new user with valid/invalid email
- Login with correct/incorrect credentials
- Session persistence across app restarts

**Attractions:**
- Browse all attractions
- Filter by category
- Search by keyword
- View detailed information
- Navigate image galleries

**Bookings:**
- Create booking with valid dates
- Calculate pricing correctly
- View booking history
- Handle date validation

---

## 10. Future Enhancements

### Phase 1: Enhanced Features
- [ ] **Google Maps Integration:** Turn-by-turn navigation to attractions
- [ ] **Weather Integration:** Real-time weather for each location
- [ ] **Offline Maps:** Download maps for offline use
- [ ] **Multi-language Support:** English, Luganda, Swahili

### Phase 2: Social Features
- [ ] **User Reviews:** Rate and review attractions
- [ ] **Photo Sharing:** Upload and share travel photos
- [ ] **Social Login:** Google, Facebook authentication
- [ ] **Trip Planning:** Create and share itineraries

### Phase 3: Booking Integration
- [ ] **Payment Gateway:** Mobile Money (MTN, Airtel), Visa/Mastercard
- [ ] **Real-time Availability:** Check accommodation availability
- [ ] **Booking Confirmation:** Email/SMS notifications
- [ ] **Cancellation Management:** Handle booking cancellations

### Phase 4: Advanced Features
- [ ] **AR Features:** Augmented reality for attraction previews
- [ ] **Voice Guide:** Audio tours for attractions
- [ ] **Chatbot:** AI-powered travel assistant
- [ ] **Analytics Dashboard:** User behavior insights

---

## 11. Conclusion

### 11.1 Project Summary

**UGTours** successfully demonstrates the application of modern Android development practices to solve real-world challenges in Uganda's tourism sector. The project achieves its core objectives:

✅ **Comprehensive Digital Guide:** 16+ attractions with rich, detailed content  
✅ **Offline-First Architecture:** Full functionality without internet connectivity  
✅ **Dual-Currency System:** Transparent pricing for all users  
✅ **Secure Authentication:** Industry-standard password hashing  
✅ **Booking Management:** Complete reservation workflow  
✅ **Modern Architecture:** MVVM with Room database for scalability  

### 11.2 Technical Achievements

- **Clean Architecture:** Separation of concerns with MVVM pattern
- **Reactive Programming:** LiveData and Flow for responsive UI
- **Data Persistence:** Room database for offline capability
- **Security:** BCrypt password hashing with salt
- **Performance:** Efficient image loading and caching
- **User Experience:** Material Design 3 guidelines

### 11.3 Impact

By providing a structured, easy-to-use digital guide, UGTours has the potential to:
- **Increase Tourist Engagement:** Easier discovery of Uganda's attractions
- **Support Local Economy:** Direct bookings with local accommodations
- **Improve Travel Planning:** Comprehensive information in one place
- **Enhance Visitor Experience:** Offline access in remote locations

### 11.4 Lessons Learned

- **Offline-First Design:** Critical for apps targeting areas with limited connectivity
- **Currency Handling:** Important for international tourism applications
- **Security:** Never compromise on password security
- **User Experience:** Simple, intuitive interfaces drive adoption

---

## 📱 Screenshots

> **Note:** Add screenshots of key screens here:
> - Home Screen
> - Attraction Detail
> - Accommodation List
> - Booking Dialog
> - Favorites
> - Profile

---

## 📞 Contact & Support

**Developer:** Batya Tonny Boyo  
**Email:** [your-email@example.com]  
**GitHub:** [@batyaboyo](https://github.com/batyaboyo)  
**Project Repository:** [UGTours_App](https://github.com/batyaboyo/UGTours_App)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- **Uganda Wildlife Authority** for attraction information
- **Tourism Uganda** for promotional materials
- **Android Developer Community** for technical guidance
- **Project Supervisor** for academic support

---

<div align="center">

**© 2025 Batya Tonny Boyo. All Rights Reserved.**

*Made with ❤️ for Uganda's Tourism Industry*

</div>
