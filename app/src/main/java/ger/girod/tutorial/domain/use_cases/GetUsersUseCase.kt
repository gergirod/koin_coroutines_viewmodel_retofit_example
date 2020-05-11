package ger.girod.tutorial.domain.use_cases

import ger.girod.tutorial.domain.utils.ResultWrapper
import ger.girod.tutorial.domain.responses.UserListResponse

interface GetUsersUseCase {
    suspend fun getUsers(page : Int , results : Int) : ResultWrapper<UserListResponse>
}