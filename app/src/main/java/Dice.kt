import java.util.*

interface IDice {
    fun RollDice(): IntArray
}

class Dice (val diceCount: Int = 6) : IDice{
    override fun RollDice(): IntArray {

        var r = Random();
        val returnArray = intArrayOf(diceCount)
        val i = 0
        while (i < diceCount)
        {
            returnArray[i] = r.nextInt(6)
        }
        return returnArray
    }
}

