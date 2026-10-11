
fun main() {
    print("Введите имя CSV-файла: ")
    val csvPath = readlnOrNull() ?: return

    print("Введите имя JSON-файла: ")
    val jsonPath = readlnOrNull() ?: return

    val parser = Parser()
    parser.parse(csvPath, jsonPath)
}
