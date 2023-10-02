package com.example.temperaturconverterapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemperatureConverterApp() {
    var celsius by remember { mutableStateOf(0.0) }
    var fahrenheit by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = celsius.toString(),
            onValueChange = { celsius = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Enter Celsius") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { fahrenheit = (celsius * 9/5) + 32 },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convert to Fahrenheit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Fahrenheit: $fahrenheit",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )
    }
}
