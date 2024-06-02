package com.example.usuarioapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usuarioapp.data.model.Movimiento
import com.example.usuarioapp.databinding.ItemMovimientoBinding

class MovimientoAdapter :
    RecyclerView.Adapter<MovimientoAdapter.MovimientoViewHolder>() {

    private var movimientos: List<Movimiento> = emptyList()

    fun submitList(list: List<Movimiento>) {
        movimientos = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovimientoViewHolder {
        val binding = ItemMovimientoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovimientoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovimientoViewHolder, position: Int) {
        holder.bind(movimientos[position])
    }

    override fun getItemCount(): Int = movimientos.size

    class MovimientoViewHolder(private val binding: ItemMovimientoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movimiento: Movimiento) {
            binding.descripcionTextView.text = movimiento.descripcion
            binding.montoTextView.text = movimiento.monto.toString()
        }
    }
}
