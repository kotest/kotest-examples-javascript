import kotlin.js.RegExp

private val socialRegex = RegExp("^\\d{3}-\\d{2}-\\d{4}$")

fun validateSocial(ssn: String): Boolean {
   return socialRegex.test(ssn) && !ssn.contains("0") && !ssn.startsWith("666")
}
