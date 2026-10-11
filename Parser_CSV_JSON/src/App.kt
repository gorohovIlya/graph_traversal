
class App(
        var app: String,
        var category: String,
        var rating: String,
        var reviews: String,
        var size: String,
        var installs: String,
        var type: String,
        var price: String,
        var contentRating: String,
        var genres: String,
        var lastUpdated: String,
        var currentVer: String,
        var androidVer: String)
{
    var androidAPI = 0
    var installsNumber = 0
    var boolPrice = true
    // var genresList = mutableListOf<String>()
    var lastUpdatedISO8601 = ""

    private fun androidVerToAPI() : Unit {
        val androidVerSplitted = this.androidVer.split(" ")[0]
        var api = 0
        when (androidVerSplitted) {
            "1.0" -> api = 1
            "1.1" -> api = 2
            "1.5" -> api = 3
            "1.6" -> api = 4
            "2.0" -> api = 5
            "2.0.1" -> api = 6
            "2.1" -> api = 7
            "2.2" -> api = 8
            "2.3" -> api = 9
            "2.3.3" -> api = 10
            "3.0" -> api = 11
            "3.1" -> api = 12
            "3.2" -> api = 13
            "4.0.1", "4.0.2" -> api = 14
            "4.0.3", "4.0.4" -> api = 15
            "4.1" -> api = 16
            "4.2" -> api = 17
            "4.3" -> api = 18
            "4.4" -> api = 19
            "4.4W" -> api = 20
            "5.0" -> api = 21
            "5.1" -> api = 22
            "6.0" -> api = 23
            "7.0" -> api = 24
            "7.1", "7.1.1", "7.1.2" -> api = 25
            "8.0" -> api = 26
            "8.1" -> api = 27
            "9" -> api = 28
            "10" -> api = 29
            "11" -> api = 30
            "12" -> api = 31
            "12L" -> api = 32
            "13" -> api = 33
            "14" -> api = 34
            "15" -> api = 35
            "16" -> api = 36
            "16.1" -> api = 36
            "17" -> api = 37
            "17.1" -> api = 37
        }
        this.androidAPI = api
    }

    private fun installsNumberToInt() : Unit {
        val installsWithoutComma = this.installs.replace(",", "")
        val installsWithoutCommaAndPlus = installsWithoutComma.replace("+", "")
        this.installsNumber = installsWithoutCommaAndPlus.toInt()
    }

    private fun priceToBool() : Unit {
        when (this.type) {
            "Free" -> this.boolPrice = false
            "Paid" -> this.boolPrice = true
        }
    }

    private fun lastUpdatedToISO() : Unit {
        var year: String
        var day: String
        var month = "00"
        val time = "T13:45:00.000Z"
        val dateList = this.lastUpdated.split(" ", ", ")
        year = dateList[2]
        day = dateList[1]
        when (dateList[0].lowercase()) {
            "january" -> month = "01"
            "february" -> month = "02"
            "march" -> month = "03"
            "april" -> month = "04"
            "may" -> month = "05"
            "june" -> month = "06"
            "july" -> month = "07"
            "august" -> month = "08"
            "september" -> month = "09"
            "october" -> month = "10"
            "november" -> month = "11"
            "december" -> month = "12"
        }
        val processedDate = "$year-$month-$day$time"
        this.lastUpdatedISO8601 = processedDate
    }


    private fun escapeJSON(value: String): String {
        return value
            .replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\b", "\\b")
            .replace("\u000C", "\\f")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t")
    }

    fun toJSONString(): String {
        installsNumberToInt()
        lastUpdatedToISO()
        androidVerToAPI()
        priceToBool()

        val genresJSON = genres
            .split(";")
            .joinToString(", ") { "\"${escapeJSON(it)}\"" }

        return """
        "${escapeJSON(app)}": {
            "category": "${escapeJSON(category)}",
            "rating": ${this.rating.toFloat()},
            "reviews": ${this.reviews.toInt()},
            "size": "${escapeJSON(size)}",
            "installs": ${this.installsNumber.toInt()},
            "type": "${this.type}",
            "price": ${this.boolPrice},
            "content_rating": "${escapeJSON(contentRating)}",
            "genres": [$genresJSON],
            "last_updated": "${escapeJSON(lastUpdatedISO8601)}",
            "current_ver": "${escapeJSON(currentVer)}",
            "android_ver": ${this.androidAPI}
        }
    """.trimIndent()
    }

}