import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.viewModel
import ui.WordViewModel
import ui.finish.FinishScreen
import ui.select.SelectWordScreen
import ui.support.SupportScreen
import ui.word.WordsScreen

private const val HOME = "/home"

@Composable
fun App() {
    val navigator = rememberNavigator()
    val wordViewModel = viewModel(WordViewModel::class) { WordViewModel() }

    MaterialTheme {
        NavHost(
            navigator = navigator,
            initialRoute = HOME
        ) {
            scene(HOME) {
                SelectWordScreen(
                    onOpenWordsClicked = {
                        navigator.navigate("/words}")
                    },
                    viewModel = wordViewModel
                )
            }
            scene("/words}") {
                WordsScreen(
                    onSupportClicked = {
                        navigator.navigate("/support/${it.id}")
                    },
                    onEndClicked = {
                        navigator.navigate("/finish/${it}")
                    },
                    onBackClicked = {
                        navigator.goBack()
                    },
                    viewModel = wordViewModel
                )
            }
            scene("/support/{id:([^/?]+)}") {
                SupportScreen(
                    wordId = it.path<String>("id"),
                    onBackClicked = {
                        navigator.goBack()
                    }
                )
            }
            scene("/finish/{count:[0-9]+}") {
                FinishScreen(
                    count = it.path<Int>("count"),
                    onHomeClicked = {
                        navigator.navigate(HOME)
                    }
                )
            }
        }
    }

}