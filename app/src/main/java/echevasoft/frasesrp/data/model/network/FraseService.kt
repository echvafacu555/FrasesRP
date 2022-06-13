package echevasoft.frasesrp.data.model.network

import com.google.protobuf.Api
import echevasoft.frasesrp.core.RetrofitHelper
import echevasoft.frasesrp.data.model.FraseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class FraseService @Inject constructor(private val api:FraseApiClient) {

    //private  val retrofit=RetrofitHelper.getRetrofit()

    suspend fun getFrases():List<FraseModel> {
        return withContext(Dispatchers.IO) {
            val response=api.getAllFrases()
        response.body() ?: emptyList()

    }
    }
}