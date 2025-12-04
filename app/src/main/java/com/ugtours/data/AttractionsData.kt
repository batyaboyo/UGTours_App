package com.ugtours.data

import com.ugtours.models.Accommodation
import com.ugtours.models.Attraction

object AttractionsData {
    
    fun getAllAttractions(): List<Attraction> {
        return listOf(
            // 1. Bwindi Impenetrable National Park
            Attraction(
                id = 1,
                name = "Bwindi Impenetrable National Park",
                category = "National Park",
                location = "Southwestern Uganda, Kanungu District",
                description = "Bwindi Impenetrable National Park is a UNESCO World Heritage Site and one of the most biodiverse forests in Africa. Home to nearly half of the world's remaining mountain gorillas (approximately 459 individuals), this ancient rainforest offers an unforgettable gorilla trekking experience. The park spans 331 square kilometers of misty, mountainous terrain covered in dense jungle. Beyond gorillas, Bwindi hosts 120 mammal species, 350 bird species including 23 Albertine Rift endemics, and over 200 butterfly species. The forest is estimated to be over 25,000 years old, making it one of Africa's oldest and most ecologically significant forests.",
                uniqueFeatures = listOf(
                    "Home to nearly 50% of world's mountain gorillas",
                    "UNESCO World Heritage Site since 1994",
                    "23 endemic bird species found nowhere else",
                    "Ancient rainforest over 25,000 years old",
                    "Gorilla trekking permits available year-round"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1551969014-7d2c4cddf0b6?w=800&q=80",
                    "https://images.unsplash.com/photo-1589182373726-e4f658ab50f0?w=800&q=80",
                    "https://images.unsplash.com/photo-1598524722512-0c0ccb5a533f?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1551969014-7d2c4cddf0b6?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Buhoma Lodge",
                        type = "Luxury Lodge",
                        priceRange = "$400-600/night",
                        contact = "+256 414 346464",
                        distanceFromAttraction = "1 km from park entrance",
                        rating = 4.8f
                    ),
                    Accommodation(
                        name = "Silverback Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$150-250/night",
                        contact = "+256 772 489497",
                        distanceFromAttraction = "2 km from park entrance",
                        rating = 4.5f
                    )
                )
            ),
            
            // 2. Murchison Falls National Park
            Attraction(
                id = 2,
                name = "Murchison Falls National Park",
                category = "National Park",
                location = "Northwestern Uganda, spanning 3,893 km²",
                description = "Murchison Falls National Park is Uganda's largest and oldest conservation area, bisected by the mighty Victoria Nile. The park's centerpiece is the spectacular Murchison Falls, where the Nile explodes through a narrow 7-meter gorge and plunges 43 meters below with thunderous force. The park boasts an incredible diversity of wildlife including over 76 mammal species and 451 bird species. Visitors can spot elephants, giraffes, lions, leopards, buffaloes, and one of Africa's largest populations of Nile crocodiles. The northern bank features savanna landscapes perfect for game drives, while the southern bank offers pristine forest habitats. Boat cruises to the base of the falls provide unforgettable wildlife viewing opportunities.",
                uniqueFeatures = listOf(
                    "World's most powerful waterfall by volume",
                    "Uganda's largest national park (3,893 km²)",
                    "Over 450 bird species recorded",
                    "Largest population of Nile crocodiles in Africa",
                    "Boat safaris to the falls base"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1605649487212-47bdab064df7?w=800&q=80",
                    "https://images.unsplash.com/photo-1547471080-7cc2caa01a7e?w=800&q=80",
                    "https://images.unsplash.com/photo-1535083783855-76ae62b2914e?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1605649487212-47bdab064df7?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Paraa Safari Lodge",
                        type = "Luxury Lodge",
                        priceRange = "$300-500/night",
                        contact = "+256 414 267153",
                        distanceFromAttraction = "Inside the park",
                        rating = 4.7f
                    ),
                    Accommodation(
                        name = "Fort Murchison Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$120-200/night",
                        contact = "+256 782 157100",
                        distanceFromAttraction = "5 km from park gate",
                        rating = 4.4f
                    )
                )
            ),
            
