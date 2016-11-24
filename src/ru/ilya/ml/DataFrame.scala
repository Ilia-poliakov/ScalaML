package ru.ilya.ml

import scala.io.Source


case class DataFrame(x: Double, y: Double) {

  def +(that: DataFrame) = DataFrame(this.x + that.x, this.y + that.y)
  def -(that: DataFrame) = DataFrame(this.x - that.x, this.y - that.y)
  def /(that: DataFrame) = DataFrame(this.x / that.x, this.y / that.y)
  def /(divider: Double) = DataFrame(this.x / divider, this.y / divider)
  def multXY() = this.x * this.y
  def ^(power: Double) = DataFrame(Math.pow(this.x, power), Math.pow(this.y, power))
}

object DataFrame {

  val SEPARATOR_SEMICOLON = ';'
  val SEPARATOR_COMMA = ','

  def fromCsv(fileName: String):List[DataFrame] = fromCsv(fileName, SEPARATOR_SEMICOLON)

  def fromCsv(fileName: String, separator: Char) = {
    Source.fromFile(fileName).getLines.drop(1).map(line => {
      val values: Array[String] = line.split(separator)
      DataFrame(values(0).toDouble, values(1).toDouble)
    }).toList
  }
}
