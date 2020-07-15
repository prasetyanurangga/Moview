package com.prasetyanurangga.moview.data.repository

import com.prasetyanurangga.moview.data.local.MoviewData
import com.prasetyanurangga.moview.data.model.MovieModel
import com.prasetyanurangga.moview.data.model.TvShowModel


class MainRepository() {

    fun getMovies(): List<MovieModel> {
        return MoviewData.getDataMovie()
    }

    fun getTvShows(): List<TvShowModel> {
        return MoviewData.getDataTvShow()
    }

    fun getMovieById(id: Int): MovieModel{
        return MoviewData.getDataMovie().first() {
            it.id == id
        }
    }

    fun getTvShowById(id: Int): TvShowModel {
        return MoviewData.getDataTvShow().first() {
            it.id == id
        }
    }
}