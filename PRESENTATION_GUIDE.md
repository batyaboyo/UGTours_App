# UGTours: Final Year Project Presentation Guide

**Presenter:** Batya Tonny Boyo
**Format:** Slide Deck Structure
**Note:** `[IMAGE PLACEHOLDER]` denotes where a screenshot or diagram should be placed.

---

## Slide 1: Title Slide
**[IMAGE PLACEHOLDER: App Logo centered, with University Logo in corner]**

*   **Project Title:** UGTours: Integrated Mobile Tourism Guide for Uganda
*   **Presenter:** Batya Tonny Boyo
*   **GitHub:** @batyaboyo
*   **Supervisor:** [Insert Name]
*   **Date:** December 2025

---

## Slide 2: Introduction
**[IMAGE PLACEHOLDER: Collage of Uganda's diverse attractions (Gorillas, Nile, Mountains)]**

*   **Hook:** "Uganda is the Pearl of Africa, but discovering its hidden gems is harder than it should be."
*   **Context:** Tourism is a major economic driver, yet digital infrastructure is fragmented.
*   **The Gap:** Lack of centralized, offline-accessible travel information.

---

## Slide 3: Problem Statement
**[IMAGE PLACEHOLDER: Graphic showing a frustrated tourist with no signal and confused about currency]**

1.  **Fragmented Info:** Data is scattered across multiple websites.
2.  **Connectivity:** Remote parks often lack reliable internet.
3.  **Currency Confusion:** Tourists struggle to convert USD listing prices to local UGX.
4.  **Accommodation Gap:** Hard to find verified lodges near specific parks.

---

## Slide 4: The Solution: UGTours
**[IMAGE PLACEHOLDER: High-quality screenshot of the UGTours Home Screen running on a phone]**

*   **Concept:** A native Android application serving as a comprehensive pocket guide.
*   **Core Promise:** "Explore Uganda with confidence, offline and on-budget."
*   **Key Capabilities:**
    *   Offline Database (Room).
    *   Dual-Currency Display.
    *   Integrated Accommodation Finder.

---

## Slide 5: Objectives
**[IMAGE PLACEHOLDER: Bulleted list with icons for 'Database', 'Money', 'Map']**

*   **Main Objective:** Develop a robust digital tourism guide.
*   **Specific Objectives:**
    1.  Digitize 16+ major attractions with rich media.
    2.  Implement proximity-based accommodation sorting.
    3.  Create an automated USD-to-UGX pricing engine.
    4.  Ensure seamless offline accessibility using MVVM architecture.

---

## Slide 6: System Analysis & Architecture
**[IMAGE PLACEHOLDER: Diagram of MVVM Architecture (View <-> ViewModel <-> Repository <-> Room/Remote)]**

*   **Architecture:** MVVM (Model-View-ViewModel).
    *   *Benefit:* Separation of concerns, easier testing, UI consistency.
*   **Data Flow:**
    *   **Repository:** Arbitrates data.
    *   **ViewModel:** Holds UI state (LiveData/Flow).
    *   **View:** XML Layouts with ViewBinding.

---

## Slide 7: Technology Stack
**[IMAGE PLACEHOLDER: Logos of Kotlin, Android Studio, Room, Glide, Coroutines]**

*   **Language:** Kotlin (Modern, expressive).
*   **Storage:** Room Database (Robust offline cache).
*   **Concurrency:** Coroutines (Efficient background tasks).
*   **Media:** Glide (Optimized image loading).

---

## Slide 8: Key Feature 1 - Attraction Catalog
**[IMAGE PLACEHOLDER: Screenshot of 'Attraction Details' screen showing text and image gallery]**

*   **Rich Content:** Detailed history, unique features, and location data.
*   **Visuals:** High-resolution image galleries for each site.
*   **UX:** Clean, material design interface for easy reading.

---

## Slide 9: Key Feature 2 - Pricing Engine
**[IMAGE PLACEHOLDER: zoomed-in screenshot of Accommodation list showing "$400 (UGX 1,416,000)"]**

*   **Problem:** Lodges quote in USD; Locals pay in UGX.
*   **Innovation:** Real-time string parsing and conversion.
*   **Rate:** Fixed reference rate (1 USD = 3540 UGX) for estimation.
*   **Benefit:** Instant financial clarity for all users.

---

## Slide 10: Conclusion & Future Work
**[IMAGE PLACEHOLDER: Graphic showing a roadmap with 'Maps' and 'Reviews' icons]**

*   **Impact:** UGTours bridges the information gap, empowering tourists.
*   **Future Scope:**
    *   GPS Turn-by-turn navigation.
    *   User Reviews & Community Photos.
    *   Direct In-app Booking.

---

## Slide 11: Q&A
**[IMAGE PLACEHOLDER: 'Thank You' text with Contact Details]**

*   **Open Floor:** "I am now ready to take your questions."
