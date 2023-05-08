package com.example.peliculas.data.api

import com.example.peliculas.data.objet.MovieDetails
import com.example.peliculas.data.objet.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") id: Int
    ): Single<MovieDetails>

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("page") page: Int
    ): Single<MovieResponse>

}