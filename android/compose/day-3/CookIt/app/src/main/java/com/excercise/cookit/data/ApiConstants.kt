package com.excercise.cookit.data

object ApiConstants {
    const val BASE_URL = "https://www.themealdb.com/"

    const val CATEGORIES_ENDPOINT = "api/json/v1/1/categories.php"
    const val FILTER_ENDPOINT = "api/json/v1/1/filter.php"

    const val CATEGORY_QUERY = "c"
    const val CATEGORY_ID = "idCategory"
    const val CATEGORY_NAME = "strCategory"
    const val CATEGORY_IMAGE = "strCategoryThumb"

    const val FOODS = "meals"
    const val FOOD_ID = "idMeal"
    const val FOOD_NAME = "strMeal"
    const val FOOD_IMAGE = "strMealThumb"

}