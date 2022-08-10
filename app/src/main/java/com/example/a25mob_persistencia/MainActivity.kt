package com.example.a25mob_persistencia

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciando objetos da activity para utilização mais adiante
        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var btnSaudacao = findViewById<Button>(R.id.btnSaudacao)
        var txtNome = findViewById<TextView>(R.id.txtNome)
        var listTratamento = findViewById<Spinner>(R.id.listTratamento)


        //Instanciando o DatabaseManager
        val db = DatabaseManager(this, "saudacoes")

        btnSalvar.setOnClickListener{

            //Limpa saudação anterior antes de criar uma nova no banco de dados
            db.removeSaudacao()
            //Cria uma nova saudação no banco de dados com base no nome e tratamento fornecidos pelo usuário
            db.insereSaudacao(1,txtNome.text.toString(), listTratamento.selectedItem.toString())

            //Exibe um Toast informando que a saudação foi salva com sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        btnSaudacao.setOnClickListener{
            // Realiza a chamada para a tela que exibe a saudação
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }

    }

}