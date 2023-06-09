package com.example.peliculas.ui.details

import androidx.lifecycle.LiveData
import com.example.peliculas.data.api.TheMovieDBInterface
import com.example.peliculas.data.objet.MovieDetails
import com.example.peliculas.data.repository.MovieDetailsNetworkDataSource
import com.example.peliculas.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository  (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}