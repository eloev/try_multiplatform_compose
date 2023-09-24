package ui

import domain.entity.Word
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import moe.tlaster.precompose.viewmodel.ViewModel
import utils.ExampleData

class WordViewModel : ViewModel() {

    val allWords: StateFlow<List<Word>> = MutableStateFlow(ExampleData.wordsExample)

    private val _userWords = MutableStateFlow(emptyList<Word>())
    val userWords: StateFlow<List<Word>> = _userWords

    fun addWord(word: Word) {
        _userWords.value = userWords.value.plus(word)
    }

    fun removeWord(word: Word) {
        _userWords.value = userWords.value.minus(word)
    }

    fun clearWords() {
        _userWords.value = emptyList()
    }
}