package com.tamimattafi.backend.demo.api.controllers.pizza

object PizzaDatabase {
    private val pizzaList: List<PizzaEntity> = pizzaSet.mapIndexed { index, item ->
        PizzaEntity(
            index + 1,
            item.name,
            item.price,
            item.imageUrls,
            item.description
        )
    }

    val pizzaDao: PizzaDao = PizzaDao(pizzaList)
}

class PizzaDao(private val pizzaList: List<PizzaEntity>) {
    fun getAll(): List<PizzaEntity> = pizzaList

    fun getById(id: Int): PizzaEntity? = pizzaList.find { pizza -> pizza.id == id }

    fun <T> query(rawQuery: (List<PizzaEntity>) -> T): T = rawQuery(pizzaList)
}

data class PizzaOrder(
    val pizzaId: Int,
    val quantity: Int
)

data class PizzaEntity(
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrls: List<String>,
    val description: String
)

open class Pizza(
    val name: String,
    val price: Double,
    val imageUrls: List<String>,
    val description: String
)

val pizzaSet = listOf<Pizza>(
    Pizza(
        "Margarita",
        799.0,
        listOf("https://static.1000.menu/img/content-v2/ef/27/10853/picca-margarita-v-domashnix-usloviyax_1608783820_4_max.jpg"),
        "Pizza Margherita (more commonly known in English as Margherita pizza) is a " +
                "typical Neapolitan pizza, made with San Marzano tomatoes, mozzarella cheese, fresh " +
                "basil, salt, and extra-virgin olive oil."
    ),
    Pizza(
        "Detroit",
        999.0,
        listOf(
            "https://cdnimg.webstaurantstore.com/uploads/blog/2019/3/blog-types-pizza_in-blog-7.jpg",
            "https://pizzarini.info/wp-content/uploads/2018/06/Pizza-Margarita.jpg"
        ),
        "Reflecting the city’s deep ties to the auto industry, Detroit-style pizza was " +
                "originally baked in a square automotive parts pan in the 1940’s. Detroit pizza is " +
                "first topped with pepperoni, followed by brick cheese which is spread to the very " +
                "edges of the pan, yielding a caramelized cheese perimeter. Sauce is then spooned " +
                "over the pizza, an order similar to Chicago-style pizza. This pizza features a " +
                "thick, extra crispy crust that is tender and airy on the inside."
    ),
    Pizza(
        "Greek Pizza",
        699.0,
        listOf("https://cdnimg.webstaurantstore.com/uploads/blog/2016/8/onions.jpg"),
        "Greek pizza was created by Greek immigrants who came to America and were " +
                "introduced to Italian pizza. Greek-style pizza, especially popular in the New " +
                "England states, features a thick and chewy crust cooked in shallow, oiled pans, " +
                "resulting in a nearly deep-fried bottom. While this style has a crust that is " +
                "puffier and chewier than thin crust pizzas, it’s not quite as thick as a deep-dish " +
                "or Sicilian crust."
    ),
    Pizza(
        "New York-Style Pizza",
        560.0,
        listOf(
            "https://cdnimg.webstaurantstore.com/uploads/blog/2016/8/flat.jpg",
            "https://res.cloudinary.com/hsxfx8igq/image/upload/t_16x9_recipe_image,f_auto/v1596186263/NY-Pizza-Cheese_yx5njq.jpg",
            "https://www.seriouseats.com/thmb/0KPPWuXg2YBSqI0LjOIvmY11dKY=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__recipes__images__20101029-pizza-lab-primary-44ffa36fd2414f06abf5f16c11f14f1c.jpg"

        ),
        "With its characteristic large, foldable slices and crispy outer crust, " +
                "New York-style pizza is one of America’s most famous regional pizza types. " +
                "Originally a variation of Neapolitan-style pizza, the New York slice has taken " +
                "on a fame all its own, with some saying its unique flavor has to do with the " +
                "minerals present in New York’s tap water supply."
    ),
    Pizza(
        "California",
        910.0,
        listOf("https://cdnimg.webstaurantstore.com/uploads/buying_guide/2014/11/pizzatypes-gourmet.jpg"),
        "California pizza, or gourmet pizza, is known for its unusual ingredients. " +
                "This pizza got its start back in the late 1970’s when Chef Ed LaDou began " +
                "experimenting with pizza recipes in the classic Italian restaurant, Prego. He " +
                "created a pizza with mustard, ricotta, pate, and red pepper, and by chance, " +
                "served it to Wolfgang Puck. Impressed with LaDou’s innovative pie, Puck invited " +
                "him to be a head pizza chef at his restaurant. It was here that LaDou came up " +
                "with over 250 unique pizza recipes that eventually formed the menu of the chain " +
                "restaurant California Pizza Kitchen."
    ),
    Pizza(
        "Chicago",
        460.0,
        listOf(
            "https://cdnimg.webstaurantstore.com/uploads/buying_guide/2014/11/pizzatypes-deepdish.jpg",
            "https://media-cdn.tripadvisor.com/media/photo-s/11/3c/52/58/giordano-s.jpg",
            "https://munchies-images.vice.com/wp_upload/chicago-deep-dish-pizza-illustration.jpg?crop=1xw:0.7568421052631579xh;center,center",
            "https://cdn2.lamag.com/wp-content/uploads/sites/6/2020/03/Trio-Pie_1500x1000.jpg"
        ),
        "Chicago pizza, also commonly referred to as deep-dish pizza, gets its name " +
                "from the city it was invented in. During the early 1900’s, Italian immigrants in " +
                "the windy city were searching for something similar to the Neapolitan pizza that " +
                "they knew and loved. Instead of imitating the notoriously thin pie, Ike Sewell " +
                "had something else in mind. He created a pizza with a thick crust that had raised " +
                "edges, similar to a pie, and ingredients in reverse, with slices of mozzarella " +
                "lining the dough followed by meat, vegetables, and then topped with a can of " +
                "crushed tomatoes. This original creation led Sewell to create the now famous " +
                "chain restaurant, Pizzeria Uno."
    )
)