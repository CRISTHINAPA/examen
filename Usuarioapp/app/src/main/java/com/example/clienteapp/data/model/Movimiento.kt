package com.example.usuarioapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movimientos")
data class Movimiento(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val usuarioId: Int,
    val descripcion: String,
    val monto: Double
)
