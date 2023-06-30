package com.example.droneline.utils

import uz.roboticslab.droneline.R
import uz.roboticslab.droneline.models.Category
import uz.roboticslab.droneline.models.DroneWeb
import uz.roboticslab.droneline.models.InstData
import uz.roboticslab.droneline.models.VideoHome

object LoadList {
    fun getListOne(): List<Category> {
        val list = ArrayList<Category>()
        list.add(
            Category(
                1,
                R.string.virtual_drone,
                R.color.night_blue,
                R.drawable.drone_101
            )
        )
        list.add(
            Category(
                2,
                R.string.virtual_real,
                R.color.blue,
                R.drawable.real_virual
            )
        )
        list.add(Category(3, R.string.real_drone, R.color.white, R.drawable.drone_103))
        return list
    }

    fun getListTwo(): List<Category> {
        val list = ArrayList<Category>()
        list.add(Category(1, R.string.must_insturments, R.color.item1, R.drawable.drone_201))
        list.add(Category(2, R.string.drone_create, R.color.gray, R.drawable.drone_202))
        list.add(Category(3, R.string.launches, R.color.item23, R.drawable.zone_drone))
        return list
    }

    fun getListThree(): List<Category> {
        val list = ArrayList<Category>()
        list.add(
            Category(
                1,
                R.string.avia_model,
                R.color.unselected_tab_text_color,
                R.drawable.drone_301
            )
        )
        list.add(Category(2, R.string.rocket_model, R.color.item3, R.drawable.drone_302))
        list.add(Category(3, R.string.mility_drone, R.color.item1, R.drawable.drone_303))
        return list
    }

