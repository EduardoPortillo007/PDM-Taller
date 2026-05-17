package com.example.foodspot.data.repository

import com.example.foodspot.data.model.Dish
import com.example.foodspot.data.model.Restaurant

val sampleRestaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Place",
        description = "Las mejores pizzas artesanales de la ciudad",
        imageUrl = "https://images.unsplash.com/photo-1611915365928-565c527a0590?q=80&w=1025",
        categories = listOf("Italiana", "Pizzas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Margarita",
                description = "Mozzarella, albahaca y tomate fresco",
                imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Pizza Pepperoni",
                description = "Pepperoni con queso mozzarella derretido",
                imageUrl = "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Pizza  3 queso",
                description = "Pizza con queso mozzarella, especial y cheddar derretido",
                imageUrl = "https://www.cafeteriacardeña.es/wp-content/uploads/2023/05/pizza-3-quesos.jpg?q=80&w=1176"
            )
    )
    ),
    Restaurant(
        id = 2,
        name = "Charly Boy",
        description = "Pizza & Grill",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZK3PtIXOE5INZ9d9cCKORLfzNxRsUptHFAQ&s",
        categories = listOf("Hamburguesa", "Pizzas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Costilla Burguer",
                description = "Hamburguesa con una costilla de res",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKcOgdRd2LKoPi3QinUZLsgCEmDfbwtDbODg&s?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Mega Pizza",
                description = "Camarones y calamar con queso mozzarella derretido",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzGJNyocw9QB1cNGb-kLXaLbTYFTmdqhgnCA&s?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Hongo Burguer",
                description = "Hamburguesa con hongos queso blanco y papas",
                imageUrl = "https://comelongo.com/wp-content/uploads/2021/07/173111409_1186215658476979_1470450463186119128_n-580x408.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "Sweet Place",
        description = "Los postres más deliciosos para comer con la boca",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4Cj3BucZ437iQLFOeB3OtcGFwrIsNEyMBJw&s",
        categories = listOf("Postres"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Orden de Macarrons",
                description = "Pequeños aperitivos para compartir en pareja",
                imageUrl = "https://content.elmueble.com/medio/2024/08/19/macarons_97142b68_240819132215_900x900.jpg?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Fresas Bañadas",
                description = "Cupcake con chocolate blanco, fresa y chocolate con leche",
                imageUrl = "https://images.aws.nestle.recipes/resized/2024_10_23T08_34_55_badun_images.badun.es_pastelitos_de_chocolate_blanco_y_queso_con_fresas_1290_742.jpg?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Flan",
                description = "Un flan, qué más esperas que diga?",
                imageUrl = "https://static.bainet.es/clip/b3127ed1-d705-4f60-bc71-ac7cff37f5f3_source-aspect-ratio_1600w_0.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 4,
        name = "Pollo Infeliz",
        description = "Los mejores pollos para pasarla mal y triste",
        imageUrl = "https://pbs.twimg.com/media/GqbbN_TW0AAe7Fy.png",
        categories = listOf("Pollo", "Postres"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pollo Fit",
                description = "Pechuga de pollo con arroz blanco",
                imageUrl = "https://www.recetasnestlecam.com/sites/default/files/2022-08/recetas-con-pechuga-de-pollo_0.jpg?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Tarta de mango",
                description = "Pequeño aperitivo dulce de 6 piezas",
                imageUrl = "https://imag.bonviveur.com/presentacion-final-de-la-tarta-de-mango-y-pina.jpg?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Familia Pollo",
                description = "Plato de 12 piezas de pollo frito para compartir con la familia, o para un gordo",
                imageUrl = "https://s2.ppllstatics.com/diariovasco/www/multimedia/202206/29/media/cortadas/fried-chicken-RYdc0WA3QvppgoJVld2G3VM-1248x770@Diario%20Vasco.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 5,
        name = "Shrek Pizza",
        description = "Las mejores pizzas del pantano",
        imageUrl = "https://preview.redd.it/shreks-pizza-v0-fpub8313fek81.jpg?width=640&crop=smart&auto=webp&s=728e6fad0e561ea5d8f8e46e30b7d40c87ef1eb4",
        categories = listOf("Pizzas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Amongus",
                description = "Pizza sospechosa con salchica y queso abudante",
                imageUrl = "https://i.pinimg.com/170x/0e/16/3e/0e163e31a47b470bf7df0c265a438372.jpg?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Pizza Libertad",
                description = "Deliciosa pizza con queso, pescado y chiles",
                imageUrl = "https://i.imgur.com/4ymKK2E.jpg ? q =80& w =1176"
            ),
            Dish(
                id = 3,
                name = "Pizza Taco",
                description = "Pizza en forma de taco con queso, carne y cebollita caramelizada",
                imageUrl = "https://www.recreoviral.com/wp-content/uploads/2016/09/2-72-636x700.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 6,
        name = "Freddy Fazbear's Pizza",
        description = "Pizzas de varierdad y juegos mecanicos",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHS4r--BSXOcTu2IyGc1FHDi9YxAY0zBVoLA&s",
        categories = listOf("Pizzas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Hawaii con Pizza",
                description = "Rica piña con un poco de pizza",
                imageUrl = "https://img.wattpad.com/f9edf4da973589cbe26ff0c18b21608c742a0c03/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f65645359536b79754139634645673d3d2d3639363330393635332e313538343934333136353632343132343735343031383231313030332e6a7067?s=fit&w=720&h=720?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Pizza Capital",
                description = "Aberración de pizza con todo",
                imageUrl = "https://i.redd.it/jnc5zq59xvp41.jpg?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Pizza Ecuatoriana",
                description = "Pizza con salchica, piña y banana con queso derretido",
                imageUrl = "https://i.pinimg.com/736x/81/4b/e4/814be46a1234acbeeb12330fb1942baa.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 7,
        name = "Pollos Hermanos",
        description = "Venta de pollos a bajo precio(no es para nada un lavado de dinero)",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSientdDH2E2U01fPNX8TtIw9S8Sd2gVDk_9g&s",
        categories = listOf("Pollo"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Patas de Pollo",
                description = "Ricas patitas de pollo con frijolitos y nachos",
                imageUrl = "https://i.ytimg.com/vi/2_XT3SrM7Uk/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLB3pYyZO2jEXfG0Lg-64XCfRZEdsQ"
            ),
            Dish(
                id = 2,
                name = "Empanada de pollo",
                description = "Empanada crujiente con relleno de pollo y verduras",
                imageUrl = "https://www.recetasderechupete.com/wp-content/uploads/2012/02/empanada-de-pollo-portada-1200x828.png?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 8,
        name = "Italian Craft",
        description = "Comida italiana al mejor precio sin mobs hostiles",
        imageUrl = "https://i.ytimg.com/vi/IsKW5eVKclc/maxresdefault.jpg",
        categories = listOf("Italiana", "Pizzas", "Pollo"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Mix para compratir",
                description = "Bandeja jummbo de porciones para compartir, con pollo, pan,carne, papas, etc",
                imageUrl = "https://i.pinimg.com/1200x/e5/98/81/e59881515a2e886fa9b4c37313a71aaf.jpg?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Pasta Penne",
                description = "Penne con salsa blanca para compartir con la familia",
                imageUrl = "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/0f7c0163c4e25857cf7cf53ae1447a2a.jpg?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Lasaña con carne",
                description = "Rica lasaña italiana concarne y 3 quesos",
                imageUrl = "https://www.viajaraitalia.com/wp-content/uploads/2009/09/lasagna.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 9,
        name = "67 Bakers",
        description = "Postres y pasteles",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj4glSZ1PljeXcStnkAYHkufnuJCx12lPUjw&s",
        categories = listOf("Postres"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pastel de Oreo",
                description = "Rico pastel de vainilla helado y Oreo",
                imageUrl = "https://servinox.com.mx/blog/wp-content/uploads/2019/02/cheessecake-oreo-1024x773.jpg?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Rollitos",
                description = "Rollitos de masa dulce con Maicena y leche",
                imageUrl = "https://cdn.elcocinerocasero.com/imagen/receta/1000/2025-02-20-16-39-40/canas-fritas-rellenas-de-crema.jpeg?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Cheescake",
                description = "Cheescake con maracuya",
                imageUrl = "https://ducales.com.co/wp-content/uploads/2019/01/receta-1.jpg?q=80&w=1176"
            )
        )
    ),
    Restaurant(
        id = 10,
        name = "Pinulito",
        description = "El GOAT de los pollos",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYDuqSGRmnvs7MWovarPJT4-Q8-ABPsqPatQ&s",
        categories = listOf("Pollo"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Papitas",
                description = "Acompañantes para muchos menús",
                imageUrl = "https://i0.wp.com/pinulito.com.sv/wp-content/uploads/2024/09/PAPA-FRITA-POLLO-PINULITO.png?fit=1000%2C1000&ssl=1?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Poporopos",
                description = "Nuggets fritos de pollo",
                imageUrl = "https://i0.wp.com/pinulito.com.sv/wp-content/uploads/2024/11/POPOROPOS.webp?fit=1080%2C1080&ssl=1?q=80&w=1176"
            ),
            Dish(
                id = 3,
                name = "Papas Locas",
                description = "Dos papas normales con aderezos fuertes y picantes",
                imageUrl = "https://i0.wp.com/pinulito.com.sv/wp-content/uploads/2024/11/PAPAS-LOCAS.webp?fit=1080%2C1080&ssl=1?q=80&w=1176"
            )
        )
    )

)
