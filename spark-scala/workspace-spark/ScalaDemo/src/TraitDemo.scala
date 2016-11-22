/**
  * Created by rs001 on 11/6/2016.
  */
trait TraitDemo {
  trait Similarity {
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  }
}
