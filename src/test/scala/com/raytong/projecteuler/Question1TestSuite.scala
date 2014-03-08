package com.raytong.projecteuler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks._
import com.raytong.projecteuler.Question1._

@RunWith(classOf[JUnitRunner])
class Question1TestSuite extends FunSuite with Matchers {

  val question1Data = Table(
    ("below", "multiples", "result"),
    (10, List(3, 5), 23),
    (1000, List(3, 5), 233168)
  )
  test("perform") {
    forAll(question1Data) {
      (below: Int, multiples: List[Int], result: Int) =>
        perform(below, multiples) should be(result)
    }
  }
}