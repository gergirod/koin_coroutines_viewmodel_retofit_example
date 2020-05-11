package ger.girod.tutorial.data.utils

import android.util.Log
import ger.girod.tutorial.domain.utils.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <T> executeNetworkRequest(dispatcher: CoroutineDispatcher, networkHandler: NetworkHandler, request: suspend () -> T) :ResultWrapper<T> {
    return withContext(dispatcher) {
        if(networkHandler.isInternetAvailable()) {
            Log.e("miarr aca ","mirar aca hago esto carajo 2")
            try {
                ResultWrapper.Success(request.invoke())
            }catch (e : Exception) {
                Log.e("mirar aca ","mirar aca error "+e.message)
                ResultWrapper.GenericError(e.message)
            }
        }else {
            ResultWrapper.NetworkError("no internet connection")
        }
    }
}
