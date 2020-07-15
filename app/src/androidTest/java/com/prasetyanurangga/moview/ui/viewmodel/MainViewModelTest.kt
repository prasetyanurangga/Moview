package com.prasetyanurangga.moview.ui.viewmodel

import com.prasetyanurangga.moview.data.local.MoviewData
import com.prasetyanurangga.moview.data.repository.MainRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private val dummyMovie = MoviewData.getDataMovie()[0]
    private val dummyTvShow = MoviewData.getDataTvShow()[0]

    private val movieId = dummyMovie.id
    private val tvshowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = MainViewModel(MainRepository())
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }

    @Test
    fun getMovieById() {
        val movieEntities = viewModel.getMovieById(movieId)
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.id, movieEntities.id)
        assertEquals(dummyMovie.image, movieEntities.image)
        assertEquals(dummyMovie.isAdult, movieEntities.isAdult)
        assertEquals(dummyMovie.overview, movieEntities.overview)
        assertEquals(dummyMovie.originalLanguage, movieEntities.originalLanguage)
        assertEquals(dummyMovie.releaseDate, movieEntities.releaseDate)
        assertEquals(dummyMovie.title, movieEntities.title)
        assertEquals(dummyMovie.voteAverage, movieEntities.voteAverage)
        assertEquals(dummyMovie.voteCount, movieEntities.voteCount)
    }

    @Test
    fun getTvShows() {
        val tvEntities = viewModel.getTvShows()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }

    @Test
    fun getTvShowById() {
        val tvEntities = viewModel.getTvShowById(tvshowId)
        assertNotNull(tvEntities)
        assertEquals(dummyTvShow.id, tvEntities.id)
        assertEquals(dummyTvShow.image, tvEntities.image)
        assertEquals(dummyTvShow.isAdult, tvEntities.isAdult)
        assertEquals(dummyTvShow.overview, tvEntities.overview)
        assertEquals(dummyTvShow.originalLanguage, tvEntities.originalLanguage)
        assertEquals(dummyTvShow.firstAirDate, tvEntities.firstAirDate)
        assertEquals(dummyTvShow.title, tvEntities.title)
        assertEquals(dummyTvShow.voteAverage, tvEntities.voteAverage)
        assertEquals(dummyTvShow.voteCount, tvEntities.voteCount)
    }
}