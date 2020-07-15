package com.prasetyanurangga.moview.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prasetyanurangga.moview.data.model.MovieModel
import com.prasetyanurangga.moview.data.model.TvShowModel
import com.prasetyanurangga.moview.data.repository.MainRepository

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    fun getMovies(): List<MovieModel>{
        return mainRepository.getMovies()
    }

    fun getTvShows(): List<TvShowModel>{
        return mainRepository.getTvShows()
    }

    fun getMovieById(id: Int): MovieModel{
        return mainRepository.getMovieById(id)
    }

    fun getTvShowById(id: Int): TvShowModel{
        return mainRepository.getTvShowById(id)
    }

}