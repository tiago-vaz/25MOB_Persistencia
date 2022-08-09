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

        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var btnSaudacao = findViewById<Button>(R.id.btnSaudacao)
        var txtNome = findViewById<TextView>(R.id.txtNome)
        var listTratamento = findViewById<Spinner>(R.id.listTratamento)

        btnSalvar.setOnClickListener{
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())
            editor.apply()

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        btnSaudacao.setOnClickListener{
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }




    }
}