class Map(private val width: Int, private val height: Int) {
    private val map: Array<Array<Mappable?>>

    init {
        map = Array<Array<Mappable?>>(height) { arrayOfNulls<Mappable?>(width) }
    }

    /**
     * @param m mappable to add to the map
     * *
     * @param x target x coordinate
     * *
     * @param y target y coordinate
     * *
     * @return true on success, false otherwise
     */
    fun put(m: Mappable, x: Int, y: Int): Boolean? {
        if (x < 0 || x >= width) return false
        if (y < 0 || y >= height) return false
        if (map[y][x] != null) return false

        map[y][x] = m

        return true
    }

    operator fun get(x: Int, y: Int): Mappable? {
        if (x < 0 || x >= width) return null
        if (y < 0 || y >= height) return null
        return map[y][x]
    }

    fun remove(x: Int, y: Int): Boolean? {
        if (x < 0 || x >= width) return false
        if (y < 0 || y >= height) return false
        if (map[y][x] == null) return false

        map[y][x] = null

        return true
    }

    fun move(fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean? {
        if (fromX < 0 || fromX >= width) return false
        if (fromY < 0 || fromY >= height) return false
        if (map[fromY][fromX] == null) return false
        if (toX < 0 || toX >= width) return false
        if (toY < 0 || toY >= height) return false
        if (map[toY][toX] != null) return false

        map[toY][toX] = map[fromY][fromX]
        map[fromY][fromX] = null

        return true
    }

    override fun toString(): String {
        val sb = StringBuilder(width * height + height)
        for (row in map) {
            for (m in row) {
                if (m != null) {
                    sb.append("m")
                } else {
                    sb.append(".")
                }
            }
            sb.append("\n")
        }
        return sb.toString()
    }
}
