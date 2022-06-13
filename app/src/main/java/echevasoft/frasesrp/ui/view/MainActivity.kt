package echevasoft.frasesrp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import dagger.hilt.android.AndroidEntryPoint
import echevasoft.frasesrp.databinding.ActivityMainBinding
import echevasoft.frasesrp.ui.viewModel.FraseViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fraseViewModel: FraseViewModel by viewModels()
    val fireStoreDatabase = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fraseViewModel.onCreate()
        fraseViewModel.fraseModel.observe(this, Observer { currentFrase->
            binding.frase.text=currentFrase.frase
            binding.autor.text=currentFrase.autor

        })

        fraseViewModel.loading.observe(this, Observer{
            binding.progress.isVisible=it
        })

        binding.viewContainer.setOnClickListener {
            fraseViewModel.randomFrase()
        }
    }


}
