// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Figure(0) {
    // TODO: реализовать интерфейс Transforming
    var color: Int = -1 // при объявлении каждое поле нужно инициализировать

    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Int) {
        val wResized = this.width * zoom
        val hResized = this.height * zoom
        val dy = (hResized - this.height) / 2
        val dx = (wResized - this.width) / 2
        this.x -= dx
        this.y -= dy
        this.width = wResized
        this.height = hResized
    }
    private fun widthHeightSwap() {
        val t = this.width
        this.width = this.height
        this.height = t
    }

    private fun rotateClockwise(centerX: Int, centerY: Int) {
        val vx = this.x - centerX
        val vy = this.y - centerY
        this.x = centerX + vy
        this.y = centerY - vx
        this.widthHeightSwap()
    }

    private fun rotateCounterClockwise(centerX: Int, centerY: Int) {
        val vx = this.x - centerX
        val vy = this.y - centerY
        this.x = centerX - vy
        this.y = centerY + vx
        this.widthHeightSwap()
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        when (direction) {
            RotateDirection.Clockwise -> rotateClockwise(centerX, centerY)
            RotateDirection.CounterClockwise -> rotateCounterClockwise(centerX, centerY)
        }
    }

    override fun toString(): String {
        return "Rectangle. X: ${this.x}, Y: ${this.y}, Width: ${this.width}, Height: ${this.height}"
    }
}