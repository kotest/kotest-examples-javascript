package io.kotest.examples.js

import fetch
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldEndWith

class DogTest : FunSpec({
   test("fetching a dog using JS promises") {
      fetch().message.shouldEndWith(".jpg")
   }
})
