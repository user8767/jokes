import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import kotlinx.coroutines.Dispatchers

class JokeViewModel : ViewModel() {
    private val repository = JokeRepository()

    var joke by mutableStateOf("Click the button for a joke!")
        private set

    fun getJoke() {
        viewModelScope.launch(Dispatchers.IO) {  // Runs on background thread
            try {
                val newJoke = repository.fetchJoke()
                joke = newJoke  // Update UI state safely
            } catch (e: Exception) {
                joke = "Failed to fetch joke!"
            }
        }
    }
}
