package idv.will.algorithm

object MinScorePathTest {

  /*
   * Walk start from top left position, available move is to bottom or to right.
   * If next one value is greater than current one, the score will be added as next one - current one.
   * If next one value is not greater than current one, the score will be count as 0.
   * Find the minimum score
   */

  val array = Array[Array[Int]](
    Array[Int](1, 4, 5, 3),
    Array[Int](1, 3, 4, 3),
    Array[Int](3, 2, 4, 3),
    Array[Int](5, 1, 1, 1)
  )

  def main(args: Array[String]): Unit = {
    val startX = 0
    val startY = 0
    val rs = calScore(startX, startY, array(startX)(startY), 0)
    println(rs)
  }

  def calScore(xIndex: Int, yIndex: Int, previousV: Int, point: Int): Int = {
    try {
      val v = if(array(xIndex)(yIndex) > previousV ) array(xIndex)(yIndex)-previousV else 0
      if(xIndex == array.length-1 && yIndex == array(0).length-1) {
        point
      } else {
        val vRight = calScore(xIndex+1, yIndex, array(xIndex)(yIndex), point+v)
        val vBottom = calScore(xIndex, yIndex+1, array(xIndex)(yIndex), point+v)
        Math.min(vRight, vBottom)
      }
    } catch {
      case e: Exception => {
        Int.MaxValue
      }
    }
  }

}
