package echevasoft.frasesrp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import echevasoft.frasesrp.data.model.FraseModel
import echevasoft.frasesrp.data.model.FraseProvider
import echevasoft.frasesrp.data.model.domain.GetFrasesUseCase
import echevasoft.frasesrp.data.model.domain.GetRandomFraseUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FraseViewModel @Inject constructor(
   private val getFrasesUseCase:GetFrasesUseCase,
   private val getRandomFraseUseCase:GetRandomFraseUseCase,
):ViewModel() {

    val fraseModel=MutableLiveData<FraseModel>()
   // var getFrasesUseCase=GetFrasesUseCase()
   // var getRandomFraseUseCase=GetRandomFraseUseCase()
    val loading =MutableLiveData<Boolean>()

    fun onCreate() {
            viewModelScope.launch {
                loading.postValue(true)
                val result:List<FraseModel>? = getFrasesUseCase()
                if (!result.isNullOrEmpty()){
                        fraseModel.postValue(result[0])
                    loading.postValue(false)
                }
            }
    }

    fun randomFrase(){
        loading.postValue(true)
        val frase:FraseModel? = getRandomFraseUseCase()
       if (frase!=null){
            fraseModel.postValue(frase)
        }
        loading.postValue(false)
  //      val currentFrase:FraseModel=FraseProvider.random()
   //     fraseModel.postValue(currentFrase)
    }


}