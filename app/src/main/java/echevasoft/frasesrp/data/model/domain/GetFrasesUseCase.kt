package echevasoft.frasesrp.data.model.domain

import echevasoft.frasesrp.data.model.FraseModel
import echevasoft.frasesrp.data.model.FrasesRepository
import javax.inject.Inject

class GetFrasesUseCase @Inject constructor(private val repository:FrasesRepository) {
            suspend operator fun invoke():List<FraseModel>? = repository.getAllFrases()
}