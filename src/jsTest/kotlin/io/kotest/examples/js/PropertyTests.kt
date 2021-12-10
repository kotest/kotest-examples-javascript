package io.kotest.examples.js

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.ints

class PropertyTests : FunSpec({
   test("addition should be commutative") {
      checkAll<Long, Long, Long> { a, b, c ->
         a + b + c shouldBe c + b + a
      }
   }

   test("addition should be associative") {
      checkAll<Long, Long> { a, b ->
         checkAll(Exhaustive.ints(1..100)) { c ->
            (a + b) + c shouldBe a + (b + c)
         }
      }
   }
})
