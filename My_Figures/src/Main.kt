fun main() {
    val rect: Figure = Rect(0, 0, 4, 2)
    val circle: Figure = Circle(5, 3, 3)
    val square: Figure = Square(1, 1, 5)

    // Перемещение прямоугольника
    rect.move(2, 2)
    println("Результат: $rect")

    // Перемещение квадрата
    square.move(2, 2)
    println("\nРезультат: $square")

    // Перемещение круга
    circle.move(2, 2)
    println("\nРезультат: $circle")

    // Увеличение прямоугольника в 2 раза
    rect.resize(2)
    println("\nРезультат: $rect")

    // Увеличение квадрата в 2 раза
    square.resize(2)
    println("\nРезультат: $square")

    // Увеличение круга в 2 раза
    circle.resize(2)
    println("\nРезультат: $circle")

    // Поворот прямоугольника по часовой стрелке
    rect.rotate(RotateDirection.Clockwise, 0, 0)
    println("\nРезультат: $rect")

    // Поворот квадрата против часовой стрелки
    square.rotate(RotateDirection.CounterClockwise, 0, 0)
    println("\nРезультат: $square")

    // Поворот круга по часовой стрелке
    circle.rotate(RotateDirection.Clockwise, 0, 0)
    println("\nРезультат: $circle")
}