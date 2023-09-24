package ui.finish

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Colors

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FinishScreen(
    count: Int?,
    onHomeClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource("draw_confetties.xml"),
            contentDescription = null,
        )
        Image(
            modifier = Modifier.fillMaxWidth().offset(y = (-70).dp),
            painter = painterResource("draw_greetings.xml"),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.offset(y = (-70).dp),
            text = "Отлично",
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            letterSpacing = 0.01.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.offset(y = (-60).dp),
            text = "Ты выучил $count слов",
            fontSize = 17.sp,
            letterSpacing = 0.01.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.weight(1f, true))
        Button(
            onClick = {
                onHomeClicked.invoke()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(Colors.BLUE), contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(72.dp)
                .padding(bottom = 20.dp)
                .clip(RoundedCornerShape(CornerSize(10.dp))),
        ) {
            Text(
                text = "Далее",
                fontSize = 17.sp,
                letterSpacing = 0.01.sp,
            )
        }
    }

}