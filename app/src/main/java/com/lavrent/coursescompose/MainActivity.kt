package com.lavrent.coursescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lavrent.coursescompose.model.Topic
import com.lavrent.coursescompose.ui.theme.CoursesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting()
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) { // Карточка
    Card { // Элемент карточка
        Row {  // Ряд
            Box { // Элемент контейнер
                Image( // Картинка
                    painter = painterResource(id = topic.imageRes), // Ресурс картинка
                    contentDescription = null, // Описание картинки
                    modifier = modifier  // Модификация
                        .size(width = 68.dp, height = 68.dp) // Размер по ширине и высоте
                        .aspectRatio(1f), // Соотношение между шириной и высотой (1: 1)
                    contentScale = ContentScale.Crop // Маштабирует изображене с сохранением шрины и высоты, тоесть они равны или больше сторон контейнера
                )
            }
            Column { // Столбец
                Text( // Текст
                    text = stringResource(id = topic.name), // Ресурс текста
                    style = MaterialTheme.typography.bodyMedium, // Стиль
                    modifier = Modifier.padding( // Модификатор отступа
                        start = dimensionResource(id = R.dimen.padding_medium), // в начале
                        top = dimensionResource(id = R.dimen.padding_medium), // сверху
                        end = dimensionResource(id = R.dimen.padding_medium), // в конце
                        bottom = dimensionResource(id = R.dimen.padding_small) // снизу
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) { // Ряд, с вертикальным выравниванием по середине
                    Icon(painter = painterResource(
                        id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_medium))
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesComposeTheme {
        TopicCard(topic = Topic(R.string.photography, 321, R.drawable.photography))
    }
}