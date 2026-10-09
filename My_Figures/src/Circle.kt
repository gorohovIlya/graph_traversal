import kotlin.math.PI

class Circle(var centerX: Int, var centerY: Int, var radius: Int) : Figure(0) {
    override fun area(): Float {
        return (PI * radius * radius).toFloat();
    }

    override fun resize(zoom: Int) {
        this.radius *= 2
    }

    private fun rotateClockwise(centerX: Int, centerY: Int) {
        val vx = this.centerX - centerX
        val vy = this.centerY - centerY

        this.centerX = centerX + vy
        this.centerY = centerY - vx
    }

    private fun rotateCounterClockwise(centerX: Int, centerY: Int) {
        val vx = this.centerX - centerX
        val vy = this.centerY - centerY

        this.centerX = centerX - vy
        this.centerY = centerY + vx
    }

    override fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    ) {
        when (direction) {
            RotateDirection.Clockwise ->
                rotateClockwise(centerX, centerY)

            RotateDirection.CounterClockwise ->
                rotateCounterClockwise(centerX, centerY)
        }
    }

    override fun toString(): String {
        return "Circle. Center X: ${this.centerX}, Center Y: ${this.centerY}, Radius: ${this.radius}}"
    }
}