    fun getInstrumentList(): List<InstData> {
        val list = ArrayList<InstData>()
        list.add(
            InstData(
                1,
                "V9 RC Mini Drone 4k Dual Camera HD Wide Angle Camera 1080P" +
                        " WIFI FPV Aerial Photography Helicopter Foldable Quadcopter Dron Toys",
                "Aliexpress",
                "https://aliexpress.ru/item/1005003975651036.html?item_id=1005003975651036&sku_id=12000027615914585&spm=a2g2w.productlist.0.0.2d526195kRgmjR",
                "https://ae04.alicdn.com/kf/S273511eded4545f4b7197ddd1bc8a0f7f/V9-RC-Mini-Drone-4k-Dual-Camera-HD-Wide-Angle-Camera-1080P-WIFI-FPV-Aerial-Photography.jpg_640x640.jpg",
                "US \$129.90"
            )
        )
        list.add(
            InstData(
                2,
                "2022 New GPS Drone 4k Profesional 8K HD Camera 2-Axis Gimbal Anti-Shake Aerial Photography Brushless Foldable Quadcopter 1.2km",
                "Aliexpress",
                "https://aliexpress.ru/item/1005002448015853.html?spm=a2g2w.productlist.0.0.2d526195JTbABB&sku_id=12000027808733053",
                "https://ae04.alicdn.com/kf/Sdcd5c21785574e7b85b22afafe5a77ce7/2022-New-GPS-Drone-4k-Profesional-8K-HD-Camera-2-Axis-Gimbal-Anti-Shake-Aerial-Photography.jpg_640x640.jpg",
                "US \$152.45\n"
            )
        )
        list.add(
            InstData(
                1,
                "Best KF105 GPS 8K Drone Professional Camera 5G WIFI FPV 1.2KM Distance Brushless Motor Auto Obstacle Avoidance Rc Quadcopter",
                "Aliexpress",
                "https://aliexpress.ru/item/1005003452216781.html?spm=a2g2w.productlist.0.0.2d526195JTbABB&sku_id=12000025853387435",
                "https://ae04.alicdn.com/kf/H4b6c7e447e9b4169be637163f092cea0X/Best-KF105-GPS-8K-Drone-Professional-Camera-5G-WIFI-FPV-1-2KM-Distance-Brushless-Motor-Auto.jpg_640x640.jpg",
                "US \$90.62"
            )
        )
        list.add(
            InstData(
                4,
                "Smart Altitude Hold helicopter 4K HD WiFi Camera RC Quadcopter APP Control One Key Takeoff/Landing 150M Foldable V10 RC Drone",
                "Aliexpress",
                "https://aliexpress.ru/item/1005003024980836.html?spm=a2g2w.productlist.0.0.2d526195JTbABB&sku_id=12000023301551197",
                "https://ae04.alicdn.com/kf/Hf0e9f07f73a7484da9abbdb6506e50cbA/Smart-Altitude-Hold-helicopter-4K-HD-WiFi-Camera-RC-Quadcopter-APP-Control-One-Key-Takeoff-Landing.jpg_640x640.jpg",
                "US \$29.79\n"
            )
        )
        list.add(
            InstData(
                5,
                "V20 Mini Drone 4K Profesional HD Camera Wifi FPV Foldable Dron Quadcopter One-Key Return 360 Rolling RC Helicopter Kids Toy",
                "Aliexpress",
                "https://aliexpress.ru/item/1005003812383311.html?spm=a2g2w.productlist.0.0.2d526195JTbABB&sku_id=12000027249774483",
                "https://ae04.alicdn.com/kf/S8d409cd322e84a928597065426fe0ec1i/V20-Mini-Drone-4K-Profesional-HD-Camera-Wifi-FPV-Foldable-Dron-Quadcopter-One-Key-Return-360.jpg",
                "US \$27.71"
            )
        )
        list.add(
            InstData(
                6,
                "V8 New Mini Drone 4K 1080P HD Camera WiFi Fpv Air Pressure Height Maintain Foldable Quadcopter RC Dron Toy Gift",
                "Aliexpress",
                "https://aliexpress.ru/item/1005003885098274.html?spm=a2g2w.productlist.0.0.2d526195JTbABB&sku_id=12000027386783852",
                "https://ae04.alicdn.com/kf/S5ee919cbb1d140b0bce7568d93ceb079P/V8-New-Mini-Drone-4K-1080P-HD-Camera-WiFi-Fpv-Air-Pressure-Height-Maintain-Foldable-Quadcopter.jpg_640x640.jpg",
                "US \$17.16"
            )
        )
        list.add(
            InstData(
                7,
                "20g Ultralight Flywoo Firefly 1S Na no Baby Quad 40mm FPV Drone BNF w/ GOKU Versatile F4 5In1 1S AIO Flight Controller 250mW VTX",
                "Aliexpress",
                "https://aliexpress.ru/item/1005003170763090.html?spm=a2g2w.productlist.0.0.2d526195JTbABB&sku_id=12000027267156476",
                "https://ae04.alicdn.com/kf/Ha40c3061ff6844e7bf7922d8440bfad1G/20g-Ultralight-Flywoo-Firefly-1S-Na-no-Baby-Quad-40mm-FPV-Drone-BNF-w-GOKU-Versatile.jpg",
                "US \$111.99"
            )
        )
        return list
    }

