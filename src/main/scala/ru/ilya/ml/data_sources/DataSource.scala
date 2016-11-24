package main.scala.ru.ilya.ml.data_sources



trait DataSource[T] {

  def getAll(): List[T];

}
