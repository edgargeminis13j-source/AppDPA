package com.example.appdpa.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.appdpa.data.model.CountryModel

val mockCountries = listOf(
    CountryModel("Colombia",11,"https://flagcdn.com/w320/co.png"),
    CountryModel("Ecuador",13,"https://flagcdn.com/w320/ec.png"),
    CountryModel("Peru",60,"https://flagcdn.com/w320/pe.png"),
    CountryModel("Venezuela",40,"https://flagcdn.com/w320/ve.png"),
    CountryModel("Bolivia",38,"https://flagcdn.com/w320/bo.png"),
    CountryModel("Chile",70,"https://flagcdn.com/w320/cl.png"),
    CountryModel("Argentina",1,"https://flagcdn.com/w320/ar.png"),
)
@Composable
fun HomeScreen(){
    Column (
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla para mejor centrado
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Ranking FIFA 2025"
            ,style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn{
            items(mockCountries){ country ->
                Card(
                    modifier = Modifier.fillMaxSize().padding(vertical = 8.dp)
                ){
                    Row(modifier = Modifier.padding(12.dp)){
                        Image(
                            painter = rememberAsyncImagePainter(country.imageUrl),
                            contentDescription = country.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(64.dp)
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)){
                            Text(country.name, style = MaterialTheme.typography.titleMedium)
                            Text(country.ranking.toString(), style = MaterialTheme.typography.titleSmall)
                        }
                    }
                }
            }
        }
    }
}