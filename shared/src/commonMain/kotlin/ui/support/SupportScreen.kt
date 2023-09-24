package ui.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Colors
import utils.isEmailValid
import utils.vibrate

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SupportScreen(
    wordId: String?,
    onBackClicked: () -> Unit,
) {
    val email = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White
            ) {
                Image(
                    painter = painterResource("ic_back.xml"),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 26.dp)
                        .height(18.dp)
                        .clickable(true) { onBackClicked.invoke() },
                )
                Text(
                    text = "Написать EWA",
                    fontSize = 17.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.01.sp,
                    modifier = Modifier.fillMaxWidth(1f).padding(end = 44.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { paddings ->
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(top = paddings.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier
                    .padding(top = 48.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(1f),
                value = email.value,
                onValueChange = { email.value = it },
                textStyle = TextStyle(fontSize = 18.sp),
                shape = RoundedCornerShape(CornerSize(16.dp)),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                placeholder = { Text(text = "Твой e-mail") },
                leadingIcon = {
                    Image(
                        painter = painterResource("ic_mail.xml"),
                        contentDescription = null,
                        modifier = Modifier.height(22.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color(Colors.LITE_GRAY),
                ),
                singleLine = true
            )
            TextField(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(1f)
                    .height(250.dp),
                value = message.value,
                onValueChange = { message.value = it },
                textStyle = TextStyle(fontSize = 18.sp),
                shape = RoundedCornerShape(CornerSize(16.dp)),
                placeholder = { Text(text = "Твоё сообщение") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color(Colors.LITE_GRAY),
                ),
            )
            Button(
                onClick = {
                    // todo send wordid
                    vibrate()
                    onBackClicked.invoke()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(Colors.BLUE), contentColor = Color.White
                ),
                enabled = email.value.isEmailValid() && message.value.isNotEmpty(),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .size(width = 160.dp, height = 60.dp)
                    .clip(RoundedCornerShape(CornerSize(48.dp))),
            ) {
                Text(
                    text = "Отправить",
                    fontSize = 17.sp,
                    letterSpacing = 0.01.sp,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource("draw_ewa_hi.png"),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    text = "Если есть ошибка, напиши мне, и я всё поправлю",
                    fontSize = 16.sp,
                    letterSpacing = 0.01.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}