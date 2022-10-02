fun main() {

    val num1 : Double = readln().toDouble()
    val operador : Char = readln().first()
    val num2 : Double = readln().toDouble()
    var resultat : Double = 0.0

    when (operador) {
        '+' -> resultat = num1 + num2
        '-'-> resultat = num1 - num2
        '*' -> resultat = num1 * num2
        '/' -> if(num2>0) resultat = num1 / num2
                    else ("Operació no permessa")
    }

    println(resultat)

}