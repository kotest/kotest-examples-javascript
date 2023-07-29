import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

private val client = HttpClient(Js)

suspend fun fetch(): Dog {
   val resp = client.get("https://dog.ceo/api/breeds/image/random")
   var message = ""
   var status = ""
   JSON.parse<Dog>(resp.bodyAsText()) { key, value ->
      when (key) {
         "message" -> message = value.toString()
         "status" -> status = value.toString()
      }
   }
   return Dog(message, status)
}

data class Dog(val message: String, val status: String)

