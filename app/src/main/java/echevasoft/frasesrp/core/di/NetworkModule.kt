package echevasoft.frasesrp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import echevasoft.frasesrp.data.model.network.FraseApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://echevasoluciones.com/frasesrp/json_frases.php/")
                //.baseUrl("https://api.npoint.io/c5917fb759bf77a1bb44/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    @Singleton
    @Provides
    fun provideFraseApiClient(retrofit: Retrofit):FraseApiClient{
            return retrofit.create(FraseApiClient::class.java)

    }
}