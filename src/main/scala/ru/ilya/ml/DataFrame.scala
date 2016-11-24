package ru.ilya.ml


case class DataFrame(x: Double, y: Double) {

  def +(that: DataFrame) = DataFrame(this.x + that.x, this.y + that.y)
  def -(that: DataFrame) = DataFrame(this.x - that.x, this.y - that.y)
  def /(divider: Double) = DataFrame(this.x / divider, this.y / divider)
  def multXY() = this.x * this.y
  def ^(power: Double) = DataFrame(Math.pow(this.x, power), Math.pow(this.y, power))
}

