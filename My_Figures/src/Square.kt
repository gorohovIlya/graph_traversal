class Square(var x: Int, var y: Int, var side: Int): Movable, Figure(0)  {
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun area(): Float {
        return (this.side * this.side).toFloat()
    }

    override fun resize(zoom: Int) {
        val sResized = this.side * zoom
        val dxy = (sResized - this.side) / 2
        this.x -= dxy
        this.y -= dxy
        this.side = sResized
    }

    private fun rotateClockwise(centerX: Int, centerY: Int) {
        val vx = this.x - centerX
        val vy = this.y - centerY
        this.x = centerX + vy
        this.y = centerY - vx
    }

    private fun rotateCounterClockwise(centerX: Int, centerY: Int) {
        val vx = this.x - centerX
        val vy = this.y - centerY
        this.x = centerX - vy
        this.y = centerY + vx
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        when (direction) {
            RotateDirection.Clockwise -> rotateClockwise(centerX, centerY)
            RotateDirection.CounterClockwise -> rotateCounterClockwise(centerX, centerY)
        }
    }

    override fun toString(): String {
        return "Square. X: ${this.x}, Y: ${this.y}, Side: ${this.side}"
    }
}