    fun getLearnDroneVideo(): List<VideoHome> {
        val list = ArrayList<VideoHome>()
        list.add(
            VideoHome(
                "UZWrUi-SWCM",
                "The SkyLite - A 3-inch Whoop BEAST! - BUILD",
                "Ushbu dronni o'zingiz qurmoqchimisiz? Mustaqil ramka VA to'liq qurilish to'plami hozirda mavjud!",
                "https://i.ytimg.com/vi/UZWrUi-SWCM/mqdefault.jpg"
            )
        )

        list.add(
            VideoHome(
                "SrfPPgAOtoY&t=8s",
                "DJI FPV | First Flight and Beginner's Guide - Start Flying a DJI FPV!",
                "DJI FPV is a groundbreaking ready-to-fly FPV drone that lets users of any skill level feel the thrill of immersive flight. Features like an intuitive Motion Controller",
                "https://i.ytimg.com/vi/SrfPPgAOtoY/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "FHk5PEZAyMA",
                "\$15 Drone Build within 24 Hour - Challenge",
                "In this video I have taken up a request from a guy, Basically he wanted to invent a drone DIY kit that costs no more than \$15 to build!",
                "https://i.ytimg.com/vi/FHk5PEZAyMA/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "SfFl_-tof4Y",
                "How to Build Ultimate Budget FPV Drone Build 2021 // Beginner Guide",
                "FC & ESC: https://bit.ly/3xEs15d\n" +
                        "iFlight Frame: https://bit.ly/2FtWexy\n" +
                        "VTX: https://bit.ly/32ULxgd",
                "https://i.ytimg.com/vi/SfFl_-tof4Y/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "2-kumAyvdAs",
                "Drone yashashni organamiz-1",
                "Drone yaratisni 0 dan o'rganamiz.",
                "https://i.ytimg.com/vi/2-kumAyvdAs/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "P7ZnCgl5o2Y",
                "Uy sharoitida drone yasash",
                "Dronda yasahsga kerak bo'ladigan buyumlar",
                "https://i.ytimg.com/vi/P7ZnCgl5o2Y/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "jEMaVnk8W5Y",
                "Drone yashashni organamiz-3",
                "Eng yaxshi drondi qanday yasaymiz",
                "https://i.ytimg.com/vi/jEMaVnk8W5Y/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "R6IqFAztyEk",
                "KICHKINA DRON Jjrc H49 | AliExpressdan MINI DRON",
                "Drone yaratisni 0 dan o'rganamiz.",
                "https://i.ytimg.com/vi/R6IqFAztyEk/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "VkTqY2mbZ_o",
                "Mini drone qanday yasaladi.",
                "Drone yaratisni 0 dan o'rganamiz.",
                "https://i.ytimg.com/vi/VkTqY2mbZ_o/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "UtdYFpVYq3A",
                "Drone yasalishi bilan tanishamiz",
                "Drone yaratisni 0 dan o'rganamiz.",
                "https://i.ytimg.com/vi/UtdYFpVYq3A/sddefault.jpg"
            )
        )
        return list
    }

    fun getAviaModel(): List<VideoHome> {
        val list = ArrayList<VideoHome>()
        list.add(
            VideoHome(
                "3U_9-OLpyrc",
                "JWM 2013. Второй Чемпионский титул!",
                "English version here - http://youtu.be/m9f1ov3pdCc Накал борьбы, радость победы, все это видно в этом 16-минутном фильме",
                "https://i.ytimg.com/vi/3U_9-OLpyrc/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "n1pNwOFgU5M",
                "How to make foam airplane | Как сделать самолетик из пенопласта",
                "Assalomu alaykum birodarlarim arzimagan mehnatimizni qadirlab kanalimizga obuna bo'ling sizlar bilan millionlar dovonini bosib o'tamiz Aviamodel chizmasi \uD83D\uDC49",
                "https://i.ytimg.com/vi/n1pNwOFgU5M/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "_YrP_k0g7sM",
                "Aviamodel tayyorlash Buxoro shahar BAM",
                "Aviamodel haqida va uni tayorlanish jarayoni",
                "https://i.ytimg.com/vi/_YrP_k0g7sM/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "0_Cgxy7N-V0",
                "FANTASTIC Russian Mikoyan MiG-29 FORMATION PAIR/DUO with OVT VECTORED THRUST Demo",
                "Eng kuchli aviamodellar.",
                "https://i.ytimg.com/vi/0_Cgxy7N-V0/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "VwRnvUMSIZE",
                "AviaModel",
                "Yasalgan aviamodeldan master class.",
                "https://i.ytimg.com/vi/VwRnvUMSIZE/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "-EflhxXSGMk",
                "Eng yaxshi aviamodel",
                "",
                "https://i.ytimg.com/vi/-EflhxXSGMk/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "bIkeCEFdVhY",
                "Авиамодель И-16 тетрис",
                "Авиамодель И-16 тетрис. Это третья часть постройки авиамодели И-16 из пеноплекса.",
                "https://i.ytimg.com/vi/bIkeCEFdVhY/sddefault.jpg"
            )
        )
        return list
    }

