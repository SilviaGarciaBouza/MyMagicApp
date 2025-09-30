package com.github.mymagicapp.data
import android.widget.ZoomControls
import com.github.mymagicapp.R
enum class ZodiacSign( val nameSign: String, val periodSign: String){
    ARIES("Aries", "21 Mar - 19 Abr"),
    TAURO("Tauro", "20 Abr - 20 May"),
    GEMINIS("Géminis", "21 May - 20 Jun"),
    CANCER("Cáncer", "21 Jun - 22 Jul"),
    LEO("Leo", "23 Jul - 22 Ago"),
    VIRGO("Virgo", "23 Ago - 22 Sep"),
    LIBRA("Libra", "23 Sep - 22 Oct"),
    ESCORPIO("Escorpio", "23 Oct - 21 Nov"),
    SAGITARIO("Sagitario", "22 Nov - 21 Dic"),
    CAPRICORNIO("Capricornio", "22 Dic - 19 Ene"),
    ACUARIO("Acuario", "20 Ene - 18 Feb"),
    PISCIS("Piscis", "19 Feb - 20 Mar")
}

enum class Animal(val nameAnimal:String, val infoAnimal:String, val imageAnimal:Int){
    KAKAPO(
        "Kakapo",
        "Sabiduría, tranquilidad, y conexión con la naturaleza. Es un ave nocturna y solitaria.",
        R.drawable.kakapo
    ),
    LOBO(
        "Lobo",
        "Lealtad, coraje y fuerte sentido de comunidad.",
        R.drawable.lobo
    ),
    FENIX(
        "Fénix",
        "Renacimiento, resiliencia y poder de transformación.",
        R.drawable.fenix
    ),
    DELFIN(
        "Delfín",
        "Inteligencia, alegría, y armonía social.",
        R.drawable.delfin
    )
}

