package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.R
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.model.WeatherItem
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.formatDate
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.formatDateTime
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.weatherforecastapp.utils.formatDecimals

@Composable
fun WeatherDetailRow(weather: WeatherItem) {
    val imageUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}.png"
    Surface(
        Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(formatDate(weather.dt).split(",")[0], modifier = Modifier.padding(start = 5.dp))
            WeatherStateImage(imageUrl = imageUrl)
            Surface(
                modifier = Modifier.padding(0.dp), shape = CircleShape,
                color = Color(0xffffc400)
            ) {
                Text(
                    weather.weather[0].description, modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue.copy(alpha = 0.7f), fontWeight = FontWeight.SemiBold)){
                    append(formatDecimals(weather.temp.max) + "o")
                }
            })
        }
    }
}

@Composable
fun SunsetSunriseRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "Sunrise",
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = formatDateTime(weather.sunrise),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun HumidityWindPressureRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "Humidity Icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${weather.humidity}%", style = MaterialTheme.typography.labelSmall)
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = "Pressure Icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${weather.pressure} psi", style = MaterialTheme.typography.labelSmall)
        }

        Row {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "Wind Icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${weather.humidity} mph", style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl), contentDescription = "Icon Image",
        modifier = Modifier.size(80.dp)
    )
}