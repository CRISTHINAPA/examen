package com.example.usuarioapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.usuarioapp.R
import com.example.usuarioapp.data.model.Usuario
import com.example.usuarioapp.databinding.ActivityUsuarioDetailBinding

class UsuarioDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsuarioDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getParcelableExtra<Usuario>("USUARIO")

        usuario?.let {
            binding.tvNombre.text = it.nombre
            binding.tvTelefono.text = it.telefono
            // Si tienes una imagenUri, puedes cargarla aquí
        }

        binding.btnRegresar.setOnClickListener {
            finish()  // Termina la actividad y regresa a la anterior
        }
    }
}
