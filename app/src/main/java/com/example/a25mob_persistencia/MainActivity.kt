package com.example.a25mob_persistencia

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciando objetos da activity para utilização mais adiante
        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var btnSaudacao = findViewById<Button>(R.id.btnSaudacao)
        var txtNome = findViewById<TextView>(R.id.txtNome)
        var listTratamento = findViewById<Spinner>(R.id.listTratamento)

        btnSalvar.setOnClickListener{
            //Cria o SharedPreferences e atribui um editor
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            //Utilizando o editor, cria atributos nome e tratamento de acordo com os valores fornecidos pelo usuário
            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())
            editor.apply()

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