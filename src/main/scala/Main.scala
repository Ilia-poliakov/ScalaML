import main.scala.ru.ilya.ml.data_sources.{CsvDataSource, DataSource}
import ru.ilya.ml.{DataFrame, LinearRegression}


object Main {

  def main(args: Array[String]): Unit = {

    val dataSource: DataSource[DataFrame] = new CsvDataSource("Davis.csv")

    val humanMetrics: List[DataFrame] = dataSource.getAll().filter(f => f.x < 115)
    val y = LinearRegression.buildModel(humanMetrics)

    println(y(30))

  }
}
