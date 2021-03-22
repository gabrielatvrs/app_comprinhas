package com.ctt.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.ctt.listadecompras.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var itemCompra: EditText
    private lateinit var qtdCompra: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnLista: Button
    private val listaCompras = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemCompra = findViewById(R.id.txtItem)
        qtdCompra = findViewById(R.id.txtQtd)
        btnAdd = findViewById(R.id.btnAdd)
        btnLista = findViewById(R.id.btnLista)
        spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.unidades_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        btnAdd.setOnClickListener {
            var erro = false
            if (itemCompra.text.isEmpty()) {
                itemCompra.error = "É necessário informar o item"
                erro = true
            }
            if (qtdCompra.text.isEmpty()) {
                qtdCompra.error = "É necessário informar a quantidade"
                erro = true
            }
            if (erro == false) {
                val unidade = spinner.selectedItem.toString()
                listaCompras.add(
                    Item(nome = itemCompra.text.toString(), qtd = qtdCompra.text.toString().toInt(), unidade = unidade)
                )

                itemCompra.setText("")
                qtdCompra.setText("")
                spinner.setSelection(0)
            }
        }
        btnLista.setOnClickListener {
            redirecionar()
        }
    }

    fun redirecionar() {
        val destinoActivity = Intent(this@MainActivity, ListaActivity::class.java)
        destinoActivity.putParcelableArrayListExtra("listaCompras", ArrayList(listaCompras))

        startActivity(destinoActivity)
    }
}
