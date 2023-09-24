package utils

import domain.entity.Word
import domain.entity.WordExample
import domain.entity.WordType

object ExampleData {

    private const val PATH = "http://192.168.1.11:8080/"

    val wordsExample = listOf(
        Word(
            image = PATH + "image/draw_run.png",
            type = WordType.VERB,
            origin = "run",
            audioUrl = PATH + "audio/run.mp3",
            transcription = "[ræn]",
            translated = "бежать",
            examples = listOf(
                WordExample(
                    originText = "He began to run faster than other dogs, became stronger, more cunning, more enduring, angrier, acquired iron muscles and significantly outwitted his enemies.",
                    audioUrl = PATH + "audio/run_example1.mp3",
                    translatedText = "Он стал бегать быстрее других собак, сделался сильнее, хитрее, выносливее, злее, приобрёл железные мускулы и значительно превосходил умом своих врагов."
                ),
                WordExample(
                    originText = "Not always enough hours to run store.",
                    audioUrl = PATH + "audio/run_example2.mp3",
                    translatedText = "Не всегда есть достаточно часов, чтобы бегать по магазинам."
                ),
                WordExample(
                    originText = "We have to run and run and run.",
                    audioUrl = PATH + "audio/run_example3.mp3",
                    translatedText = "Мы бежим, бежим и бежим."
                ),
                WordExample(
                    originText = "We say run, you run.",
                    audioUrl = PATH + "audio/run_example4.mp3",
                    translatedText = "Мы говорим бежать, ты бежишь."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_dangerous.png",
            type = WordType.ADJECTIVE,
            origin = "dangerous",
            audioUrl = PATH + "audio/dangerous.mp3",
            transcription = "[ˈdeɪndʒərəs]",
            translated = "опасный",
            examples = listOf(
                WordExample(
                    originText = "Swimming in this river can be very dangerous due to strong currents.",
                    audioUrl = PATH + "audio/dangerous_example1.mp3",
                    translatedText = "Купание в этой реке может быть очень опасным из-за сильных течений."
                ),
                WordExample(
                    originText = "It's important to wear protective gear when engaging in dangerous sports.",
                    audioUrl = PATH + "audio/dangerous_example2.mp3",
                    translatedText = "Важно надевать защитное снаряжение при занятии опасными видами спорта."
                ),
                WordExample(
                    originText = "He took a shortcut through a dangerous neighborhood and got robbed.",
                    audioUrl = PATH + "audio/dangerous_example3.mp3",
                    translatedText = "Он пошел насквозь через опасный район и его ограбили."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_car.png",
            type = WordType.NOUN,
            origin = "car",
            audioUrl = PATH + "audio/car.mp3",
            transcription = "[kɑːr]",
            translated = "автомобиль",
            examples = listOf(
                WordExample(
                    originText = "She drove her new car through the city streets.",
                    audioUrl = PATH + "audio/car_example1.mp3",
                    translatedText = "Она ехала на своей новой машине по улицам города."
                ),
                WordExample(
                    originText = "I need to get my car serviced.",
                    audioUrl = PATH + "audio/car_example2.mp3",
                    translatedText = "Мне нужно отремонтировать мою машину."
                ),
                WordExample(
                    originText = "He parked his car in front of the building.",
                    audioUrl = PATH + "audio/car_example3.mp3",
                    translatedText = "Он припарковал свою машину перед зданием."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_findout.png",
            type = WordType.VERB,
            origin = "find out",
            audioUrl = PATH + "audio/findout.mp3",
            transcription = "[ˈfaɪnd ˈaʊt]",
            translated = "выяснять, узнавать, понять, обнаруживать",
            examples = listOf(
                WordExample(
                    originText = "We find out all effects of medicine.",
                    audioUrl = PATH + "audio/findout_example1.mp3",
                    translatedText = "Мы выясняем все эффекты лекарства."
                ),
                WordExample(
                    originText = "She followed him home to find out where he lived.",
                    audioUrl = PATH + "audio/findout_example2.mp3",
                    translatedText = "Она последовала за ним домой, чтобы узнать, где он живет."
                ),
                WordExample(
                    originText = "Desperate, she starts her own investigation to find out what happened.",
                    audioUrl = PATH + "audio/findout_example3.mp3",
                    translatedText = "В отчаянии она начинает собственное расследование, чтобы выяснить, что произошло."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_incredible.png",
            type = WordType.ADJECTIVE,
            origin = "incredible",
            audioUrl = PATH + "audio/incredible.mp3",
            transcription = "[ɪnˈkrɛdəbl̩]",
            translated = "невероятный, непостижимый",
            examples = listOf(
                WordExample(
                    originText = "His story of survival in the wilderness is absolutely incredible.",
                    audioUrl = PATH + "audio/incredible_example1.mp3",
                    translatedText = "Его история выживания в дикой природе просто невероятна."
                ),
                WordExample(
                    originText = "The magician performed an incredible trick that left everyone amazed.",
                    audioUrl = PATH + "audio/incredible_example2.mp3",
                    translatedText = "Фокусник продемонстрировал невероятный трюк, который оставил всех в изумлении."
                ),
                WordExample(
                    originText = "The team achieved an incredible victory against all odds.",
                    audioUrl = PATH + "audio/incredible_example3.mp3",
                    translatedText = "Команда добилась невероятной победы, несмотря на все преграды."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_pen.png",
            type = WordType.NOUN,
            origin = "pen",
            audioUrl = PATH + "audio/pen.mp3",
            transcription = "[pen]",
            translated = "ручка",
            examples = listOf(
                WordExample(
                    originText = "I need to buy a new pen for writing.",
                    audioUrl = PATH + "audio/pen_example1.mp3",
                    translatedText = "Мне нужно купить новую ручку для письма."
                ),
                WordExample(
                    originText = "She signed the document with a black pen.",
                    audioUrl = PATH + "audio/pen_example2.mp3",
                    translatedText = "Она подписала документ черной ручкой."
                ),
                WordExample(
                    originText = "The teacher asked the students to take out their pens and notebooks.",
                    audioUrl = PATH + "audio/pen_example3.mp3",
                    translatedText = "Учитель попросил учеников достать ручки и тетради."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_continue.png",
            type = WordType.VERB,
            origin = "continue",
            audioUrl = PATH + "audio/continue.mp3",
            transcription = "[kənˈtɪnjuː]",
            translated = "продолжать",
            examples = listOf(
                WordExample(
                    originText = "Please continue with your presentation.",
                    audioUrl = PATH + "audio/continue_example1.mp3",
                    translatedText = "Пожалуйста, продолжайте вашу презентацию."
                ),
                WordExample(
                    originText = "They decided to continue their journey despite the difficulties.",
                    audioUrl = PATH + "audio/continue_example2.mp3",
                    translatedText = "Они решили продолжить свое путешествие несмотря на трудности."
                ),
                WordExample(
                    originText = "The concert will continue after a short intermission.",
                    audioUrl = PATH + "audio/continue_example3.mp3",
                    translatedText = "Концерт продолжится после короткого антракта."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_book.png",
            type = WordType.NOUN,
            origin = "book",
            audioUrl = PATH + "audio/book.mp3",
            transcription = "[bʊk]",
            translated = "книга",
            examples = listOf(
                WordExample(
                    originText = "She loves to read books in her free time.",
                    audioUrl = PATH + "audio/book_example1.mp3",
                    translatedText = "Она любит читать книги в свободное время."
                ),
                WordExample(
                    originText = "He borrowed a book from the library.",
                    audioUrl = PATH + "audio/book_example2.mp3",
                    translatedText = "Он одолжил книгу из библиотеки."
                ),
                WordExample(
                    originText = "I always carry a book with me when I travel.",
                    audioUrl = PATH + "audio/book_example3.mp3",
                    translatedText = "Я всегда ношу книгу с собой, когда путешествую."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_check.png",
            type = WordType.VERB,
            origin = "check",
            audioUrl = PATH + "audio/check.mp3",
            transcription = "[tʃek]",
            translated = "проверять, контролировать",
            examples = listOf(
                WordExample(
                    originText = "Don't forget to check your email regularly.",
                    audioUrl = PATH + "audio/check_example1.mp3",
                    translatedText = "Не забывайте проверять свою электронную почту регулярно."
                ),
                WordExample(
                    originText = "The teacher will check our homework tomorrow.",
                    audioUrl = PATH + "audio/check_example2.mp3",
                    translatedText = "Учитель проверит наши домашние задания завтра."
                ),
                WordExample(
                    originText = "Could you please check if the door is locked?",
                    audioUrl = PATH + "audio/check_example3.mp3",
                    translatedText = "Не могли бы вы, пожалуйста, проверить, заперта ли дверь?"
                )
            )
        ),
        Word(
            image = PATH + "image/draw_they.png",
            type = WordType.PRONOUN,
            origin = "they",
            audioUrl = PATH + "audio/they.mp3",
            transcription = "[ðeɪ]",
            translated = "они",
            examples = listOf(
                WordExample(
                    originText = "They are going on a vacation next week.",
                    audioUrl = PATH + "audio/they_example1.mp3",
                    translatedText = "Они уезжают в отпуск на следующей неделе."
                ),
                WordExample(
                    originText = "They always help each other in difficult times.",
                    audioUrl = PATH + "audio/they_example2.mp3",
                    translatedText = "Они всегда помогают друг другу в трудные времена."
                ),
                WordExample(
                    originText = "They won the championship for the third year in a row.",
                    audioUrl = PATH + "audio/they_example3.mp3",
                    translatedText = "Они выиграли чемпионат уже в третий раз подряд."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_amazing.png",
            type = WordType.ADJECTIVE,
            origin = "amazing",
            audioUrl = PATH + "audio/amazing.mp3",
            transcription = "[əˈmeɪzɪŋ]",
            translated = "удивительный, потрясающий",
            examples = listOf(
                WordExample(
                    originText = "The view from the top of the mountain was absolutely amazing.",
                    audioUrl = PATH + "audio/amazing_example1.mp3",
                    translatedText = "Вид с вершины горы был абсолютно удивительным."
                ),
                WordExample(
                    originText = "She has an amazing talent for playing the piano.",
                    audioUrl = PATH + "audio/amazing_example2.mp3",
                    translatedText = "У нее потрясающий талант играть на пианино."
                ),
                WordExample(
                    originText = "The performance was truly amazing, it left the audience in awe.",
                    audioUrl = PATH + "audio/amazing_example3.mp3",
                    translatedText = "Выступление было поистине удивительным, оно оставило зрителей в изумлении."
                )
            )
        ),
        Word(
            image = PATH + "image/draw_we.png",
            type = WordType.PRONOUN,
            origin = "we",
            audioUrl = PATH + "audio/we.mp3",
            transcription = "[wiː]",
            translated = "мы",
            examples = listOf(
                WordExample(
                    originText = "We are going to have a party at our house this weekend.",
                    audioUrl = PATH + "audio/we_example1.mp3",
                    translatedText = "Мы собираемся устроить вечеринку у себя дома на этих выходных."
                ),
                WordExample(
                    originText = "We always support each other in our endeavors.",
                    audioUrl = PATH + "audio/we_example2.mp3",
                    translatedText = "Мы всегда поддерживаем друг друга в наших начинаниях."
                ),
                WordExample(
                    originText = "We won't give up until we achieve our goal.",
                    audioUrl = PATH + "audio/we_example3.mp3",
                    translatedText = "Мы не сдадимся, пока не достигнем нашей цели."
                )
            )
        ),
    )
}