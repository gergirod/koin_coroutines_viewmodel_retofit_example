package ger.girod.tutorial.data.api

import ger.girod.tutorial.data.utils.BASE_URL
import ger.girod.tutorial.domain.responses.UserListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(
        BASE_URL)
    suspend fun getUsers(@Query("page") page : Int, @Query("results") results : Int) : UserListResponse
}