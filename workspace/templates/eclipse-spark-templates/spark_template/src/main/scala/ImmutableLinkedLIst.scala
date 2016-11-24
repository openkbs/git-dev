

object ImmutableLinkedLIst {
  def main(args: Array[String]) {
    // Immutable Linked Lists
    val processing = "MapReduce" :: ("Hive" :: ("Spark" :: Nil))
    val query = Nil
    println("Head of processing:" + processing.head)
    println("Some list of processing:" + processing.tail)
    println("Check if processing is empty:" + processing.isEmpty)
    println("Check if query is empty:" + query.isEmpty)

  }
}