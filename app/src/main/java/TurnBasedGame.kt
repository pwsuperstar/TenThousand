import BusinessLogic.NiceRolls

data class Player(val Name: String, val Total: Int = 0, val Negatives: Int = 0)

abstract class TurnBasedGame (private val players: MutableList<Player>){
    var currentPlayerId = 0

    fun PlayGame()
    {
        InitGame()
        if (!GameOver())
        {
            currentPlayerId = (currentPlayerId +1) % players.size
            TakeTurn(players[currentPlayerId])
        }
    }

    abstract fun GameOver(): Boolean
    abstract fun InitGame()
    abstract fun TakeTurn(player: Player) // gets called when turn is taken
    abstract fun AnnounceWinner(player:Player)
}

class TenThousand(val players: MutableList<Player>, val dice: IDice, var rolls: MutableList<NiceRolls>) : TurnBasedGame(players) {

    var currentPlayerTotal: Int = 0
    var currentPlayerName = ""
    var rollCount = 0
    val maxRolls = 3

    override fun TakeTurn(player: Player) {
        currentPlayerTotal = player.Total;
        currentPlayerName = player.Name

        var tempTotal = 0
        var rollResult= 0

        while (rollCount < maxRolls)
        {
            var dices = dice.RollDice()
            for (r in rolls) {
                rollResult = r.evaluate(dices)
                tempTotal = if ( rollResult > tempTotal) rollResult else tempTotal
            }
        }

    }

    override fun AnnounceWinner(player: Player) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun InitGame() {
        TODO("not implemented")
    }

    override fun GameOver(): Boolean {
        for (p in players)
        {
            if (p.Total > 9999) {
                AnnounceWinner(p)
                return true;
            };
        }
        return false;
    }
}
