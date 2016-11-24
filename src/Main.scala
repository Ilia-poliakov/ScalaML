import ru.ilya.ml.{DataFrame, LinearRegression}


object Main {
  //    val humanMetrics: List[DataFrame] = DataFrame.fromCsv("Davis.csv")

  def main(args: Array[String]): Unit = {

    val humanMetrics: List[DataFrame] = DataFrame.fromCsv("Davis.csv")
//    val humanMetrics: List[DataFrame] = DataFrame.fromCsv("d.csv")
    val y: (Double) => Double = LinearRegression.buildModel(humanMetrics)

    println(y(25.9))

  }
}
