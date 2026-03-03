package com.example.lesson01.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Главный экран приложения.
 * Демонстрирует: Column/Row, Text, Button, Image и управление состоянием (remember + mutableStateOf).
 */
@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit
) {
    // Состояние счётчика — при изменении произойдёт recomposition
    var clickCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Заголовок
        Text(
            text = "Добро пожаловать!",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder для изображения (в реальном проекте — R.drawable.ic_launcher_foreground или своя картинка)
        // Image закомментирована, если нет ресурса — раскомментируйте и добавьте drawable
        // Image(
        //     painter = painterResource(id = R.drawable.ic_launcher_foreground),
        //     contentDescription = "Логотип",
        //     modifier = Modifier.size(80.dp)
        // )
        // Spacer(modifier = Modifier.height(24.dp))

        // Счётчик кликов — пример State и recomposition
        Text(
            text = "Нажатий: $clickCount",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { clickCount++ }) {
                Text("+1")
            }
            Button(onClick = { clickCount = 0 }) {
                Text("Сброс")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Переход на экран профиля
        Button(onClick = onNavigateToProfile) {
            Text("Перейти в профиль")
        }
    }
}
