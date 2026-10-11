
import java.io.File

class Parser {

    fun parse(csvPath: String, jsonPath: String) {
        val csvFile = File(csvPath)
        val jsonFile = File(jsonPath)

        require(csvFile.exists() && csvFile.isFile) {
            "CSV-файл не найден: $csvPath"
        }

        val csvContent = csvFile.readText(Charsets.UTF_8)
        val rows = parseCSV(csvContent)

        require(rows.isNotEmpty()) {
            "CSV-файл пуст"
        }

        val apps = mutableListOf<App>()

        for (originalRow in rows.drop(1)) {
            if (originalRow.all { it.isBlank() }) continue

            val row = originalRow.toMutableList()

            if (row.size == 12) {
                row.add(1, "")
            }

            require(row.size == 13) {
                "Некорректная запись CSV: ожидалось 13 столбцов, получено ${row.size}"
            }

            apps.add(
                App(
                    app = row[0],
                    category = row[1],
                    rating = row[2],
                    reviews = row[3],
                    size = row[4],
                    installs = row[5],
                    type = row[6],
                    price = row[7],
                    contentRating = row[8],
                    genres = row[9],
                    lastUpdated = row[10],
                    currentVer = row[11],
                    androidVer = row[12]
                )
            )
        }

        jsonFile.writeText(
            apps.joinToString(
                separator = ",\n",
                prefix = "{\n",
                postfix = "\n}\n"
            ) { it.toJSONString() },
            Charsets.UTF_8
        )

        println("Обработано приложений: ${apps.size}")
        println("Результат записан в: ${jsonFile.absolutePath}")
    }

    private fun parseCSV(content: String): List<List<String>> {
        val rows = mutableListOf<List<String>>()
        var row = mutableListOf<String>()
        val field = StringBuilder()
        var inQuotes = false
        var i = 0

        while (i < content.length) {
            val c = content[i]

            when {
                c == '"' && inQuotes &&
                        i + 1 < content.length &&
                        content[i + 1] == '"' -> {
                    field.append('"')
                    i++
                }

                c == '"' -> {
                    inQuotes = !inQuotes
                }

                c == ',' && !inQuotes -> {
                    row.add(field.toString())
                    field.setLength(0)
                }

                (c == '\n' || c == '\r') && !inQuotes -> {
                    if (c == '\r' &&
                        i + 1 < content.length &&
                        content[i + 1] == '\n'
                    ) {
                        i++
                    }

                    row.add(field.toString())
                    field.setLength(0)

                    rows.add(row)
                    row = mutableListOf()
                }

                else -> field.append(c)
            }

            i++
        }

        if (field.isNotEmpty() || row.isNotEmpty()) {
            row.add(field.toString())
            rows.add(row)
        }

        return rows
    }
}
