package buscaminas

class Casella (esMina : Boolean, estaDescoberta : Boolean, estaMarcada : Boolean, nm : Int) {

    private var esMina : Boolean = false
    private var estaDescoberta : Boolean? = null
    private var estaMarcada : Boolean? = null
    private var nMines : Int = 0

    fun getEsMina() = esMina

    fun setEsMina() {
        esMina = true
    }

    fun getDescoberta() = estaDescoberta

    fun setDescoberta(estaDescoberta : Boolean) {
        this.estaDescoberta = estaDescoberta
    }

    fun getMinaMarcada() = estaMarcada

    fun setMinaMarcada(estaMarcada : Boolean) {
        this.estaMarcada = estaMarcada
    }

    fun getMines() = nMines

    fun setMines(nMines : Int) {
        this.nMines = nMines
    }

}