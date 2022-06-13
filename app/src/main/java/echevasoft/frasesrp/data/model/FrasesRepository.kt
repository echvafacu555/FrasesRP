package echevasoft.frasesrp.data.model

import echevasoft.frasesrp.data.model.network.FraseService
import javax.inject.Inject

class FrasesRepository @Inject constructor(private  val api:FraseService, private val fraseProvider:FraseProvider){

    suspend fun getAllFrases():List<FraseModel>{
        val response: List<FraseModel> =api.getFrases()
        fraseProvider.frases=response
        return response
    }
}