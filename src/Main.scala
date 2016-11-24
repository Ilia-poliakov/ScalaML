import ru.ilya.ml.{DataFrame, LinearRegression}


object Main {

  def main(args: Array[String]): Unit = {

    val humanMetrics: List[DataFrame] = DataFrame.fromCsv("Davis.csv").filter(f => f.x < 115)
    val y: (Double) => Double = LinearRegression.buildModel(humanMetrics)

    println(y(80))

  }
}
