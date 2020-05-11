package ger.girod.tutorial.data.repositories

import ger.girod.tutorial.data.api.Api
import ger.girod.tutorial.data.utils.NetworkHandler
import ger.girod.tutorial.data.utils.executeNetworkRequest
import ger.girod.tutorial.domain.responses.UserListResponse
import ger.girod.tutorial.domain.use_cases.GetUsersUseCase
import ger.girod.tutorial.domain.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinComponent
import org.koin.core.inject

class UsersRepository(private val api : Api) : GetUsersUseCase , KoinComponent {

    private val networkHandler : NetworkHandler by inject()

    override suspend fun getUsers(page: Int, results: Int): ResultWrapper<UserListResponse> {
        return executeNetworkRequest(Dispatchers.IO, networkHandler) {
            api.getUsers(page, results)
        }
    }
}