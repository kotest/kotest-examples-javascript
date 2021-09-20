package io.kotest.examples.js

import io.kotest.core.Tuple2
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

data class PythagTriple(val a: Int, val b: Int, val c: Int)

class DataTest : FunSpec({

   withData(
      PythagTriple(8, 15, 17),
      PythagTriple(9, 12, 15),
      PythagTriple(15, 20, 25),
   ) { (a, b, c) ->
      a * a + b * b shouldBe c * c
   }

   test(PythagTriple(8, 15, 17).toString()) {

   }

   test("foo\\.json") {

   }

   withData(
      nameFn = { it.a },
      Tuple2("a.json", "b"),
      Tuple2("b.json", "c"),
   ) { (a, b) ->
      println(a)
   }
})
