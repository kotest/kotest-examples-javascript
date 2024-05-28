package io.kotest.examples.js

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import validateSocial

class SsnTest : FunSpec({

   context("js now allows nested tests") {
      delay(1000) // look ma, I can use coroutines here !
      context("give me another context!") {
         delay(1000) // look ma, I can use coroutines here !
         test("a SSN should be invalid when it contains a zero in any position") {
            delay(1000) // look ma, I can use coroutines here too !
            validateSocial("543-23-5013") shouldBe false
            validateSocial("043-23-5313") shouldBe false
            validateSocial("313-03-5310") shouldBe false
         }
      }
   }

   test("a SSN should be invalid when it starts with 666") {
      validateSocial("666-23-1234") shouldBe false
   }

   test("a SSN should be in the required format") {
      validateSocial("123-45-6789") shouldBe true
      validateSocial("123-45-678") shouldBe false
      validateSocial("12-45-6789") shouldBe false
      validateSocial("1234-56-678") shouldBe false
      validateSocial("123456789") shouldBe false
      validateSocial("123-456789") shouldBe false
      validateSocial("12345-6789") shouldBe false
      validateSocial("") shouldBe false
   }

})
