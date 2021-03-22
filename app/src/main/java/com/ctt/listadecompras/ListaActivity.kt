package com.ctt.listadecompras

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listadecompras.model.Item
import kotlinx.android.synthetic.main.item_lista.*

class ListaActivity : AppCompatActivity() {

    private lateinit var rvListaCompras: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista)

        rvListaCompras = findViewById(R.id.rvListaCompras)

        val listaCompras = intent.extras?.get("listaCompras") as MutableList<Item>
        val adapterItem = ListaAdapter(listaCompras)

        rvListaCompras.adapter = adapterItem
        rvListaCompras.layoutManager = LinearLayoutManager(this)

    }
}
