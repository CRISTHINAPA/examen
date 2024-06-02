package com.example.usuarioapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.usuarioapp.data.model.Movimiento

@Dao
interface MovimientoDao {
    @Query("SELECT * FROM movimientos WHERE usuarioId = :usuarioId")
    fun getMovimientosByUsuarioId(usuarioId: Int): LiveData<List<Movimiento>>

    @Insert
    suspend fun insertAll(vararg movimientos: Movimiento)
}
