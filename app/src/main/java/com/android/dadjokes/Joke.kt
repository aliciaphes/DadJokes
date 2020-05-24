package com.android.dadjokes

import com.squareup.moshi.Json

data class Joke
    (
//    @field:Json(name = "id") val id: String,
//    @field:Json(name = "joke") val joke: String,
//    @field:Json(name = "status") val status: String

    @Json(name = "id") val id: String,
    @Json(name = "joke") val joke: String,
    @Json(name = "status") val status: Int
)
