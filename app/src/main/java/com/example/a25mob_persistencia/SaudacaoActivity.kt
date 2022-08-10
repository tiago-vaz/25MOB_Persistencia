package com.example.a25mob_persistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        var lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)


        //Cria uma instância do DatabaseManager para ser utilizada no cursor
        val db = DatabaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        var nome = ""
        var tratamento = ""

        // Verifica se o cursor possui registros, e caso afirmativo, recupera as informações de nome e tratamento
        if (cursor.count > 0 ){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        // Verifica se tratamento = "Sem Tratamento" e,
        // Caso afirmativo, exibe apenas o nome
        // Caso negativo, exibe o tratamento seguido do nome
        if (tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        }
        else{
            lbSaudacao.text = tratamento + " " + nome
        }

    }

}