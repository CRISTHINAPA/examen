package com.example.usuarioapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usuarioapp.UsuarioApp
import com.example.usuarioapp.ui.adapter.UsuarioAdapter
import com.example.usuarioapp.ui.detail.UsuarioDetailActivity
import com.example.usuarioapp.viewmodel.UsuarioViewModel
import com.example.usuarioapp.viewmodel.UsuarioViewModelFactory
import com.example.usuarioapp.databinding.ActivityMainBinding
import com.example.usuarioapp.data.model.Usuario
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usuarioViewModel: UsuarioViewModel by viewModels {
        UsuarioViewModelFactory((application as UsuarioApp).usuarioRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UsuarioAdapter { usuario ->
            Log.d("MainActivity", "Usuario seleccionado: $usuario")
            val intent = Intent(this, UsuarioDetailActivity::class.java)
            intent.putExtra("USUARIO", usuario)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        usuarioViewModel.usuarios.observe(this, Observer { usuarios ->
            adapter.submitList(usuarios)
            if (usuarios.isEmpty()) {
                insertInitialData()
            }
        })
    }

    private fun insertInitialData() {
        try {
            val usuarios = listOf(
                Usuario(id = 1, nombre = "Cristhina Parrales", telefono = "0933333333", imagenUri = ""),
                Usuario(id = 2, nombre = "Yanfricito el mejor", telefono = "0933333333", imagenUri = ""),
                Usuario(id = 3, nombre = "Michelada", telefono = "0933333333", imagenUri = "")
            )
            usuarioViewModel.insertAll(*usuarios.toTypedArray())
            Log.d("MainActivity", "Datos iniciales insertados correctamente")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error al insertar datos iniciales", e)
        }
    }
}
