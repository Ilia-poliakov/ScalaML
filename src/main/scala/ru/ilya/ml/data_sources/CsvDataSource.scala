package main.scala.ru.ilya.ml.data_sources

import ru.ilya.ml.DataFrame

import scala.io.Source


class CsvDataSource(fileName: String) extends DataSource[DataFrame]{

  override def getAll(): List[DataFrame] = {
    Source.fromFile(fileName).getLines.drop(1).map(line => {
      val values: Array[String] = line.split(',')
      DataFrame(values(0).toDouble, values(1).toDouble)
    }).toList
  }
}
