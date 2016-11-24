import ru.ilya.ml.DataFrame


object Main {


  def main(args: Array[String]): Unit = {

    // http://www.math-pr.com/exampl_sts3.htm


//    val humanMetrics: List[DataFrame] = DataFrame.fromCsv("Davis.csv")
    val humanMetrics: List[DataFrame] = DataFrame.fromCsv("d.csv")

    val sumMetrics = humanMetrics.reduce(_+_)

    val meanX = sumMetrics.x / humanMetrics.size
    val meanY = sumMetrics.y / humanMetrics.size

    val meanXY = humanMetrics.map(_.multXY()).reduce(_+_) / humanMetrics.size
    val sqSumXY = humanMetrics.map(_^2).reduce(_+_) / humanMetrics.size - DataFrame(meanX * meanX, meanY * meanY)
    val rXY = (meanXY - meanX * meanY) / Math.sqrt(sqSumXY.multXY)

    val b = rXY * (Math.sqrt(sqSumXY.y / sqSumXY.x))
    val a = meanY - (b * meanX)

    println(a)
    println(b)



  }
}
