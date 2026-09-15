package com.excercise.atlas

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.excercise.atlas.data.DataSource
import com.excercise.atlas.model.Country
import com.excercise.atlas.ui.theme.AtlasTheme
import com.excercise.atlas.ui.theme.SmokedSteel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtlasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    CountriesList(
                        countries = DataSource().getCountriesList(),
                        modifier = Modifier
                            .paint(
                                painter = painterResource(R.drawable.background),
                                contentScale = ContentScale.Crop
                            )
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CountriesList(countries: List<Country>, modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current

    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(countries){
                CountryListItem(it)
            }
        }
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            items(countries){
                CountryListItem(it)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CountriesListPreview() {
    CountriesList(DataSource().getCountriesList())
}

@Composable
fun CountryListItem(country: Country,modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.TopCenter,
    ){
        Image(
            painter = painterResource(R.drawable.card),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clickable {
                    val location = "geo:${country. latitude}, ${country.longitude}?z=5"
                    val i = Intent( Intent.ACTION_VIEW, location.toUri())
                    context.startActivity( i)
                }
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(country.flag),
                contentDescription = stringResource(country.name),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(140.dp, 90.dp)
            )
            Text(
                text = stringResource(country.name),
                fontFamily = FontFamily(Font(R.font.handodle)),
                fontSize = 44.sp,
                color = SmokedSteel,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CountryListItemPrev() {
    CountryListItem(DataSource().getCountriesList()[0])
}