// Kotlin - Sealed Classes (ApiResponse)
sealed class ApiResponse {
    data class Success(val userProfile: String) : ApiResponse()
    sealed class Error : ApiResponse() {
        object Unauthorized : Error()
        object NotFound : Error()
        data class ServerError(val errorCode: Int, val message: String) : Error()
    }
}

fun handleResponse(response: ApiResponse) {
    when (response) {
        is ApiResponse.Success -> println("Success! Loading profile: ${'$'}{response.userProfile}")
        is ApiResponse.Error.Unauthorized -> println("ALERT: Unauthorized access attempt detected!")
        is ApiResponse.Error.NotFound -> println("Error: User profile not found.")
        is ApiResponse.Error.ServerError -> println("Error: Server failed with code ${'$'}{response.errorCode}: ${'$'}{response.message}")
    }
}

fun main() {
    val responses = listOf(
        ApiResponse.Success("{ 'user': 'admin', 'level': 99 }"),
        ApiResponse.Error.Unauthorized,
        ApiResponse.Error.ServerError(503, "Database connection failed")
    )
    for (r in responses) handleResponse(r)
}