            // 3. Queen Elizabeth National Park
            Attraction(
                id = 3,
                name = "Queen Elizabeth National Park",
                category = "National Park",
                location = "Western Uganda, Kasese District",
                description = "Queen Elizabeth National Park is Uganda's most popular savanna reserve and a UNESCO Biosphere Reserve. Spanning 1,978 square kilometers, the park features diverse ecosystems from sprawling savanna to humid forests, sparkling lakes, and fertile wetlands. Famous for its tree-climbing lions in the Ishasha sector, the park also hosts over 95 mammal species and an astounding 600+ bird species - more than any other East African national park. The Kazinga Channel, a 32-kilometer natural waterway connecting Lake Edward and Lake George, offers spectacular boat cruises with guaranteed sightings of hippos, elephants, buffaloes, and countless waterbirds. The park's backdrop of the Rwenzori Mountains creates breathtaking scenery.",
                uniqueFeatures = listOf(
                    "Famous tree-climbing lions of Ishasha",
                    "Over 600 bird species - highest in East Africa",
                    "Kazinga Channel boat cruises",
                    "UNESCO Biosphere Reserve",
                    "Volcanic crater lakes and explosion craters"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1614027164847-1b28cfe1df60?w=800&q=80",
                    "https://images.unsplash.com/photo-1516426122078-c23e76319801?w=800&q=80",
                    "https://images.unsplash.com/photo-1549366021-9f761d450615?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1614027164847-1b28cfe1df60?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Mweya Safari Lodge",
                        type = "Luxury Lodge",
                        priceRange = "$350-550/night",
                        contact = "+256 414 267153",
                        distanceFromAttraction = "Inside the park",
                        rating = 4.6f
                    ),
                    Accommodation(
                        name = "Enganzi Game Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$100-180/night",
                        contact = "+256 772 468468",
                        distanceFromAttraction = "3 km from park entrance",
                        rating = 4.3f
                    )
                )
            ),
            
            // 4. Kibale Forest National Park
            Attraction(
                id = 4,
                name = "Kibale Forest National Park",
                category = "National Park",
                location = "Western Uganda, Fort Portal",
                description = "Kibale Forest National Park protects one of Africa's most beautiful and diverse tropical rainforests. Renowned as the primate capital of the world, Kibale is home to 13 primate species including over 1,500 chimpanzees - our closest living relatives. The park's 795 square kilometers of pristine forest offers the best chimpanzee tracking experience in East Africa with a 90% success rate. Beyond primates, the forest hosts 375 bird species, 250 butterfly species, and rare forest elephants. The dense canopy, towering trees, and chorus of wildlife create an immersive jungle experience. Guided chimp habituation experiences allow visitors to spend entire days observing these intelligent creatures.",
                uniqueFeatures = listOf(
                    "Highest density of primates in Africa (13 species)",
                    "Over 1,500 chimpanzees",
                    "90% chimpanzee tracking success rate",
                    "375 bird species including rare forest species",
                    "Full-day chimp habituation experiences available"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?w=800&q=80",
                    "https://images.unsplash.com/photo-1615963244664-5b845b2025ee?w=800&q=80",
                    "https://images.unsplash.com/photo-1564349683136-77e08dba1ef7?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Primate Lodge Kibale",
                        type = "Mid-range Lodge",
                        priceRange = "$180-280/night",
                        contact = "+256 414 346464",
                        distanceFromAttraction = "Inside the park",
                        rating = 4.5f
                    ),
                    Accommodation(
                        name = "Chimpanzee Forest Guesthouse",
                        type = "Budget Lodge",
                        priceRange = "$60-100/night",
                        contact = "+256 772 509509",
                        distanceFromAttraction = "2 km from park gate",
                        rating = 4.2f
                    )
                )
            ),
            
            // 5. Jinja - Source of the Nile
            Attraction(
                id = 5,
                name = "Jinja - Source of the Nile",
                category = "Adventure & Cultural",
                location = "Eastern Uganda, Jinja City",
                description = "Jinja is the adventure capital of East Africa, situated where the mighty Nile River begins its 6,650-kilometer journey from Lake Victoria to the Mediterranean Sea. This historic town offers world-class white-water rafting on Grade 5 rapids, bungee jumping from 44 meters above the Nile, kayaking, quad biking, and boat cruises to the actual source of the Nile. The town has rich colonial history with beautiful architecture and was once Uganda's industrial hub. Beyond adventure sports, visitors can explore the source of the Nile monument, visit local craft markets, and experience the vibrant culture of the Basoga people. The sunset over the Nile from various viewpoints is absolutely spectacular.",
                uniqueFeatures = listOf(
                    "Source of the world's longest river",
                    "World-class white-water rafting (Grade 5 rapids)",
                    "Bungee jumping over the Nile",
                    "Rich colonial history and architecture",
                    "Multiple adventure activities: kayaking, quad biking, jet boating"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1583416750470-965b2707b355?w=800&q=80",
                    "https://images.unsplash.com/photo-1474524955719-b9f87c50ce47?w=800&q=80",
                    "https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1583416750470-965b2707b355?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Wildwaters Lodge",
                        type = "Luxury Lodge",
                        priceRange = "$400-650/night",
                        contact = "+256 414 251182",
                        distanceFromAttraction = "On private island in the Nile",
                        rating = 4.9f
                    ),
                    Accommodation(
                        name = "The Haven Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$80-150/night",
                        contact = "+256 772 489489",
                        distanceFromAttraction = "5 km from town center",
                        rating = 4.4f
                    )
                )
            ),
            
            // 6. Sipi Falls
            Attraction(
                id = 6,
                name = "Sipi Falls",
                category = "Waterfall & Adventure",
                location = "Eastern Uganda, Mount Elgon foothills",
                description = "Sipi Falls is a series of three magnificent waterfalls located on the foothills of Mount Elgon near the Kenyan border. The main fall drops an impressive 100 meters, creating a spectacular curtain of water surrounded by lush vegetation and coffee plantations. The area offers excellent hiking trails connecting all three falls, with breathtaking views of the Karamoja plains and, on clear days, Lake Kyoga. Sipi is also Uganda's premier coffee-growing region, and visitors can tour local coffee farms to learn about organic coffee production from bean to cup. Rock climbing, abseiling down the falls, and cultural visits to the Sabiny people add to the diverse experiences available.",
                uniqueFeatures = listOf(
                    "Three stunning waterfalls (100m, 85m, 75m drops)",
                    "Uganda's premier Arabica coffee region",
                    "Rock climbing and abseiling opportunities",
                    "Panoramic views of Karamoja plains",
                    "Cultural experiences with Sabiny people"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1587974928442-77dc3e0dba72?w=800&q=80",
                    "https://images.unsplash.com/photo-1433086966358-54859d0ed716?w=800&q=80",
                    "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1587974928442-77dc3e0dba72?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Sipi River Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$100-180/night",
                        contact = "+256 772 468468",
                        distanceFromAttraction = "1 km from main falls",
                        rating = 4.6f
                    ),
                    Accommodation(
                        name = "Moses Campsite",
                        type = "Budget Campsite",
                        priceRange = "$20-50/night",
                        contact = "+256 782 123456",
                        distanceFromAttraction = "500m from falls",
                        rating = 4.3f
                    )
                )
            ),
            
            // 7. Lake Bunyonyi
            Attraction(
                id = 7,
                name = "Lake Bunyonyi",
                category = "Lake & Relaxation",
                location = "Southwestern Uganda, Kabale District",
                description = "Lake Bunyonyi, meaning 'place of many little birds,' is one of Africa's most beautiful and deepest lakes, reaching depths of 900 meters. This scenic lake is dotted with 29 islands, each with its own unique history and character. The terraced hillsides surrounding the lake create a stunning patchwork landscape reminiscent of Switzerland. The lake is bilharzia-free and safe for swimming, making it a perfect relaxation destination after gorilla trekking. Visitors can enjoy canoeing between islands, bird watching (over 200 species), visiting local communities, and simply soaking in the serene atmosphere. The cool climate and peaceful setting make it an ideal retreat.",
                uniqueFeatures = listOf(
                    "One of Africa's deepest lakes (900m depth)",
                    "29 scenic islands to explore",
                    "Bilharzia-free and safe for swimming",
                    "Over 200 bird species",
                    "Terraced hillsides creating stunning landscapes"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1590523277543-a94d2e4eb00b?w=800&q=80",
                    "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&q=80",
                    "https://images.unsplash.com/photo-1439066615861-d1af74d74000?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1590523277543-a94d2e4eb00b?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Bird Nest Resort",
                        type = "Mid-range Resort",
                        priceRange = "$120-200/night",
                        contact = "+256 772 489489",
                        distanceFromAttraction = "On the lakeshore",
                        rating = 4.5f
                    ),
                    Accommodation(
                        name = "Bunyonyi Overland Resort",
                        type = "Budget Resort",
                        priceRange = "$40-80/night",
                        contact = "+256 782 456789",
                        distanceFromAttraction = "Lakeside location",
                        rating = 4.2f
                    )
                )
            ),
            
            // 8. Rwenzori Mountains
            Attraction(
                id = 8,
                name = "Rwenzori Mountains National Park",
                category = "Mountain & Hiking",
                location = "Western Uganda, Kasese District",
                description = "The Rwenzori Mountains, known as the 'Mountains of the Moon,' form a UNESCO World Heritage Site along Uganda's border with the Democratic Republic of Congo. This spectacular mountain range features Africa's third-highest peak, Margherita Peak (5,109m), and is one of the continent's most challenging trekking destinations. The mountains harbor unique Afro-alpine vegetation, including giant lobelias and groundsels found nowhere else on Earth. Six glaciers crown the highest peaks, though they're rapidly receding due to climate change. The trek through multiple vegetation zones - from tropical rainforest to alpine meadows to glacial landscapes - offers an otherworldly experience. The range is also the source of numerous rivers feeding into the Nile system.",
                uniqueFeatures = listOf(
                    "Africa's third-highest peak (5,109m)",
                    "UNESCO World Heritage Site",
                    "Unique Afro-alpine vegetation (giant lobelias)",
                    "Six glaciers on highest peaks",
                    "Multi-day trekking expeditions (7-12 days)"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1519904981063-b0cf448d479e?w=800&q=80",
                    "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=800&q=80",
                    "https://images.unsplash.com/photo-1486870591958-9b9d0d1dda99?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1519904981063-b0cf448d479e?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Ruboni Community Camp",
                        type = "Community Lodge",
                        priceRange = "$50-100/night",
                        contact = "+256 772 509509",
                        distanceFromAttraction = "At park entrance",
                        rating = 4.3f
                    ),
                    Accommodation(
                        name = "Rwenzori Turaco View Campsite",
                        type = "Budget Campsite",
                        priceRange = "$30-60/night",
                        contact = "+256 782 234567",
                        distanceFromAttraction = "2 km from park gate",
                        rating = 4.1f
                    )
                )
            ),
            
            // 9. Kidepo Valley National Park
            Attraction(
                id = 9,
                name = "Kidepo Valley National Park",
                category = "National Park",
                location = "Northeastern Uganda, Karamoja region",
                description = "Kidepo Valley National Park is Uganda's most remote and arguably most spectacular wilderness area. Located in the rugged, semi-arid Karamoja region, this 1,442 square kilometer park offers a true off-the-beaten-path safari experience. The park boasts over 77 mammal species and 475 bird species, including several found nowhere else in Uganda such as cheetahs, caracals, and bat-eared foxes. The dramatic landscape features vast savanna plains hemmed in by mountains, with the seasonal Kidepo and Narus rivers creating oases of life. The park's isolation means fewer tourists and more authentic wildlife encounters. The Karamojong people's traditional culture adds a unique cultural dimension to visits.",
                uniqueFeatures = listOf(
                    "Uganda's most remote and pristine wilderness",
                    "Unique species: cheetahs, caracals, bat-eared foxes",
                    "475 bird species including ostriches",
                    "Dramatic mountain-ringed savanna landscapes",
                    "Cultural encounters with Karamojong people"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1564760055775-d63b17a55c44?w=800&q=80",
                    "https://images.unsplash.com/photo-1547471080-7cc2caa01a7e?w=800&q=80",
                    "https://images.unsplash.com/photo-1535083783855-76ae62b2914e?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1564760055775-d63b17a55c44?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Apoka Safari Lodge",
                        type = "Luxury Lodge",
                        priceRange = "$500-800/night",
                        contact = "+256 414 346464",
                        distanceFromAttraction = "Inside the park",
                        rating = 4.8f
                    ),
                    Accommodation(
                        name = "Kidepo Savannah Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$150-250/night",
                        contact = "+256 772 468468",
                        distanceFromAttraction = "Near park entrance",
                        rating = 4.4f
                    )
                )
            ),
            
            // 10. Ssezibwa Falls
            Attraction(
                id = 10,
                name = "Ssezibwa Falls",
                category = "Cultural & Waterfall",
                location = "Central Uganda, Mukono District",
                description = "Ssezibwa Falls is a culturally significant waterfall located just 32 kilometers from Kampala, making it an easy day trip from the capital. The falls are unique as the river splits into two separate streams that cascade over rocks before reuniting downstream. According to Buganda tradition, the falls were born as twins to a woman named Nakangu, hence the name 'Ssezibwa' meaning 'father of twins.' The site is considered sacred by the Baganda people, and traditional healers and spiritual practitioners regularly visit to perform rituals. The surrounding forest is home to various primate species and over 100 bird species. Well-maintained trails, picnic areas, and the peaceful atmosphere make it perfect for family outings.",
                uniqueFeatures = listOf(
                    "Sacred site in Buganda culture",
                    "River splits into twin waterfalls",
                    "Only 32 km from Kampala",
                    "Traditional spiritual ceremonies held here",
                    "Easy hiking trails and picnic facilities"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1433086966358-54859d0ed716?w=800&q=80",
                    "https://images.unsplash.com/photo-1587974928442-77dc3e0dba72?w=800&q=80",
                    "https://images.unsplash.com/photo-1439066615861-d1af74d74000?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1433086966358-54859d0ed716?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Ssezibwa Falls Resort",
                        type = "Budget Resort",
                        priceRange = "$40-80/night",
                        contact = "+256 772 123456",
                        distanceFromAttraction = "At the falls",
                        rating = 4.0f
                    ),
                    Accommodation(
                        name = "Mukono Forest Resort",
                        type = "Mid-range Resort",
                        priceRange = "$80-140/night",
                        contact = "+256 782 345678",
                        distanceFromAttraction = "10 km from falls",
                        rating = 4.2f
                    )
                )
            ),
            
            // 11. Kasubi Tombs
            Attraction(
                id = 11,
                name = "Kasubi Tombs",
                category = "Cultural Heritage",
                location = "Kampala, Kasubi Hill",
                description = "The Kasubi Tombs are a UNESCO World Heritage Site and the most sacred burial ground of the Buganda Kingdom. Built in 1882, the main tomb (Muzibu Azaala Mpanga) is an architectural masterpiece constructed entirely from organic materials including wood, thatch, reed, and wattle. The circular building houses the remains of four Kabakas (kings) of Buganda. The site represents the spiritual and political center of the Buganda Kingdom and showcases traditional building techniques passed down through generations. Although the main structure was destroyed by fire in 2010, it has been meticulously reconstructed using traditional methods. Visitors can learn about Buganda's rich history, royal traditions, and the significance of ancestral worship in Ugandan culture.",
                uniqueFeatures = listOf(
                    "UNESCO World Heritage Site",
                    "Burial site of four Buganda kings",
                    "Traditional organic architecture",
                    "Active spiritual and cultural center",
                    "Insight into Buganda Kingdom history"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1585128792304-b8f4c6c35e3f?w=800&q=80",
                    "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=800&q=80",
                    "https://images.unsplash.com/photo-1604537466158-719b1972feb8?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1585128792304-b8f4c6c35e3f?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Kampala Serena Hotel",
                        type = "Luxury Hotel",
                        priceRange = "$200-350/night",
                        contact = "+256 414 309000",
                        distanceFromAttraction = "5 km from tombs",
                        rating = 4.7f
                    ),
                    Accommodation(
                        name = "Cassia Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$100-180/night",
                        contact = "+256 772 468468",
                        distanceFromAttraction = "3 km from tombs",
                        rating = 4.4f
                    )
                )
            ),
            
            // 12. Uganda Wildlife Education Centre
            Attraction(
                id = 12,
                name = "Uganda Wildlife Education Centre",
                category = "Wildlife & Education",
                location = "Entebbe, Lake Victoria shores",
                description = "The Uganda Wildlife Education Centre (UWEC), formerly Entebbe Zoo, is a conservation and education facility located on the shores of Lake Victoria. The center serves as a rescue and rehabilitation facility for orphaned, injured, and confiscated wildlife. Visitors can see a wide variety of Ugandan wildlife including lions, leopards, chimpanzees, rhinos, elephants, giraffes, and numerous bird species in well-maintained, naturalistic enclosures. UWEC offers unique 'behind-the-scenes' experiences where visitors can interact with some animals under keeper supervision, including feeding giraffes and walking with chimpanzees. The center plays a crucial role in wildlife conservation education and has successfully released rehabilitated animals back into the wild.",
                uniqueFeatures = listOf(
                    "Wildlife rescue and rehabilitation center",
                    "Behind-the-scenes animal experiences",
                    "See Uganda's wildlife in one location",
                    "Giraffe feeding and chimp walking experiences",
                    "Conservation education programs"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1551969014-7d2c4cddf0b6?w=800&q=80",
                    "https://images.unsplash.com/photo-1614027164847-1b28cfe1df60?w=800&q=80",
                    "https://images.unsplash.com/photo-1564760055775-d63b17a55c44?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1551969014-7d2c4cddf0b6?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Protea Hotel Entebbe",
                        type = "Mid-range Hotel",
                        priceRange = "$120-200/night",
                        contact = "+256 414 320000",
                        distanceFromAttraction = "2 km from UWEC",
                        rating = 4.5f
                    ),
                    Accommodation(
                        name = "Entebbe Backpackers",
                        type = "Budget Hostel",
                        priceRange = "$25-50/night",
                        contact = "+256 772 234567",
                        distanceFromAttraction = "3 km from UWEC",
                        rating = 4.1f
                    )
                )
            ),
            
            // 13. Ngamba Island Chimpanzee Sanctuary
            Attraction(
                id = 13,
                name = "Ngamba Island Chimpanzee Sanctuary",
                category = "Wildlife Sanctuary",
                location = "Lake Victoria, 23 km from Entebbe",
                description = "Ngamba Island Chimpanzee Sanctuary is a 100-acre forested island in Lake Victoria that serves as a haven for orphaned and rescued chimpanzees. Established in 1998, the sanctuary is home to over 50 chimpanzees that cannot be released back into the wild due to their habituation to humans. The island provides a safe, natural environment where chimps can live in a semi-wild state. Visitors can observe feeding times from a viewing platform, learning about each chimp's unique personality and rescue story. Overnight stays are available in eco-friendly tented camps, offering the magical experience of falling asleep to chimp calls. The sanctuary plays a vital role in chimp conservation and public education about great ape protection.",
                uniqueFeatures = listOf(
                    "Over 50 rescued chimpanzees",
                    "Accessible by boat from Entebbe (45 min)",
                    "Feeding platform viewing experiences",
                    "Overnight camping with chimps",
                    "Conservation education programs"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1615963244664-5b845b2025ee?w=800&q=80",
                    "https://images.unsplash.com/photo-1540573133985-87b6da6d54a9?w=800&q=80",
                    "https://images.unsplash.com/photo-1590523277543-a94d2e4eb00b?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1615963244664-5b845b2025ee?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Ngamba Island Tented Camp",
                        type = "Eco-Camp",
                        priceRange = "$150-250/night",
                        contact = "+256 414 320662",
                        distanceFromAttraction = "On the island",
                        rating = 4.6f
                    ),
                    Accommodation(
                        name = "Entebbe Hotels (mainland)",
                        type = "Various",
                        priceRange = "$50-200/night",
                        contact = "Various contacts",
                        distanceFromAttraction = "23 km boat ride",
                        rating = 4.0f
                    )
                )
            ),
            
            // 14. Lake Mburo National Park
            Attraction(
                id = 14,
                name = "Lake Mburo National Park",
                category = "National Park",
                location = "Western Uganda, Mbarara District",
                description = "Lake Mburo National Park is Uganda's smallest savanna national park but packs incredible diversity into its 370 square kilometers. The park is centered around Lake Mburo, one of 14 lakes in the area, and is the only park in Uganda where you can see impalas and the only place to find Burchell's zebras. The park's compact size and proximity to Kampala (230 km) make it perfect for short safaris. Visitors can enjoy game drives, boat cruises, horseback safaris, and walking safaris - a rare opportunity to explore African wilderness on foot. The park hosts over 350 bird species, including the rare African finfoot. The landscape features rolling hills, acacia woodlands, and seasonal wetlands creating diverse habitats.",
                uniqueFeatures = listOf(
                    "Only park in Uganda with impalas and zebras",
                    "Walking and horseback safaris allowed",
                    "Boat cruises on Lake Mburo",
                    "Over 350 bird species",
                    "Closest savanna park to Kampala"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1549366021-9f761d450615?w=800&q=80",
                    "https://images.unsplash.com/photo-1535083783855-76ae62b2914e?w=800&q=80",
                    "https://images.unsplash.com/photo-1590523277543-a94d2e4eb00b?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1549366021-9f761d450615?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Mihingo Lodge",
                        type = "Luxury Lodge",
                        priceRange = "$350-550/night",
                        contact = "+256 414 346464",
                        distanceFromAttraction = "Inside the park",
                        rating = 4.8f
                    ),
                    Accommodation(
                        name = "Rwakobo Rock Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$100-180/night",
                        contact = "+256 772 489489",
                        distanceFromAttraction = "2 km from park gate",
                        rating = 4.5f
                    )
                )
            ),
            
            // 15. Ziwa Rhino Sanctuary
            Attraction(
                id = 15,
                name = "Ziwa Rhino Sanctuary",
                category = "Wildlife Sanctuary",
                location = "Central Uganda, Nakasongola District",
                description = "Ziwa Rhino Sanctuary is the only place in Uganda where you can see rhinos in the wild. The 70-square-kilometer sanctuary was established in 2005 as a breeding ground to reintroduce rhinos to Uganda's national parks after they were poached to extinction in the 1980s. Currently home to over 30 southern white rhinos, the sanctuary offers guided rhino tracking experiences on foot, allowing visitors to approach these magnificent creatures to within meters. Beyond rhinos, the sanctuary hosts other wildlife including antelopes, hippos, crocodiles, and over 300 bird species. The sanctuary is conveniently located along the Kampala-Murchison Falls route, making it a perfect stopover. Night walks and canoe trips are also available.",
                uniqueFeatures = listOf(
                    "Only place to see rhinos in Uganda",
                    "Over 30 southern white rhinos",
                    "Guided rhino tracking on foot",
                    "Successful breeding program",
                    "Convenient stopover between Kampala and Murchison Falls"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1598524722512-0c0ccb5a533f?w=800&q=80",
                    "https://images.unsplash.com/photo-1551969014-7d2c4cddf0b6?w=800&q=80",
                    "https://images.unsplash.com/photo-1589182373726-e4f658ab50f0?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1598524722512-0c0ccb5a533f?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Amuka Safari Lodge",
                        type = "Mid-range Lodge",
                        priceRange = "$120-200/night",
                        contact = "+256 772 468468",
                        distanceFromAttraction = "Inside the sanctuary",
                        rating = 4.4f
                    ),
                    Accommodation(
                        name = "Ziwa Guest House",
                        type = "Budget Guesthouse",
                        priceRange = "$40-80/night",
                        contact = "+256 782 123456",
                        distanceFromAttraction = "At sanctuary entrance",
                        rating = 4.1f
                    )
                )
            ),
            
            // 16. Mount Elgon National Park
            Attraction(
                id = 16,
                name = "Mount Elgon National Park",
                category = "Mountain & Hiking",
                location = "Eastern Uganda, on Kenya border",
                description = "Mount Elgon National Park protects an extinct volcano that once stood taller than Mount Kilimanjaro. At 4,321 meters, Mount Elgon features the largest volcanic base in the world (4,000 square kilometers) and one of the oldest and largest solitary volcanic mountains in East Africa. The mountain is home to unique attractions including the massive Wagagai Peak, hot springs, spectacular waterfalls, and the famous elephant caves where elephants venture deep underground to mine salt from the cave walls. The park offers excellent multi-day trekking routes through bamboo forests, moorlands, and alpine zones. Over 300 bird species including the endangered Lammergeier vulture inhabit the park. The Bagisu people's cultural heritage, including circumcision ceremonies, adds cultural richness to visits.",
                uniqueFeatures = listOf(
                    "Largest volcanic base in the world",
                    "Famous elephant salt-mining caves",
                    "Wagagai Peak (4,321m)",
                    "Hot springs and spectacular waterfalls",
                    "Over 300 bird species including rare Lammergeier"
                ),
                imageUrls = listOf(
                    "https://images.unsplash.com/photo-1486870591958-9b9d0d1dda99?w=800&q=80",
                    "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&q=80",
                    "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=800&q=80"
                ),
                thumbnailUrl = "https://images.unsplash.com/photo-1486870591958-9b9d0d1dda99?w=800&q=80",
                nearbyAccommodations = listOf(
                    Accommodation(
                        name = "Mount Elgon Hotel",
                        type = "Mid-range Hotel",
                        priceRange = "$80-150/night",
                        contact = "+256 772 509509",
                        distanceFromAttraction = "In Mbale town, 25 km from park",
                        rating = 4.3f
                    ),
                    Accommodation(
                        name = "Kapkwai Forest Exploration Centre",
                        type = "Budget Bandas",
                        priceRange = "$30-60/night",
                        contact = "+256 782 234567",
                        distanceFromAttraction = "At park entrance",
                        rating = 4.0f
                    )
                )
            )
        )
    }
    
    fun getAttractionById(id: Int): Attraction? {
        return getAllAttractions().find { it.id == id }
    }
    
    fun getAttractionsByCategory(category: String): List<Attraction> {
        return getAllAttractions().filter { it.category == category }
    }
    
    fun searchAttractions(query: String): List<Attraction> {
        return getAllAttractions().filter {
            it.name.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true) ||
            it.location.contains(query, ignoreCase = true)
        }
    }
    
    fun getAllCategories(): List<String> {
        return getAllAttractions().map { it.category }.distinct().sorted()
    }
}
