package ui.word

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.entity.Word
import domain.entity.WordType
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Colors
import utils.AsyncImage
import utils.AudioPlayer

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WordCard(
    word: Word,
    bottomPadding: Dp
) {
    val player = AudioPlayer()

    return Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            url = word.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(16f / 9f)
                .padding(vertical = 16.dp)
                .clip(RoundedCornerShape(CornerSize(16.dp)))
                .border(
                    BorderStroke(2.dp, Color(Colors.LITE_GRAY)),
                    RoundedCornerShape(CornerSize(16.dp))
                )
        )
        Text(
            text = word.type.toString(),
            fontSize = 15.sp,
            letterSpacing = 0.01.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(CornerSize(4.dp)))
                .background(
                    Color(
                        when (word.type) {
                            WordType.VERB -> Colors.GREEN_8
                            WordType.NOUN -> Colors.BLUE_8
                            WordType.PRONOUN -> Colors.CYAN_8
                            WordType.ADJECTIVE -> Colors.ORANGE_8
                        }
                    )
                )
                .padding(4.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = word.origin,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.01.sp,
                color = Color.Black,
            )
            Image(
                painter = painterResource("ic_audio.xml"),
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(CircleShape)
                    .clickable(enabled = true) {
                        utils.vibrate()
                        player.play(word.audioUrl)
                    }
            )
        }
        Text(
            text = word.transcription,
            fontSize = 17.sp,
            letterSpacing = 0.01.sp,
            color = Color(Colors.BLACK_65),
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = word.translated,
            fontSize = 24.sp,
            letterSpacing = 0.01.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 20.dp)
        )
        if (word.examples.isNotEmpty()) {
            Text(
                text = "Пример из контекста",
                fontSize = 20.sp,
                letterSpacing = 0.01.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 50.dp)
            )
            word.examples.forEach { wordExample ->
                WordExamplesCard(
                    wordExample = wordExample,
                    playAudio = { player.play(it) }
                )
            }
        }
        Spacer(modifier = Modifier.size(bottomPadding))
    }
}