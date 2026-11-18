package com.gedo0x.weatherapp

enum class Theme {
    Material3,
    Cupertino
}

expect fun determineTheme(): Theme