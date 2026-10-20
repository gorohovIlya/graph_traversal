fun main() {
    print("Введите число вершин N: ")
    val n = readln().trim().toInt()

    println("Введите матрицу смежности ($n строк по $n чисел через пробел):")
    val adj = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val row = readln().trim().split(Regex("\\s+"))
        for (j in 0 until n) {
            adj[i][j] = row[j].toInt()
        }
    }

    print("Введите начальную вершину K (0..${n - 1}): ")
    val k = readln().trim().toInt()

    val dist = IntArray(n) { -1 }
    dist[k] = 0

    fun dfs(v: Int) {
        for (u in 0..<n) {
            if (adj[v][u] != 0) {
                val newDist = dist[v] + 1
                if (dist[u] == -1 || newDist < dist[u]) {
                    dist[u] = newDist
                    dfs(u)
                }
            }
        }
    }

    dfs(k)

    println("Результат (вершина — расстояние от K):")
    for (i in 0 until n) {
        println("$i ${dist[i]}")
    }
}