package com.example.peliculas.ui.details

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class MovieViewModel(private val movieRepository : MovieDetailsRepository, movieId: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val  movieDetails by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}