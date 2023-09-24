package ui.select

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.WordViewModel
import utils.AudioPlayer
import utils.Colors
import utils.vibrate

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SelectWordScreen(
    onOpenWordsClicked: () -> Unit,
    viewModel: WordViewModel
) {
    val itemsListState by viewModel.allWords.collectAsState()
    val player = AudioPlayer()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Словарный запас",
                    fontSize = 17.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.01.sp,
                    textAlign = TextAlign.Center
                )
            }
        },
        bottomBar = {
            Button(
                onClick = {
                    vibrate()
                    onOpenWordsClicked.invoke()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(Colors.BLUE), contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                    .height(52.dp)
                    .fillMaxWidth(1f)
                    .clip(RoundedCornerShape(CornerSize(10.dp))),
            ) {
                Text(
                    text = "Далее",
                    fontSize = 17.sp,
                    letterSpacing = 0.01.sp,
                )
            }
        }
    ) { paddings ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(horizontal = 16.dp)
        ) {
            item {
                Text(
                    modifier = Modifier.padding(vertical = 16.dp).fillMaxWidth(),
                    text = "Выбери слова для изучения",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    letterSpacing = 0.01.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

            items(itemsListState.size) { index ->
                val item = itemsListState[index]
                var selected by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth(1f)
                        .clip(RoundedCornerShape(CornerSize(16.dp)))
                        .border(
                            width = 1.dp,
                            color = Color(Colors.LITE_GRAY),
                            shape = RoundedCornerShape(CornerSize(16.dp))
                        )
                        .clickable(true) {
                            if (selected) {
                                viewModel.removeWord(item)
                            } else {
                                viewModel.addWord(item)
                            }

                            selected = !selected
                        }
                        .background(
                            if (selected) Color(Colors.GREEN_8)
                            else Color.White
                        ),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(0.8f),
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                            text = item.origin,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            letterSpacing = 0.01.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                            text = item.translated,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            letterSpacing = 0.01.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Image(
                        painter = painterResource("ic_audio.xml"),
                        contentDescription = null,
                        contentScale = ContentScale.None,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxSize()
                            .clip(CircleShape)
                            .clickable(enabled = true) {
                                vibrate()
                                player.play(item.audioUrl)
                            }
                    )
                }
            }
        }
    }
}