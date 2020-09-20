import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText

private val client = HttpClient(Js)

suspend fun fetch(): Dog {
   val resp = client.get<HttpResponse>("https://dog.ceo/api/breeds/image/random")
   return JSON.parse<Dog>(resp.readText())
}

data class Dog(val message: String, val status: String)

