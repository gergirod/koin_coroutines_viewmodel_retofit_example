package ger.girod.tutorial.domain.models

data class NameModel(
    val title : String,
    val first : String,
    val last : String
) {


    fun getFullName() : String {
        return "$first $last"
    }

}