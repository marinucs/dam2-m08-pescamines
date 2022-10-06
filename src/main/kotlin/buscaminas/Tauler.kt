package buscaminas
import kotlin.random.Random

class Tauler(private var numCaselles : Int = 0,
             private var numMines : Int = 0) {

    private var tauler = Array(numCaselles) { Array(numCaselles) { Casella() } }

    init {
        posaMines()
        comptaMines()
    }
    fun posaMines() {

        for (i in 0 until numMines-1) {
            var fila : Int
            var col : Int

            while(true) {
                fila = Random.nextInt(0, numCaselles)
                col = Random.nextInt(0, numCaselles)

                if (!(tauler[fila][col].getEsMina())) {
                    tauler[fila][col].setEsMina()
                    break
                }
            }
        }
    }

    private fun comptaMines() {

        for (fila in 0 until numCaselles) {

            for (col in 0 until numCaselles) {
                var numMinesVeines : Int = 0

                val top = if (fila-1 >= 0)
                    fila-1 else 0

                val bot = if (fila+1 <= (numCaselles-1))
                    fila+1 else numCaselles - 1

                val right = if (col+1 <= (numCaselles-1))
                    col+1 else numCaselles - 1

                val left = if (col-1 >= 0)
                    col-1 else 0

                for (row in top .. bot) {

                    for (column in left .. right) {
                        if(tauler[row][column].getEsMina()) numMinesVeines++
                            tauler[fila][col].setNumMinesVeines(numMinesVeines)
                    }
                }
            }
        }
    }

    fun hiHaMina (fila : Int, col : Int) =
        tauler[fila][col].getEsMina()

    fun descobert() : Boolean {
        for (i in 0 until numCaselles) {

            for (j in 0 until numCaselles) {

                if (!tauler[i][j].getDescoberta() && !tauler[i][j].getEsMina())
                    return false
            }
        }
        return true
    }

    fun descobreixCasella(fila : Int, col : Int) =
        tauler[fila][col].setDescoberta()

    fun descobreixTauler() {
        for (i in 0 until numCaselles) {
            for (j in 0 until numCaselles) {
                descobreixCasella(i,j)
            }
        }
    }

    fun descoberta(fila : Int, col : Int)  =
        tauler[fila][col].getDescoberta()

    fun marcaMina(fila : Int, col : Int) =
        tauler[fila][col].setMarcaMina()

    fun minaMarcada(fila : Int, col : Int) =
        tauler[fila][col].getMinaMarcada()

    override fun toString(): String {
        var ret = "  "

        for(i in tauler.indices) {
            ret += " " + (i+97).toChar()
        }

        ret += "\n"

        for(fila in tauler.indices){
            ret += " " + (fila+97).toChar()

            for(col in tauler.indices){
                ret += " " + tauler[fila][col].toString()
            }
            ret += "\n"
        }
        return ret
    }

}


