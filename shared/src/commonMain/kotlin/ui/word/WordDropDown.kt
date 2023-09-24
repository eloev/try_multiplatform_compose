package ui.word

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Colors

@OptIn(ExperimentalResourceApi::class)
@Composable
fun WordDropDown(
    menuShow: Boolean,
    knownWord: () -> Unit,
    wordsSize: Int,
    supportClicked: () -> Unit
) {
    if (menuShow) {
        IconButton(
            onClick = { supportClicked.invoke() },
        ) {
            Row {
                Text(
                    text = "Сообщить об ошибке",
                    fontSize = 17.sp,
                    letterSpacing = 0.01.sp,
                )
                Spacer(Modifier.weight(1f, true))
                Image(
                    painter = painterResource("ic_mail.xml"),
                    contentDescription = null,
                    modifier = Modifier
                        .height(22.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Row(
            modifier = Modifier
                .background(Color(Colors.LITE_GRAY))
                .fillMaxWidth()
                .height(2.dp)
        ) {}
        if (wordsSize > 1) {
            IconButton(
                onClick = { knownWord.invoke() },
            ) {
                Row {
                    Text(
                        text = "Я уже знаю слово",
                        fontSize = 17.sp,
                        letterSpacing = 0.01.sp,
                    )
                    Spacer(Modifier.weight(1f, true))
                    Image(
                        painter = painterResource("ic_complete.xml"),
                        contentDescription = null,
                        modifier = Modifier
                            .height(22.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .background(Color(Colors.LITE_GRAY))
                    .fillMaxWidth()
                    .height(2.dp)
            ) {}
        }
    }
}