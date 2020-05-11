package ger.girod.tutorial.domain.models


data class UserModel(
    val gender : String,
    val name : NameModel,
    val location : LocationModel,
    val email : String,
    val phone : String,
    val cell : String,
    val picture : PictureModel
)