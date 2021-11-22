package co.edu.eam.mytestapp.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.edu.eam.mytestapp.R
import co.edu.eam.mytestapp.databinding.ActivityContraseniaRecuperarBinding
import com.google.firebase.auth.FirebaseAuth

class ContraseniaRecuperar : AppCompatActivity() {
    lateinit var binding: ActivityContraseniaRecuperarBinding
    private lateinit var mAuth:FirebaseAuth

    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContraseniaRecuperarBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mAuth = FirebaseAuth.getInstance()
        binding.btnEnviar.setOnClickListener{
            val email = binding.emailUser.text.toString()
            if (email.isNotEmpty()) {
                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(baseContext, "Email Enviado", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
            }
        }
    }


}