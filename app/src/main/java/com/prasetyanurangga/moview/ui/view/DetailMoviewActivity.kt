package com.prasetyanurangga.moview.ui.view

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prasetyanurangga.moview.R
import com.prasetyanurangga.moview.data.factory.MainViewModelFactory
import com.prasetyanurangga.moview.data.model.MovieModel
import com.prasetyanurangga.moview.data.model.TvShowModel
import com.prasetyanurangga.moview.data.repository.MainRepository
import com.prasetyanurangga.moview.ui.viewmodel.MainViewModel
import com.prasetyanurangga.moview.utils.Status

class DetailMoviewActivity : AppCompatActivity(){

    private lateinit var mainViewModel: MainViewModel

    lateinit var txt_title : TextView
    lateinit var txt_overview : TextView
    lateinit var txt_release_date : TextView
    lateinit var txt_vote_a : TextView
    lateinit var txt_vote_c : TextView
    lateinit var txt_lang : TextView
    lateinit var txt_adult : TextView
    lateinit var img_moview : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_moview)
        createViewModel()

        supportActionBar?.title = "Detail Moview"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val idMoview = intent.getIntExtra("idMoview", 0)
        val typeMoview = intent.getStringExtra("typeMoview")

        txt_title = findViewById<TextView>(R.id.txt_title_moview)
        txt_overview = findViewById<TextView>(R.id.txt_overview_moview)
        txt_release_date = findViewById<TextView>(R.id.txt_date_moview)
        txt_vote_a = findViewById<TextView>(R.id.txt_vote_a_moview)
        txt_vote_c = findViewById<TextView>(R.id.txt_vote_c_moview)
        txt_lang = findViewById<TextView>(R.id.txt_language_moview)
        txt_adult = findViewById<TextView>(R.id.txt_adult_moview)
        img_moview = findViewById<ImageView>(R.id.img_moview)

        if(typeMoview == "movie")
        {
            setDetailMovie(idMoview!!)
        }
        else
        {
            setDetailTvShow(idMoview!!)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun createViewModel()
    {
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository())).get(
            MainViewModel::class.java)
    }

    private fun setDetailMovie(id: Int) {
        updateUIMovie(mainViewModel.getMovieById(id))
    }

    private fun setDetailTvShow(id: Int) {
        updateUITvShow(mainViewModel.getTvShowById(id))
    }

    private fun updateUIMovie(movieModel: MovieModel)
    {
            txt_title.setText(movieModel.title)
            txt_overview.setText(movieModel.overview)
            txt_release_date.setText(movieModel.releaseDate)
            txt_lang.setText(movieModel.originalLanguage)
            txt_vote_a.setText(movieModel.voteAverage)
            txt_vote_c.setText(movieModel.voteCount)
            txt_adult.setText(if(movieModel.isAdult) "Yes" else "No")
            img_moview.setImageResource(movieModel.image)
    }

    private fun updateUITvShow(tvShow: TvShowModel)
    {
            txt_title.setText(tvShow.title)
            txt_overview.setText(tvShow.overview)
            txt_release_date.setText(tvShow.firstAirDate)
            txt_lang.setText(tvShow.originalLanguage)
            txt_vote_a.setText(tvShow.voteAverage)
            txt_vote_c.setText(tvShow.voteCount)
            txt_adult.setText(if(tvShow.isAdult) "Yes" else "No")
            img_moview.setImageResource(tvShow.image)
    }

}
