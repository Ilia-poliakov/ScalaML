


case class Point(val x: Double, val y: Double) {

  def unary_- = Point(x * -1, y * -1)

  def +(that: Point) = Point(this.x + that.x, this.y + that.y)


}
