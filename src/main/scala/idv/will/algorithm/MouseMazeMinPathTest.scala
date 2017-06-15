package idv.will.algorithm

object MouseMazeMinPathTest {

  /*
   * Find mouse maze minimum path amount
   */

  val array = Array[Array[Int]](
    Array[Int](0, 0, 0, 0, 0),
    Array[Int](1, 1, 0, 1, 0),
    Array[Int](0, 0, 0, 1, 0),
    Array[Int](0, 1, 1, 0, 1),
    Array[Int](0, 0, 0, 0, 0)
  )

  def main(args: Array[String]): Unit = {
    val startX = 0
    val startY = 0
    val rs = move(startX, startY, 0)
    println(rs)
  }

  def move(xIndex: Int, yIndex: Int, step: Int): Int = {
    try {
      if(xIndex == array.length - 1 && yIndex == array(0).length - 1) {
        step
      } else if(step > (array.length - 1)*(array(0).length - 1)) {
        throw new RuntimeException("Over maximum step")
      } else if (array(xIndex)(yIndex) == 1){
        throw new RuntimeException("Hit the wall")
      } else {
        val top = move(xIndex, yIndex-1, step+1)
        val left = move(xIndex-1, yIndex, step+1)
        val bottom = move(xIndex, yIndex+1, step+1)
        val right = move(xIndex+1, yIndex, step+1)
        Array(top, left, bottom, right).min
      }
    } catch {
      case e: Exception => {
        Int.MaxValue
      }
    }
  }

}
