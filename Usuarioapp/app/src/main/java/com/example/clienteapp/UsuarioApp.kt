package com.example.usuarioapp

import android.app.Application
import androidx.room.Room
import com.example.usuarioapp.data.database.AppDatabase
import com.example.usuarioapp.repository.UsuarioRepository
import com.example.usuarioapp.repository.MovimientoRepository

class UsuarioApp : Application() {

    lateinit var database: AppDatabase
    lateinit var usuarioRepository: UsuarioRepository
    lateinit var movimientoRepository: MovimientoRepository

    override fun onCreate() {
        super.onCreate()

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "usuarioapp-database"
        ).build()

        // Initialize the repositories
        usuarioRepository = UsuarioRepository(database.usuarioDao())
        movimientoRepository = MovimientoRepository(database.movimientoDao())
    }
}
