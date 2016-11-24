package ru.ilya.ml


object LinearRegression {

  def buildModel(dataFrames: List[DataFrame]): (Double => Double) = {

    val sumMetrics = dataFrames.reduce(_ + _)

    val meanX = sumMetrics.x / dataFrames.size
    val meanY = sumMetrics.y / dataFrames.size

    val meanXY = dataFrames.map(_.multXY()).reduce(_ + _) / dataFrames.size
    val sqSumXY = dataFrames.map(_ ^ 2).reduce(_ + _) / dataFrames.size - DataFrame(meanX * meanX, meanY * meanY)
    val rXY = (meanXY - meanX * meanY) / Math.sqrt(sqSumXY.multXY)

    val b = rXY * (Math.sqrt(sqSumXY.y / sqSumXY.x))
    val a = meanY - (b * meanX)

    x: Double => a + b * x
  }
}
