package buscaminas

import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        var nMinas: Int
        var medidaTablero: Int
        println(
            """
    MEDIDA DEL TABLERO
    Introduce un número del 1 al 26: 
    """.trimIndent()
        )
        do {
            medidaTablero = sc.nextInt()
            if (medidaTablero < 1 || medidaTablero > 25) {
                println("Introduce una medida correcta: ")
            }
        } while (medidaTablero < 1 || medidaTablero > 25)
        val minPorcentaje = 15 / medidaTablero * 100
        val maxPorcentaje = 50 / medidaTablero * 100
        println(
            """
    NÚMERO DE MINAS
    Introduce un número del 1 al $maxPorcentaje: 
    """.trimIndent()
        )
        do {
            nMinas = sc.nextInt()
            if (nMinas < minPorcentaje || nMinas > maxPorcentaje) {
                println("Introduce un número de minas correcto: ")
            }
        } while (nMinas < minPorcentaje || nMinas > maxPorcentaje)
        val tauler = Tauler(medidaTablero, nMinas)
        tauler.posaMines()

        var col: Int
        var fila: Int
        var eleccion : String
        var gameOver = false

        println(
            """
    Para descubrir una celda introduce CF 
    Para marcarla introduce CFM, seguido de las coordenadas.
    """.trimIndent()
        )
        do {
            println(tauler)
            eleccion = sc.nextLine()
            fila = sc.nextInt()
            col = sc.nextInt()

            if (eleccion.equals("CF", ignoreCase = true)) {
                tauler.descobreixCasella(fila, col)

            } else if (eleccion.equals("CFM", ignoreCase = true)) {
                tauler.marcaMina(fila, col)
                tauler.comptaMines()
                
            } else println("ELECCIÓN INCORRECTA")
            
            if (tauler.descobert() ||
                tauler.descoberta(fila, col) && tauler.hiHaMina(fila, col)) {
                gameOver = true
                tauler.descobreixTauler()
            }

        } while (!gameOver)
        sc.close()
    }
}