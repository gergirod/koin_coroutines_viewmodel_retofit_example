package ger.girod.tutorial.domain.models

data class LocationModel(
    val city : String,
    val state : String,
    val postcode : String,
    val coordinates : CoordinatesModel)