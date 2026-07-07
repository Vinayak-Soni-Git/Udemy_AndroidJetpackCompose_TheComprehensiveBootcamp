package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.data.DataOrException
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.Weather
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.WeatherItem
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.navigation.WeatherScreens
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.formatDate
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.formatDecimals
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.widgets.HumidityWindPressureRow
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.widgets.SunsetSunriseRow
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.widgets.WeatherAppBar
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.widgets.WeatherDetailRow
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.widgets.WeatherStateImage

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    city: String?
) {
    val weatherData = produceState(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getWeatherData(city = city.toString())
    }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        MainScaffold(weather = weatherData.data!!, navController)
    }
}

@Composable
fun MainScaffold(weather: Weather, navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = "India",
            icon = Icons.Default.ArrowBack,
            navController = navController,
            onAddActionClicked = {
                navController.navigate(WeatherScreens.SearchScreen.name)
            },
            elevation = 5.dp
        )
    }) {
        MainContent(data = weather)
        Text(modifier = Modifier.padding(it), text = "")
    }
}

@Composable
fun MainContent(data: Weather) {
    val imageUrl = "https://openweathermap.org/img/wn/10d.png"
    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatDate(data.list[0].dt), style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSecondary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )

        Surface(
            modifier = Modifier
                .padding(4.dp)
                .size(200.dp), shape = CircleShape,
            color = Color(0xFFFFC400)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherStateImage(imageUrl = imageUrl)
                Text(
                    formatDecimals(data.list[0].temp.day) + "°",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = data.list[0].weather[0].main, fontStyle = FontStyle.Italic)
            }
        }
    }
    HumidityWindPressureRow(weather = data.list[0])
    Divider()
    SunsetSunriseRow(weather = data.list[0])
    Text("This Week", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xffeef1ef),
        shape = RoundedCornerShape(size = 14.dp)
    ) {
        LazyColumn(modifier = Modifier.padding(2.dp), contentPadding = PaddingValues(1.dp)) {
            items(items = data.list) { item: WeatherItem ->
                WeatherDetailRow(weather = item)
            }
        }
    }
}