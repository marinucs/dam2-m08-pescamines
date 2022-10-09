package buscaminas

import java.util.*

fun main() {

        var nMinas: Int?
        var medidaTablero: Int?

        println("""MEDIDA DEL TABLERO
        Introduce un número del 1 al 26: 
        """.trimIndent())

        do {
            medidaTablero = readln().toIntOrNull()
            if (medidaTablero == null || (medidaTablero < 1 || medidaTablero > 26)) {
                println("Introduce una medida correcta: ")
            }
        } while (medidaTablero == null || (medidaTablero < 1 || medidaTablero > 25))

        val minPorcentaje : Int = 16 * medidaTablero * medidaTablero / 100
        val maxPorcentaje : Int = 33 * medidaTablero * medidaTablero / 100

        println("""NÚMERO DE MINAS
        Introduce un número del $minPorcentaje al $maxPorcentaje: 
        """.trimIndent())

        do {
            nMinas = readln().toIntOrNull()
            if (nMinas == null || (nMinas < minPorcentaje || nMinas > maxPorcentaje)) {
                println("Introduce un número de minas correcto: ")
            }

        } while (nMinas == null || (nMinas < minPorcentaje || nMinas > maxPorcentaje))

        val tauler = Tauler(medidaTablero, nMinas)

        var col : Char ?
        var fila : Char ?
        var eleccion : String
        var gameOver = false

        println(""" INSTRUCCIONES:
        Para descubrir la casilla, introduce las letras correspondientes a la fila y columna.
        Para marcarla, añade * tras las coordenadas.
        """.trimIndent()
        )

        do {
            println("\n" + tauler)

            do {

                eleccion = readln().lowercase(Locale.getDefault())
                if (!(eleccion[0].code in 97 until 97 + medidaTablero &&
                            eleccion[1].code in 97 until 97 + medidaTablero))
                    println("T PASASTE, NO MAS")

                if ( eleccion.length > 2 && eleccion[2] != '*')
                    println("Elección incorrecta. Para marcar una casilla, introduce columna y fila seguido de asterisco")

            } while ( (eleccion.length > 2 && eleccion[2] != '*') ||
                (!(eleccion[0].code in 97 until 97 + medidaTablero &&
                        eleccion[1].code in 97 until 97 + medidaTablero)) )

            fila = eleccion[0]-97

            col = eleccion[1]-97

            when (eleccion.length) {
                2 -> tauler.descobreixCasella(fila.code, col.code)

                3 -> tauler.marcaMina(fila.code, col.code)

                else -> println("Elección incorrecta. El mínimo de carácteres es 2 y el máximo es de 3")
            }

            if(tauler.descobert()) {
                println("\nGANASTE: DESCUBRISTE TODAS LAS CASILLAS SIN MINAS\n")
                gameOver = true
            }

            if (tauler.descoberta(fila.code, col.code) && tauler.hiHaMina(fila.code, col.code)) {
                println("\nPERDISTE: TOPASTE CON UNA MINA\n")
                gameOver = true
            }

            if(gameOver) {
                tauler.descobreixTauler()
                println(tauler)
            }

        } while (!gameOver)
    }




