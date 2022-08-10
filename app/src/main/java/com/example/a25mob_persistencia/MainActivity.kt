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

        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var btnSaudacao = findViewById<Button>(R.id.btnSaudacao)
        var txtNome = findViewById<TextView>(R.id.txtNome)
        var listTratamento = findViewById<Spinner>(R.id.listTratamento)

        btnSalvar.setOnClickListener{
            val data = txtNome.text.toString() + ":" + listTratamento.selectedItem.toString()
            gravaDadoArquivo("saudacao",data)

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        }

        btnSaudacao.setOnClickListener{
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        }

    }

    private fun gravaDadoArquivo(filename: String, data: String) {
        try{
            val fs = openFileOutput(filename, Context.MODE_PRIVATE)
            fs.write(data.toByteArray())
            fs.close()
        }
        catch (e: FileNotFoundException){
            Log.i("gravaDadoArquivo", "FileNotFoundException")}
        catch (e: IOException){Log.i("gravaDadoArquivo", "IOException")}

    }
}