package buscaminas

class Casella (
    private var esMina : Boolean = false,
    private var estaDescoberta : Boolean = false,
    private var estaMarcada : Boolean = false,
    private var numMinesVeines : Int = 0) {

    fun getEsMina() = esMina

    fun setEsMina() {
        if(!esMina) this.esMina = true
    }

    fun getDescoberta() = estaDescoberta

    fun setDescoberta() {
        this.estaDescoberta = true
    }

    fun getMinaMarcada() = estaMarcada

    fun setMarcaMina() {
        estaMarcada = !estaMarcada
    }

    fun getNumMinesVeines() = numMinesVeines

    fun setNumMinesVeines(numMinesVeines : Int) {
        this.numMinesVeines = numMinesVeines
    }

    override fun toString(): String {
        var valor : String = "";

        if(estaMarcada) valor = "*"
        if(!estaDescoberta && !estaMarcada) valor = "·"
        if(numMinesVeines == 0) valor = "0";
        if(numMinesVeines in 1..8) valor = numMinesVeines.toString()
        if(estaDescoberta) valor = "#"

        return valor;
    }

}