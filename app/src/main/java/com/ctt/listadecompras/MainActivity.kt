package com.ctt.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ctt.listadecompras.model.Item

class MainActivity : AppCompatActivity() {

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

        btnAdd.setOnClickListener {
            listaCompras.add(
                Item(nome = itemCompra.text.toString(), qtd = qtdCompra.text.toString().toInt())
            )

            itemCompra.setText("")
            qtdCompra.setText("")
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
