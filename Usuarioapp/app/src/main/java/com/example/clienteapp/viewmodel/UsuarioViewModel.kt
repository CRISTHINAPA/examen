package com.example.usuarioapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usuarioapp.data.model.Usuario
import com.example.usuarioapp.repository.UsuarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {
    val usuarios: LiveData<List<Usuario>> = repository.getAllUsuarios()

    fun getAllUsuariosDirect(): List<Usuario> {
        var usuariosList: List<Usuario> = emptyList()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                usuariosList = repository.getAllUsuariosDirect()
            }
        }
        return usuariosList
    }

    fun insertAll(vararg usuarios: Usuario) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertAll(*usuarios)
            }
        }
    }

}


