package echevasoft.frasesrp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://echevasoluciones.com/frasesrp/json_frases.php/")
            //.baseUrl("https://api.npoint.io/c5917fb759bf77a1bb44/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}