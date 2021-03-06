package ger.girod.tutorial.domain.utils

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value : T) : ResultWrapper<T>()
    data class GenericError(val errorMessage : String?) : ResultWrapper<Nothing>()
    data class NetworkError(val errorMessage : String?) : ResultWrapper<Nothing>()
}