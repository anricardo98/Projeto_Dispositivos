package com.example.recyclerviewt12

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    var titulo : String? = null
    var texto : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val i = intent
        titulo = i.getStringExtra("titulo")
        texto = i.getStringExtra("Texto")

        conteudo.setText(texto)
    }


    fun gravar(view: View){
        val conteudo = conteudo.text
        val title = "aaaaaa"

        i.putExtra("Titulo", title)
        i.putExtra("Conteudo", conteudo)
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    fun cancelar(view: View){
        val title = "aaaaaa"
        intent.putExtra("Titulo", title)
        intent.putExtra("Conteudo", texto)
        setResult(Activity.RESULT_OK, intent)

        finish()
    }

}
