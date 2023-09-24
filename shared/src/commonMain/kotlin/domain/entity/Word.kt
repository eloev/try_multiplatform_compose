package domain.entity

import kotlinx.serialization.SerialName

data class Word(
    @SerialName("id") val id: String = "50fe18f2-1519-11ee-be56-0242ac120002",
    @SerialName("image") val image: String,
    @SerialName("type") val type: WordType,
    @SerialName("origin") val origin: String,
    @SerialName("audioUrl") val audioUrl: String,
    @SerialName("transcription") val transcription: String,
    @SerialName("translated") val translated: String,
    @SerialName("examples") val examples: List<WordExample>
)