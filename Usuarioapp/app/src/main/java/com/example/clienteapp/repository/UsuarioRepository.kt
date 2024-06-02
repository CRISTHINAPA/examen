package com.example.usuarioapp.repository

import androidx.lifecycle.LiveData
import com.example.usuarioapp.data.database.UsuarioDao
import com.example.usuarioapp.data.model.Usuario

class UsuarioRepository(private val usuarioDao: UsuarioDao) {
    fun getAllUsuarios(): LiveData<List<Usuario>> = usuarioDao.getAllUsuarios()
    suspend fun getAllUsuariosDirect(): List<Usuario> = usuarioDao.getAllUsuariosDirect()
    suspend fun insertAll(vararg usuarios: Usuario) = usuarioDao.insertAll(*usuarios)
}
