package com.kuldeep.pokdex.di

import com.kuldeep.pokdex.data.remote.PokeApi
import com.kuldeep.pokdex.repository.PokemonRepository
import com.kuldeep.pokdex.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @see PokeApi
 * @see PokemonRepository
 * This AppModule class contains the providers
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //provider for the PokemonRepository
    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    //provider for the PokeApi
    @Singleton
    @Provides
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}