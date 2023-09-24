package domain.entity

import kotlinx.serialization.SerialName

data class WordExample(
    @SerialName("originText") val originText: String,
    @SerialName("audioUrl") val audioUrl: String,
    @SerialName("translatedText") val translatedText: String
)