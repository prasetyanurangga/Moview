package com.prasetyanurangga.moview.ui.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.moview.R
import com.prasetyanurangga.moview.data.factory.MainViewModelFactory
import com.prasetyanurangga.moview.data.model.MovieModel
import com.prasetyanurangga.moview.data.repository.MainRepository
import com.prasetyanurangga.moview.ui.adapter.MovieAdapter
import com.prasetyanurangga.moview.ui.viewmodel.MainViewModel
import com.prasetyanurangga.moview.utils.Status

class MovieFragment() : Fragment() {

    lateinit var listEvent : RecyclerView
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listEvent =  view.findViewById(R.id.list_event_mo)
        createViewModel()
        setListMovies(activity)

    }

    private fun createViewModel()
    {
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository())).get(
            MainViewModel::class.java)
    }

    private fun setListMovies(fragmentActivity: FragmentActivity?) {
        updateUI(mainViewModel.getMovies(),context)
    }

    private fun updateUI(movieModel: List<MovieModel>, context: Context?)
    {
        listEvent.layoutManager = LinearLayoutManager(context)
        listEvent.adapter = MovieAdapter(
            context!!,
            movieModel
        )
    }
}
