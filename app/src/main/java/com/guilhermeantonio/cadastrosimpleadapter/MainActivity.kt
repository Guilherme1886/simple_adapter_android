package com.guilhermeantonio.cadastrosimpleadapter

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private var database: Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buttonGravar(view: View) {

        val arrayList: ArrayList<HashMap<String, String>> = ArrayList()


        val pessoa = Pessoa()
        pessoa.nome = nome.text.toString()
        pessoa.email = email.text.toString()
        pessoa.telefone = telefone.text.toString()
        pessoa.endereco = endereco.text.toString()

        val chave = arrayOf("Nome", "E-mail", "Telefone", "Endereço")
        val valor = arrayOf(pessoa.nome, pessoa.email, pessoa.telefone, pessoa.endereco)

        valor.forEachIndexed { index, editable ->

            val hashMap: HashMap<String, String> = HashMap()
            hashMap.put("chave", chave[index])
            hashMap.put("valor", valor[index])
            arrayList.add(hashMap)
        }

        val from = arrayOf("chave", "valor")
        val to = intArrayOf(R.id.chave, R.id.valor)

        val simpleAdapter = SimpleAdapter(this, arrayList, R.layout.item, from, to)
        simpleListView.adapter = simpleAdapter

        simpleListView.setOnItemClickListener { parent, view, position, id ->

            val chave_selecionada = chave[position]
            val valor_selecionada = valor[position]

            toast("$chave_selecionada: $valor_selecionada")


        }

        hideKeyboard()

    }

    fun hideKeyboard() {
        val keyboard = this.currentFocus

        if (keyboard != null) {

            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            imm.hideSoftInputFromWindow(keyboard.windowToken, 0)


        }
    }
}
