import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText

private val client = HttpClient(Js)

suspend fun fetch(): Dog {
   val resp = client.get<HttpResponse>("https://dog.ceo/api/breeds/image/random")
   var message = ""
   var status = ""
   JSON.parse<Dog>(resp.readText()) { key, value ->
      when (key) {
         "message" -> message = value.toString()
         "status" -> status = value.toString()
      }
   }
   return Dog(message, status)
}

data class Dog(val message: String, val status: String)

