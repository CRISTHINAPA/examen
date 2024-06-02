package com.example.usuarioapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usuarioapp.data.model.Movimiento
import com.example.usuarioapp.repository.MovimientoRepository
import kotlinx.coroutines.launch

class MovimientoViewModel(private val repository: MovimientoRepository) : ViewModel() {
    fun getMovimientosByUsuarioId(usuarioId: Int): LiveData<List<Movimiento>> {
        return repository.getMovimientosByUsuarioId(usuarioId)
    }

    fun insertAll(vararg movimientos: Movimiento) {
        viewModelScope.launch {
            repository.insertAll(*movimientos)
        }
    }
}
