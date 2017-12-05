package BusinessLogic

/**
 * Created by Wilhelm on 29-10-2017.
 */

interface NiceRolls {
    fun evaluate(diceValues: IntArray) : Int

}

class Royal : NiceRolls {
    override fun evaluate(diceValues: IntArray): Int {
        if (intArrayOf(1, 2, 3, 4, 5, 6) contentEquals diceValues)
        {
            return 1000;
        }
        else return 0;
    }
}


class OfAKind : NiceRolls {
    override fun evaluate(diceValues: IntArray): Int {

        val sets = diceValues.groupBy{ it}.filter { it.value.count() > 2 }
        var result: Int = 0
        sets.forEach{
            val mult = it.value.count() - 2
            result += it.key * 100 * mult
        }
        return result
    }
}

class OnesAndFives : NiceRolls {
    override fun evaluate(diceValues: IntArray): Int {
        val sets = diceValues.groupBy{ it}.filter { it.key == 10 || it.key == 5 }
        var result: Int = 0
        sets.forEach{ result += it.key * 10 * it.value.count()}
        return result
    }
}

class AllPairs : NiceRolls {
    override fun evaluate(diceValues: IntArray): Int {
        if (diceValues.groupBy { it }.count() == diceValues.count() / 2)
        {
            return 1000;
        }
        else return 0;
    }
}
