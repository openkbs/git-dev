/**
  * Created by rs001 on 11/14/2016.
  */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require( d != 0 )

  private val g = Rational.gcd(n.abs, d.abs)
  val numer: Int = n/g * d.signum
  val denom: Int = d.abs/g

  def this(n: Int) = this(n, 1)

  override def toString = numer + (if (denom == 1) "" else ("/"+denom))

  // default methods
  def +(that: Rational): Rational = new Rational( numer * that.denom + that.numer * denom, denom * that.denom )
  def -(that: Rational): Rational = this + (-that)
  def unary_- = new Rational( -numer, denom )
  def abs = new Rational( numer.abs, denom )
  def signum = new Rational( numer.signum )

  def *(that: Rational): Rational = new Rational( this.numer * that.numer, this.denom * that.denom )
  def /(that: Rational): Rational = this * that.inverse
  def inverse = new Rational( denom, numer )

  def compare(that: Rational) = this.numer * that.denom - that.numer * this.denom
  def equals(that: Rational) = this.numer == that.numer && this.denom == that.denom

}

object Rational {
  implicit def intToRational(x: Int) = new Rational(x)
  private def gcd(a: Int, b: Int) : Int = if (b == 0) a else gcd(b, a % b)

  def apply(numer: Int, denom: Int) = new Rational(numer, denom)
  def apply(numer: Int) = new Rational(numer)
}