package com.example.peliculas.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.peliculas.data.api.TheMovieDBInterface
import com.example.peliculas.ui.details.Movie
import io.reactivex.disposables.CompositeDisposable


class MovieDataSourceFactory(private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}
}