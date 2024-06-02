package com.example.usuarioapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.usuarioapp.data.model.Usuario

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios")
    fun getAllusuarios(): LiveData<List<Usuario>>

    @Query("SELECT * FROM usuarios")
    suspend fun getAllUsuariosDirect(): List<Usuario>

    @Insert
    suspend fun insertAll(vararg usuarios: Usuario)

}
