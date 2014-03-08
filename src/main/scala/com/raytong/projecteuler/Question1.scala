package com.raytong.projecteuler

object Question1 {

  def perform(below: Int, multiples: List[Int]): Int = {
    def divisible(x: Int): Boolean = multiples.exists(x % _ == 0)
    (1 until below).filter(divisible(_)).sum
  }
}