package com.example.usuarioapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.usuarioapp.data.model.Usuario
import com.example.usuarioapp.data.model.Movimiento

@Database(entities = [Usuario::class, Movimiento::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun movimientoDao(): MovimientoDao
}
