package com.prasetyanurangga.moview.data.model

data class TvShowModel (
    var id: Int,
    var title: String,
    var overview: String,
    var originalLanguage: String,
    var firstAirDate: String,
    var voteAverage:String,
    var voteCount:String,
    var isAdult : Boolean,
    var image: Int
)