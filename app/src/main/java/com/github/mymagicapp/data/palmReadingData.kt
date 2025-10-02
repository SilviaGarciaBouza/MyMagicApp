package com.github.mymagicapp.data

val palmReadingSentences: List<String> = listOf(
    "La línea del corazón indica una gran pasión y empatía en tus relaciones. Sigue tu instinto.",
    "Tu línea de la cabeza, larga y clara, revela una mente analítica y gran sabiduría. Confía en tu intelecto.",
    "Observo una línea de vida fuerte y bien marcada, lo que sugiere una vida plena y llena de energía positiva.",
    "La línea del destino se cruza con tu Monte de Venus, señalando un éxito profesional que vendrá de la mano de tu creatividad.",
    "Tus líneas secundarias sugieren un viaje inesperado que cambiará tu perspectiva sobre el futuro. Prepárate para la aventura.",
    "Hay un anillo de Saturno visible, lo que implica que estás a punto de superar un gran obstáculo con disciplina y paciencia.",
    "Tu mano refleja un fuerte sentido de justicia y equilibrio. Usa esa energía para ayudar a quienes te rodean."
)

fun getRandomPalmReading(): String {
    return palmReadingSentences.random()
}