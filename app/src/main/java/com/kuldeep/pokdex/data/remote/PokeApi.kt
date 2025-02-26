package com.kuldeep.pokdex.data.remote

import com.kuldeep.pokdex.data.remote.response.Pokemon
import com.kuldeep.pokdex.data.remote.response.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * This interface contains the API request of the retrofit
 */
interface PokeApi {

    //this will fetch the pokemon list
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    //this will fetch the pokemon info
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name : String
    ): Pokemon

}