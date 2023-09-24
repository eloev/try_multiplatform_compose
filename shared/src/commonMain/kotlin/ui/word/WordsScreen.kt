package ui.word

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.entity.Word
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.WordViewModel
import utils.Colors
import utils.vibrate

@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
fun WordsScreen(
    onBackClicked: () -> Unit,
    onSupportClicked: (word: Word) -> Unit,
    onEndClicked: (count: Int) -> Unit,
    viewModel: WordViewModel
) {
    val pagerState = rememberPagerState()
    val itemsListState by viewModel.userWords.collectAsState()
    val composableScope = rememberCoroutineScope()

    var menuShow by remember { mutableStateOf(false) }
    if (pagerState.isScrollInProgress) {
        menuShow = false
    }

    val buttonBottomPaddings = 54.dp

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
                        .clickable(true) {
                            viewModel.clearWords()
                            onBackClicked.invoke()
                        },
                )
                Spacer(Modifier.weight(1f, true))
                Text(
                    text = "${pagerState.currentPage + 1} из ${itemsListState.size}",
                    fontSize = 17.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.01.sp,
                )
                Spacer(Modifier.weight(1f, true))
                Image(
                    painter = painterResource("ic_more.xml"),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 26.dp)
                        .height(24.dp)
                        .clickable(true) { menuShow = !menuShow },
                )
            }
        },
        bottomBar = {
            Button(
                onClick = {
                    vibrate()
                    if (pagerState.currentPage + 1 != itemsListState.size) {
                        composableScope.launch {
                            pagerState.scrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        onEndClicked.invoke(itemsListState.size)
                        viewModel.clearWords()
                    }
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
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(horizontal = 16.dp)
        ) {
            WordDropDown(
                menuShow = menuShow,
                knownWord = {
                    menuShow = false
                    viewModel.removeWord(itemsListState[pagerState.currentPage])
                },
                wordsSize = itemsListState.size,
                supportClicked = {
                    onSupportClicked.invoke(itemsListState[pagerState.currentPage])
                }
            )
            HorizontalPager(
                state = pagerState,
                pageCount = itemsListState.size,
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(top = paddings.calculateTopPadding()),
            ) { index ->
                WordCard(
                    word = itemsListState[index],
                    bottomPadding = paddings.calculateBottomPadding() + buttonBottomPaddings
                )
            }
        }
    }
}