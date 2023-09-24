package ui.word

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.entity.WordExample
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Colors

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WordExamplesCard(
    wordExample: WordExample,
    playAudio: (url: String) -> Unit,
) {
    var showTranslate by remember { mutableStateOf(false) }

    return Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Row {
            Image(
                painter = painterResource("ic_arrow_down.xml"),
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(24.dp)
                    .clickable(enabled = true) { showTranslate = !showTranslate }
                    .rotate(
                        if (showTranslate) 180f
                        else 0f
                    )
            )
            Text(
                text = wordExample.originText,
                fontSize = 17.sp,
                letterSpacing = 0.01.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 4.dp, end = 20.dp)
                    .fillMaxWidth(0.9f)
            )
            Image(
                painter = painterResource("ic_audio_secondary.xml"),
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(top = 2.dp, start = 4.dp)
                    .size(24.dp)
                    .clickable(enabled = true) {
                        playAudio.invoke(wordExample.audioUrl)
                    }
            )
        }
        AnimatedVisibility(showTranslate) {
            Text(
                text = wordExample.translatedText,
                fontSize = 17.sp,
                letterSpacing = 0.01.sp,
                color = Color(Colors.BLACK_65),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 4.dp, start = 28.dp, end = 20.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 20.dp)
                .background(Color(Colors.LITE_GRAY))
                .fillMaxWidth()
                .height(2.dp)
        ) {}
    }
}