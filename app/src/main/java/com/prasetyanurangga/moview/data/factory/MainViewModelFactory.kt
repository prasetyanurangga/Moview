package com.prasetyanurangga.moview.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prasetyanurangga.moview.data.repository.MainRepository
import com.prasetyanurangga.moview.ui.viewmodel.MainViewModel

class MainViewModelFactory(private val mainRepository: MainRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(mainRepository) as T
        }

        throw IllegalArgumentException("UNKOnw")
    }
}