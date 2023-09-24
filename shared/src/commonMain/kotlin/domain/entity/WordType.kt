package domain.entity

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.SerialName
import utils.Colors

enum class WordType {
    @SerialName("noun") NOUN,
    @SerialName("verb") VERB,
    @SerialName("pronoun") PRONOUN,
    @SerialName("adjective") ADJECTIVE;

    override fun toString(): String {
        return when (this) {
            NOUN -> "Существительное"
            VERB -> "Глагол"
            PRONOUN -> "Местоимение"
            ADJECTIVE -> "Прилагательное"
        }
    }

    fun getColor(): Color {
        return Color(
            when (this) {
                VERB -> Colors.GREEN_8
                NOUN -> Colors.BLUE_8
                PRONOUN -> Colors.CYAN_8
                ADJECTIVE -> Colors.ORANGE_8
            }
        )
    }
}