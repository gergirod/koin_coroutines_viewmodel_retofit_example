package ger.girod.tutorial.domain.responses

import ger.girod.tutorial.domain.models.UserModel

data class UserListResponse (
    val results: List<UserModel>
)