    fun getList(): List<VideoHome> {
        val list = ArrayList<VideoHome>()
        list.add(
            VideoHome(
                "aj2Rge_QTjs",
                "TURKIYANING XAVFLI QUROLI BAYRAKTAR TB2 HAQIDA TO'LIQ MA'LUMOT",
                "Turkiyaning BAYRAKTAR TB 2 quroli haqida to‘liqroq aytib berishga harakat qilaman.",
                "https://i.ytimg.com/vi/aj2Rge_QTjs/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "YSy0wJv6u70",
                "How Turkey's Bayraktar TB2 Drones Became an International Success",
                "Turkey's Bayraktar TB2 Drones have become an international success over the",
                "https://i.ytimg.com/vi/YSy0wJv6u70/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "mEFEzqs2MXA",
                "Bayraktar Akinci B is fully combat ready - more lethal than Tb2",
                "Turkey’s landmark combat drone AKINCI on Wednesday underwent a successful flight test, and AKINCI drones are now combat ready with upgraded engines that make",
                "https://i.ytimg.com/vi/mEFEzqs2MXA/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "jOet9BwJWbk",
                "Turkish Bayraktar TB2 VS Russian Orion-E Combat Drone | UAV",
                "Turkish Bayraktar TB2 VS Russian Orion-E Combat Drone | Unmanned Aerial Vehicle | UAV This video you will see a comparison between two unmanned aerial combat vehicle.",
                "https://i.ytimg.com/vi/jOet9BwJWbk/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "nlebVZqKwKQ",
                "The second wave of Bayraktar TB2 troops has arrived and is ready at combat position - Russia panic",
                "Recently, there was the latest information if Ukraine received additional Bayraktar TB2 drone. The Ukrainian Ministry of Defense said; that the country's Armed Forces received additional",
                "https://i.ytimg.com/vi/nlebVZqKwKQ/sddefault.jpg"
            )
        )
        return list
    }

    fun getRaketaModel(): List<VideoHome> {
        val list = ArrayList<VideoHome>()
        list.add(
            VideoHome(
                "D66xKCXIUKA",
                "Raktelarni turkiyadagi modellari.",
                "Start modelu dvoustupňové rakety HERKULES - pohon 6x raketový motorek ROS40",
                "https://i.ytimg.com/vi/D66xKCXIUKA/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "EHviFIezV6o",
                "Умные ракеты",
                "Друзья, ещё раз убеждаюсь, что изобретая что-либо, никогда не будешь знать, чем это закончится.",
                "https://i.ytimg.com/vi/EHviFIezV6o/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "uPCi5Rs7EuA    ",
                "Model Rocket Battle 2 | Dude Perfect",
                "Launching giant model rockets is our new favorite hobby! ► Click HERE to subscribe to Dude Perfect!",
                "https://i.ytimg.com/vi/uPCi5Rs7EuA/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "frvV6LnNM0g",
                "Space Shuttle Scale model RC - Flight at Manching 2017",
                "Space shuttle RC, Scale Model, radio controlled glider",
                "https://i.ytimg.com/vi/frvV6LnNM0g/mqdefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "K1126lvNvHw",
                "AWESOME ROCKET LAUNCH!! NEW SAB AVIO LIZARD DEMO SHOW FLIGHT",
                "The SAB show is back! Awesome radio controlled rocket launcher for the new SAB Avio Lizard rc turbine jet! Enjoy this stunning demo slot from SAB on Jet Power 2019, Germany!!",
                "https://i.ytimg.com/vi/K1126lvNvHw/sddefault.jpg"
            )
        )
        list.add(
            VideoHome(
                "nlVcAJFU-5E",
                "STEVE EVES SATURN V MODEL ROCKET RECORD FLIGHT VIDEO Roy Dawson",
                "Buying or seling a home in the DFW area? Give us a call. YOU GOTTA SEE THIS HUGE MODEL ROCKET FLY. A 1/10 SCALE MODEL ROCKET. IT WEIGHS ",
                "https://i.ytimg.com/vi/nlVcAJFU-5E/hqdefault.jpg"
            )
        )
        return list
    }

