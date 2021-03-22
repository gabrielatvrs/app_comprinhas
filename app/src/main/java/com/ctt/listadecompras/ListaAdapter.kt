package com.ctt.listadecompras

import android.app.AlertDialog
import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listadecompras.model.Item

class ListaAdapter(
    private val listaCompras: MutableList<Item>
) : RecyclerView.Adapter<ListaAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemCompra: TextView = view.findViewById(R.id.txtItem)
        val qtdCompra: TextView = view.findViewById(R.id.txtQtd)
        val unidade: TextView = view.findViewById(R.id.txtUni)
        val excluirItem: ImageView = view.findViewById(R.id.btnExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemCompra.text = listaCompras[position].nome
        holder.qtdCompra.text = listaCompras[position].qtd.toString()
        holder.unidade.text = listaCompras[position].unidade
        holder.excluirItem.setOnClickListener {

            AlertDialog.Builder(it.context)
                .setTitle("Excluir item")
                .setMessage("Deseja excluir o item selecionado?")
                .setPositiveButton("Sim") { dialog, which ->
                    listaCompras.removeAt(position)
                    notifyDataSetChanged()
                }
                .setNegativeButton("Não") { dialog, which -> }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return listaCompras.size
    }
}
