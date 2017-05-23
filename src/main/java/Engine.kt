class Engine(private val map: Map) {

    fun move(fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean? {
        if (!validMove(fromX, fromY, toX, toY)) {
            return false
        }
        return map.move(fromX, fromY, toX, toY)
    }


    fun validMove(fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
        return true
    }

    fun main(args: Array<String>) {
        println("hello world")
    }
}
