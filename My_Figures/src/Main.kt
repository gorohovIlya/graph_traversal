fun main() {

    // интерфейсы удобно использовать в коллекциях
    val figures: Array<Movable>
    val movable: Movable = Rect(0,0,1,1)
    movable.move(1,1)
    // переменной базового класса
    val f: Figure = Rect(0,0,4,2)
    val f2: Figure = Circle(5, 3, 3)

//    println(f.area())
//    println(f2.area())
//    f.rotate(RotateDirection.CounterClockwise, 2, 1)
    f.resize(2)
    f2.resize(3)
    print(f2.toString())
}