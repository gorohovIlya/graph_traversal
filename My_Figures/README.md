# Геометрические фигуры. Демонстрация работы

## Перемещение

### Ожидаемый результат

```text
Rectangle. X: 2, Y: 2, Width: 4, Height: 2
Square. X: 3, Y: 3, Side: 5
Circle. Center X: 7, Center Y: 5, Radius: 3
```

### Код вызова функции

```kotlin
rect.move(2, 2)
println(rect)

square.move(2, 2)
println(square)

circle.move(2, 2)
println(circle)
```

### Результат функции

```text
Результат: Rectangle. X: 2, Y: 2, Width: 4, Height: 2

Результат: Square. X: 3, Y: 3, Side: 5

Результат: Circle. Center X: 7, Center Y: 5, Radius: 3
```

## Поворот

### Ожидаемый результат

```text
Rectangle. X: 1, Y: 0, Width: 4, Height: 8
Square. X: -1, Y: 1, Side: 10
Circle. Center X: 5, Center Y: -7, Radius: 6
```

### Код вызова функции

```kotlin
rect.rotate(RotateDirection.Clockwise, 0, 0)
println(rect)

square.rotate(RotateDirection.CounterClockwise, 0, 0)
println(square)

circle.rotate(RotateDirection.Clockwise, 0, 0)
println(circle)
```

### Результат функции

```text
Результат: Rectangle. X: 1, Y: 0, Width: 4, Height: 8

Результат: Square. X: -1, Y: 1, Side: 10

Результат: Circle. Center X: 5, Center Y: -7, Radius: 6
```

## Увеличение

### Ожидаемый результат

```text
Rectangle. X: 0, Y: 1, Width: 8, Height: 4
Square. X: 1, Y: 1, Side: 10
Circle. Center X: 7, Center Y: 5, Radius: 6
```

### Код вызова функции

```kotlin
rect.resize(2)
println(rect)

square.resize(2)
println(square)

circle.resize(2)
println(circle)
```

### Результат функции

```text
Результат: Rectangle. X: 0, Y: 1, Width: 8, Height: 4

Результат: Square. X: 1, Y: 1, Side: 10

Результат: Circle. Center X: 7, Center Y: 5, Radius: 6
```