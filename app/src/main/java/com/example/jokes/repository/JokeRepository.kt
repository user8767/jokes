class JokeRepository {
    private val api = RetrofitInstance.api

    suspend fun fetchJoke(): String {
        val response = api.getRandomJoke()  // Fetch the JokeResponse object
        return "${response.setup} ${response.punchline}"  // Format it as a string
    }
}
