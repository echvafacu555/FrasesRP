package echevasoft.frasesrp.data.model

import com.google.gson.annotations.SerializedName

data class FraseModel (@SerializedName ("frase")val frase: String, @SerializedName ("autor")val autor: String)