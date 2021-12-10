package io.kotest.examples.js

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class PropertyTests : FunSpec({
   test("addition should be commutative") {
      checkAll<Long, Long, Long> { a, b, c ->
         a + b + c shouldBe c + b + a
      }
   }
})