    fun getWebSite(): List<DroneWeb> {
        val list = ArrayList<DroneWeb>()
        list.add(
            DroneWeb(
                1,
                "UAV Coach",
                R.string.web_1,
                "https://uavcoach.com/",
                "https://c-dp.org/wp-content/uploads/2020/10/UAV-Coach-Logo-colors-Blue1-copy.jpg"
            )
        )
        list.add(
            DroneWeb(
                2,
                "ArduPilot",
                R.string.web_2,
                "https://ardupilot.org/",
                "https://firmware.ardupilot.org/Tools/Logos/ardu_logo_dark.png"
            )
        )
        list.add(
            DroneWeb(
                3,
                "FPV Frenzy",
                R.string.web_3,
                "https://fpvfrenzy.com/",
                "https://1000logos.net/wp-content/uploads/2021/01/FPV-logo.png"
            )
        )
        list.add(
            DroneWeb(
                4,
                "Coursera Course - Aerial Robotics",
                R.string.web_4,
                "https://www.coursera.org/lecture/robotics-flight/unmanned-aerial-vehicles-V136S",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Coursera-Logo_600x600.svg/2048px-Coursera-Logo_600x600.svg.png"
            )
        )
        list.add(
            DroneWeb(
                5,
                "Maker Pro",
                R.string.web_5,
                "https://maker.pro/projects/category/drones",
                "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/00e6b368781285.5b696980325b4.jpg"
            )
        )
        list.add(
            DroneWeb(
                6,
                "WeDroneT",
                R.string.web_6,
                "https://www.apollo.io/companies/WeDroneT--The-Social-Network-for-Drones--RC-Models-and-Robotic-/5e562a8d8c394e0001d50af0",
                "https://static.wixstatic.com/media/4e0ee1_3557fbefafde4924bb088bc5fd7b9026~mv2.png/v1/fill/w_322,h_190,al_c,usm_0.66_1.00_0.01,enc_auto/We-Drone%20Logo%20Final.png"
            )
        )
        list.add(
            DroneWeb(
                7,
                "Drone Flyers",
                R.string.web_7,
                "https://www.droneflyers.com/",
                "https://cdn5.f-cdn.com/contestentries/958438/13396678/58adf6c624992_thumb900.jpg"
            )
        )
        return list
    }

    fun getDroneStories(): List<DroneWeb> {
        val list = ArrayList<DroneWeb>()
        list.add(
            DroneWeb(
                1,
                "DJI",
                R.string.stories_1,
                "https://www.dji.com/",
                "https://www1.djicdn.com/dps/de46652dd99c67d4f8d17607e3bf0dce.jpg"
            )
        )
        list.add(
            DroneWeb(
                2,
                "Parrot",
                R.string.stories_2,
                "https://www.parrot.com/us/drones",
                "https://logovectordl.com/wp-content/uploads/2021/03/parrot-drone-sas-logo-vector.png"
            )
        )
        list.add(
            DroneWeb(
                3,
                "RcBazaar",
                R.string.stories_3,
                "http://rcbazaar.com/product.aspx?productid=4787",
                "https://www.siteprice.org/SiteThumbs/r/rcbazaar.com.jpeg"
            )
        )
        list.add(
            DroneWeb(
                4,
                "RC Mumbai",
                R.string.stories_4,
                "https://rcmumbai.com/",
                "https://furiousfpv.com/images/dealers/dealerimg_159.png"
            )
        )
        list.add(
            DroneWeb(
                5,
                "HobbyXyz",
                R.string.stories_5,
                "https://xyzhobby.com/?s=drone&post_type=product&type_aws=true",
                "https://xyzhobby.com/wp-content/uploads/2021/10/cropped-logo2-1.png"
            )
        )
        list.add(
            DroneWeb(
                6,
                "Robokits",
                R.string.stories_6,
                "https://robokits.co.in/",
                "https://robokits.co.in/includes/templates/robokits/images/uploads/Robokits_Logo_320x80_opt_trns_1587550612.png"
            )
        )
        list.add(
            DroneWeb(
                7,
                "Pooja Elecrtronics",
                R.string.stories_7,
                "https://poojaelectronics.in/product-category/drones-gimbal/",
                "https://poojaelectronics.in/wp-content/uploads/2020/12/Pooja-Electronics-Logo.png"
            )
        )

        return list
    }
}