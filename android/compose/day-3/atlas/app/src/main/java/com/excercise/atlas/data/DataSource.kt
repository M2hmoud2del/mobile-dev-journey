package com.excercise.atlas.data

import com.excercise.atlas.R
import com.excercise.atlas.model.Country

class DataSource {

    fun getCountriesList() = listOf(
        Country(R.string.canada,R.drawable.canada,48.8423216,-135.4991366),
        Country(R.string.egypt,R.drawable.egypt,26.8074358,25.5841531),
        Country(R.string.morocco,R.drawable.morocco,31.6914008,-12.4416121),
        Country(R.string.switzerland,R.drawable.switzerland,46.8056098,6.9050506),
    )
}