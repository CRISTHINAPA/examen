package com.example.usuarioapp.ui.movimientos

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usuarioapp.UsuarioApp
import com.example.usuarioapp.ui.adapter.MovimientoAdapter
import com.example.usuarioapp.viewmodel.MovimientoViewModel
import com.example.usuarioapp.viewmodel.MovimientoViewModelFactory
import com.example.usuarioapp.databinding.ActivityMovimientosBinding

class MovimientosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovimientosBinding
    private val movimientoViewModel: MovimientoViewModel by viewModels {
        MovimientoViewModelFactory((application as UsuarioApp).movimientoRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovimientosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioId = intent.getIntExtra("USUARIO_ID", 0)
        val adapter = MovimientoAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observa los cambios en los movimientos del usuario
        movimientoViewModel.getMovimientosByUsuarioId(usuarioId).observe(this) { movimientos ->
            adapter.submitList(movimientos)
        }
    }
}
