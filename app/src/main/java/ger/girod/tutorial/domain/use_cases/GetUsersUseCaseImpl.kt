package ger.girod.tutorial.domain.use_cases

import ger.girod.tutorial.data.repositories.UsersRepository
import ger.girod.tutorial.domain.responses.UserListResponse
import ger.girod.tutorial.domain.utils.ResultWrapper


fun provideUsersUseCase(usersRepository: UsersRepository) : GetUsersUseCase {
    return GetUsersUseCaseImpl(usersRepository)
}

class GetUsersUseCaseImpl(private val usersRepository: UsersRepository) : GetUsersUseCase {

    override suspend fun getUsers(page: Int, results: Int): ResultWrapper<UserListResponse> {
        return usersRepository.getUsers(page, results)
    }
}