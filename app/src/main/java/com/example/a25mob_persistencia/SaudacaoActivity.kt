package com.example.a25mob_persistencia

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        var lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        //Recupera o SharedPrefences e armazena os valores nas variáveis nome e tratamento
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
        val nome = saudacaoPersistencia.getString("nome", "")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        //Verifica se há tratamento atribuido
        //Caso seja "Sem Tratamento", exibe somente o nome
        //Outros casos, exibe tratamento e nome
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        }
        else{
            lbSaudacao.text  = tratamento + " " + nome
        }
    }
}