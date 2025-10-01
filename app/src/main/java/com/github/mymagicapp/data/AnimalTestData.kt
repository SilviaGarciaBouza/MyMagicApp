package com.github.mymagicapp.data


data class Answer(
    val text: String,
    val pointsToAnimal: Animal
)

data class Question(
    val text: String,
    val answers: List<Answer>
)

val animalTestQuestions: List<Question> = listOf(
    Question(
        text = "¿Qué valor priorizas más en la vida?",
        answers = listOf(
            Answer("La lealtad hacia mi círculo íntimo.", Animal.LOBO),
            Answer("La introspección y el conocimiento profundo.", Animal.KAKAPO),
            Answer("El cambio y la reinvención constante.", Animal.FENIX),
            Answer("La felicidad y la inteligencia social.", Animal.DELFIN)
        )
    ),
    Question(
        text = "¿Cómo manejas una gran dificultad o fracaso?",
        answers = listOf(
            Answer("Me aíslo para reflexionar y luego actúo con calma.", Animal.KAKAPO),
            Answer("Siento que es una oportunidad para renacer más fuerte.", Animal.FENIX),
            Answer("Busco el apoyo de mi 'manada' o familia.", Animal.LOBO),
            Answer("Me concentro en encontrar una solución creativa y alegre.", Animal.DELFIN)
        )
    ),
    Question(
        text = "¿Cuál es tu escenario social ideal?",
        answers = listOf(
            Answer("Una cena íntima con mis amigos de toda la vida.", Animal.LOBO),
            Answer("Un evento grande donde pueda interactuar y reír con muchos.", Animal.DELFIN),
            Answer("Un lugar tranquilo en solitario, observando el entorno.", Animal.KAKAPO),
            Answer("En cualquier lugar, siempre que pueda inspirar un cambio positivo.", Animal.FENIX)
        )
    )

)

fun calculateSpiritAnimal(scores: Map<Animal, Int>): Animal {
    return scores.maxByOrNull { it.value }?.key ?: Animal.LOBO
}