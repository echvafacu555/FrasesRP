package echevasoft.frasesrp.data.model.network

import echevasoft.frasesrp.data.model.FraseModel
import retrofit2.Response
import retrofit2.http.GET

interface FraseApiClient {
 //   @GET("/.json")
 @GET(" ")
    suspend fun getAllFrases(): Response<List<FraseModel>>

}