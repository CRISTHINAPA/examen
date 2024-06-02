package com.example.usuarioapp.repository

import androidx.lifecycle.LiveData
import com.example.usuarioapp.data.database.MovimientoDao
import com.example.usuarioapp.data.model.Movimiento


class MovimientoRepository(private val movimientoDao: MovimientoDao) {
    fun getMovimientosByUsuarioId(usuarioId: Int): LiveData<List<Movimiento>> {
        return movimientoDao.getMovimientosByUsuarioId(usuarioId)
    }

    suspend fun insertAll(vararg movimientos: Movimiento) {
        movimientoDao.insertAll(*movimientos)
    }
}
