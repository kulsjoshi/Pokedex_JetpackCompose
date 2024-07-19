package com.kuldeep.pokdex.repository

import com.kuldeep.pokdex.data.remote.PokeApi
import com.kuldeep.pokdex.data.remote.response.Pokemon
import com.kuldeep.pokdex.data.remote.response.PokemonList
import com.kuldeep.pokdex.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    /**
     * @see PokeApi
     * @see Resource
     * This function will fetch the pokemon list from the API
     * @param limit
     * @param offset
     * @return Resource<Pokemon>
     */
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(
                limit = limit,
                offset = offset
            )
        } catch (e: Exception) {
            return Resource.Error("Something went wrong with an API")
        }
        return Resource.Success(response)
    }

    /**
     * @see PokeApi
     * @see Resource
     * This function will fetch the pokemon information from the API
     * @param name
     * @return Resource<Pokemon>
     */
    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name = name)
        } catch (e: Exception) {
            return Resource.Error("Something went wrong with an API")
        }
        return Resource.Success(response)
    }
}