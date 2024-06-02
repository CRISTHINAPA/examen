package com.example.usuarioapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usuarioapp.R
import com.example.usuarioapp.data.model.Usuario

class UsuarioAdapter(private val onItemClick: (Usuario) -> Unit) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    private var usuarios = emptyList<Usuario>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario)
        holder.itemView.setOnClickListener {
            onItemClick(usuario)
        }
    }

    override fun getItemCount() = usuarios.size

    fun submitList(usuarios: List<usuario>) {
        this.usuarios = usuarios
        notifyDataSetChanged()
    }

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)

        fun bind(usuario: Usuario) {
            tvNombre.text = usuario.nombre
        }
    }
}
