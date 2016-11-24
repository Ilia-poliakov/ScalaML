package ru.ilya.ml


object LinearRegression {

  def buildModel(dataFrames: List[DataFrame]): (Double => Double) = {

    val meanMetrics = dataFrames.reduce(_ + _) / dataFrames.size

    val meanXY = dataFrames.map(_.multXY).reduce(_ + _) / dataFrames.size
    val sqSumXY = dataFrames.map(_ ^ 2).reduce(_ + _) / dataFrames.size - (meanMetrics^2)
    val rXY = (meanXY - meanMetrics.x * meanMetrics.y) / Math.sqrt(sqSumXY.multXY)

    val b = rXY * (Math.sqrt(sqSumXY.y / sqSumXY.x))
    val a = meanMetrics.y - (b * meanMetrics.x)

    x: Double => a + b * x
  }
}
