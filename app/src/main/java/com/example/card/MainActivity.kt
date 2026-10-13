package com.example.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CardProjectScreen()
            }
        }
    }
}

@Composable
fun CardProjectScreen() {
    // Contenedor principal desplazable que incluye todas las secciones solicitadas
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 1 y 2. Card Principal (Imagen, títulos y botones)
        item {
            MainCard()
        }

        // 3. LazyRow (8 componentes horizontales)
        item {
            HorizontalComponentsRow()
        }

        // Título intermedio de la lista
        item {
            Text(
                text = "Title of Card",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // 4. LazyColumn (10 elementos verticales)
        items(10) { index ->
            VerticalListItem(index = index + 1)
        }
    }
}

@Composable
fun MainCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBEBEB)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Imagen circular + Textos
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Imagen circular
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFCCCCCC))
                )

                // Título y Subtítulo
                Column {
                    Text(
                        text = "Title of Card",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Text text and\nmore subtex",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            // Botones horizontales alineaos a la derecha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End)
            ) {
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray)
                ) {
                    Text("Button")
                }

                Button(
                    onClick = { },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF64B5F6),
                        contentColor = Color.White
                    )
                ) {
                    Text("Button")
                }
            }
        }
    }
}

@Composable
fun HorizontalComponentsRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Genera los 8 elementos horizontales solicitados
        items(8) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFCCCCCC))
            )
        }
    }
}

@Composable
fun VerticalListItem(index: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFCCCCCC))
    )

}
