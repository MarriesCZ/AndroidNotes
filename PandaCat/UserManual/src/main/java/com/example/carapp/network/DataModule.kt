package com.example.carapp.network

import android.content.Context
import com.example.carapp.network.constants.BASE_URL
import com.example.carapp.network.dto.UserManualDto
import com.example.carapp.network.helper.UserManualDtoDeserializer
import com.example.carapp.network.modelcase.UserManualRepository
import com.example.carapp.network.modelcase.UserManualRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


/**
 * Setup project needed injections
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    // Provide coroutines dispatchers
    @MainDispatcher
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @IoDispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    // Provide Repositories
    @Provides
    @Singleton
    fun provideUserManualApi(): UserManualApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
//                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
//                }
            }
            ).build())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .registerTypeAdapter(
                            UserManualDto::class.java,
                            UserManualDtoDeserializer()
                        )
                        .create()
                )
            )
            .build()
            .create(UserManualApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserManualRepository(
        @ApplicationContext appContext: Context,
        remoteRepository: RemoteRepository
    ): UserManualRepository {
        return UserManualRepositoryImpl(appContext, remoteRepository)
    }
}

// Annotations for coroutines
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoDispatcher