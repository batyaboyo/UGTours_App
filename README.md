# UGTours App 🇺🇬

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)

**UGTours** is a comprehensive mobile application designed to showcase the beauty of Uganda, the Pearl of Africa. It serves as a digital guide for tourists, helping them discover national parks, cultural sites, and natural wonders, complete with details on nearby accommodations.

## ✨ Features

- **Explore Attractions**: Browse a curated list of 16+ major attractions including Bwindi Impenetrable National Park, Murchison Falls, and the Source of the Nile.
- **Detailed Insights**: View in-depth descriptions, unique features, and gallery images for each destination.
- **Accommodation Finder**: Discover nearby lodges and hotels for each attraction.
    - **Dual Currency Pricing**: View accommodation rates in both **USD** and **UGX** for easier planning.
    - **Ratings & Contact**: Access ratings and direct contact info for bookings.
- **Search & Filter**: Easily find attractions by name, category, or location.
- **Offline Support**: (Planned/Implemented via Room) Access key information even without an internet connection.

## 🛠️ Tech Stack

The application is built using modern Android development practices:

- **Language**: [Kotlin](https://kotlinlang.org/)
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI**: XML Layouts with ViewBinding
- **Navigation**: Android Jetpack Navigation Component
- **Persistence**: 
    - [Room Database](https://developer.android.com/training/data-storage/room) for local caching
    - [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) for user preferences
- **Concurrency**: Kotlin Coroutines & Flow
- **Image Loading**: [Glide](https://github.com/bumptech/glide)
- **Networking**: (If applicable) Retrofit / OkHttp [Note: Currently strictly local data in `AttractionsData.kt`]

## 🚀 Getting Started

### Prerequisites
- Android Studio Iguana or newer
- JDK 17+
- Android Device or Emulator (Min SDK 24)

### Installation

1.  **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/UGTours.git
    ```
2.  **Open in Android Studio**
    - Launch Android Studio.
    - Select "Open" and navigate to the cloned directory.
3.  **Build the project**
    - Let Gradle sync dependencies.
    - Run the app on your connected device or emulator (`Shift + F10`).

## 📂 Project Structure

```
com.ugtours
├── data            # Data sources (Room, static data)
├── models          # Data classes (Attraction, Accommodation)
├── ui              # Fragments, Activities, Adapters, ViewModels
│   ├── attractions # Attraction listing and details
│   └── ...
└── utils           # Helper functions and extensions
```

## 🤝 Contribution

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
