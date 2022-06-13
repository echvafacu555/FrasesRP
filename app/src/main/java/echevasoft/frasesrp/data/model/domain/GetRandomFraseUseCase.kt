package echevasoft.frasesrp.data.model.domain

import echevasoft.frasesrp.data.model.FraseModel
import echevasoft.frasesrp.data.model.FraseProvider
import echevasoft.frasesrp.data.model.FrasesRepository
import javax.inject.Inject

class GetRandomFraseUseCase @Inject constructor(private val fraseProvider:FraseProvider) {
    operator fun invoke():FraseModel?{
        val frases: List<FraseModel> = fraseProvider.frases
        if (!frases.isNullOrEmpty()) {
            val randomNumber:Int  =(frases.indices).random()
            return frases[randomNumber]
        }
        return null
    }
}