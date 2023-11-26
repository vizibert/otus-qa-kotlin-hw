package lesson_02_class_lambda_generic

// изолированный класс определяет какие классы от него могут быть наследованы
sealed class Result {
    object Loading : Result()
    class Data(val data: String) : Result()
    class Error(val error: Exception) : Result()
}

fun check(result: Result) =
    when (result) {
        is Result.Loading -> "Loading"
        is Result.Data -> "data"
        is Result.Error -> "error"
    }