data class HoroscopoReading(val sign: ZodiacSign, val sentense: String )
val horoscopoReadings: List<HoroscopoReading> = listOf(
// ARIES
HoroscopoReading(ZodiacSign.ARIES, "Tu audacia de hoy sentará las bases para un futuro brillante. ¡Actúa con determinación!"),
HoroscopoReading(ZodiacSign.ARIES, "La chispa de la iniciativa te guía. Empieza ese proyecto que tanto deseas, tienes la energía."),
HoroscopoReading(ZodiacSign.ARIES, "No hay obstáculo que frene tu espíritu pionero. Confía en tu fuerza interior para avanzar."),
HoroscopoReading(ZodiacSign.ARIES, "Tu valentía es tu mayor activo. Enfréntate a la semana con la frente en alto."),

// TAURO
HoroscopoReading(ZodiacSign.TAURO, "La paciencia es tu fuerza; disfruta de la belleza y estabilidad que has creado."),
HoroscopoReading(ZodiacSign.TAURO, "El universo te recompensa por tu constancia. Hoy, saborea los pequeños placeres."),
HoroscopoReading(ZodiacSign.TAURO, "Las decisiones tomadas con calma y sensatez te traerán grandes beneficios duraderos."),
HoroscopoReading(ZodiacSign.TAURO, "Aférrate a tus valores; la tierra te da el soporte necesario para prosperar."),

// GÉMINIS
HoroscopoReading(ZodiacSign.GEMINIS, "Tu mente es un torbellino de ideas. Elige una y comunícala con claridad para triunfar."),
HoroscopoReading(ZodiacSign.GEMINIS, "La curiosidad te llevará a descubrir algo fascinante. Mantén tus oídos y ojos abiertos."),
HoroscopoReading(ZodiacSign.GEMINIS, "La versatilidad es tu superpoder. Adáptate al cambio con gracia y humor."),
HoroscopoReading(ZodiacSign.GEMINIS, "Una conversación casual puede abrirte una puerta importante. Conéctate con los demás."),

// CÁNCER
HoroscopoReading(ZodiacSign.CANCER, "Sigue tu intuición, es una brújula que nunca falla. Nutre tu bienestar emocional."),
HoroscopoReading(ZodiacSign.CANCER, "Tu sensibilidad te permite conectar profundamente. Ofrece apoyo y lo recibirás multiplicado."),
HoroscopoReading(ZodiacSign.CANCER, "El hogar es tu refugio. Un momento de paz en casa te recargará completamente."),
HoroscopoReading(ZodiacSign.CANCER, "Recuerda que tu caparazón es fuerte, pero tu corazón es lo que te hace poderoso."),

// LEO
HoroscopoReading(ZodiacSign.LEO, "Brilla con luz propia. Tu carisma atrae oportunidades y admiración hoy."),
HoroscopoReading(ZodiacSign.LEO, "Tu corazón generoso te hace un líder natural. Comparte tu éxito con los demás."),
HoroscopoReading(ZodiacSign.LEO, "El escenario es tuyo. No temas mostrar tu talento; la confianza es clave."),
HoroscopoReading(ZodiacSign.LEO, "Siente la alegría de vivir. Un día de pasión y creatividad te espera."),

// VIRGO
HoroscopoReading(ZodiacSign.VIRGO, "La excelencia está en tu trabajo. Los detalles que cuidas te diferenciarán de todos."),
HoroscopoReading(ZodiacSign.VIRGO, "Organiza tu mente y tu espacio; la claridad te traerá paz y eficiencia."),
HoroscopoReading(ZodiacSign.VIRGO, "Concéntrate en el servicio; ayudar a otros es la mejor forma de ayudarte a ti mismo."),
HoroscopoReading(ZodiacSign.VIRGO, "Tu inteligencia práctica resuelve cualquier dilema. Confía en tu juicio analítico."),

// LIBRA
HoroscopoReading(ZodiacSign.LIBRA, "Busca la armonía en todas tus relaciones. Hoy, la diplomacia te lleva al éxito."),
HoroscopoReading(ZodiacSign.LIBRA, "La belleza te rodea, obsérvala y siéntela. Un ambiente equilibrado te impulsa."),
HoroscopoReading(ZodiacSign.LIBRA, "No temas tomar una decisión. Confía en tu sentido innato de justicia y equidad."),
HoroscopoReading(ZodiacSign.LIBRA, "Una colaboración con un ser querido te traerá alegría y grandes frutos."),

// ESCORPIO
HoroscopoReading(ZodiacSign.ESCORPIO, "Tu intensidad te da el poder de la transformación. Deja ir lo viejo para dar paso a lo nuevo."),
HoroscopoReading(ZodiacSign.ESCORPIO, "La verdad es tu arma más fuerte. Investiga a fondo y ganarás claridad."),
HoroscopoReading(ZodiacSign.ESCORPIO, "Tu pasión es un motor imparable. Úsala para alcanzar tus metas con determinación."),
HoroscopoReading(ZodiacSign.ESCORPIO, "Tu resiliencia es admirable. Puedes superar cualquier sombra con tu luz interior."),

// SAGITARIO
HoroscopoReading(ZodiacSign.SAGITARIO, "La aventura te llama. Expande tus horizontes, ya sea viajando o aprendiendo algo nuevo."),
HoroscopoReading(ZodiacSign.SAGITARIO, "El optimismo es contagioso. Tu sonrisa y entusiasmo iluminan el día de todos."),
HoroscopoReading(ZodiacSign.SAGITARIO, "Busca la verdad y la sabiduría. Las respuestas que necesitas están cerca."),
HoroscopoReading(ZodiacSign.SAGITARIO, "La libertad es esencial. Actúa con fe en tus convicciones más altas."),

// CAPRICORNIO
HoroscopoReading(ZodiacSign.CAPRICORNIO, "Tu disciplina te asegura el éxito. Cada esfuerzo de hoy se verá recompensado."),
HoroscopoReading(ZodiacSign.CAPRICORNIO, "La perseverancia es tu legado. Sube la montaña con paso firme y decidido."),
HoroscopoReading(ZodiacSign.CAPRICORNIO, "La paciencia y el realismo te hacen invencible. Define tus metas con precisión."),
HoroscopoReading(ZodiacSign.CAPRICORNIO, "Tu estructura te da soporte. Disfruta de la seguridad que has construido con trabajo duro."),

// ACUARIO
HoroscopoReading(ZodiacSign.ACUARIO, "Tu mente original te dará una idea revolucionaria. Piensa fuera de la caja."),
HoroscopoReading(ZodiacSign.ACUARIO, "El futuro es tuyo para moldearlo. Tu visión humanitaria es un faro de esperanza."),
HoroscopoReading(ZodiacSign.ACUARIO, "La amistad es tu fuerza. Conéctate con tu comunidad y abraza la diversidad."),
HoroscopoReading(ZodiacSign.ACUARIO, "Libertad e independencia son tus guías. Sé fiel a tu espíritu único."),

// PISCIS
HoroscopoReading(ZodiacSign.PISCIS, "Tu creatividad fluye como el agua. Dale rienda suelta a tu arte y tus sueños."),
HoroscopoReading(ZodiacSign.PISCIS, "La compasión te conecta con el universo. Hoy, tu bondad es un acto de magia."),
HoroscopoReading(ZodiacSign.PISCIS, "Escucha los susurros de tu intuición; te llevan por el camino correcto."),
HoroscopoReading(ZodiacSign.PISCIS, "Sueña en grande; tus visiones tienen el potencial de manifestarse en la realidad."),
)

fun gethoroscopReadingRandon(sign: ZodiacSign):String{
    return horoscopoReadings.filter { e->e.sign==sign }.random().sentense
}


