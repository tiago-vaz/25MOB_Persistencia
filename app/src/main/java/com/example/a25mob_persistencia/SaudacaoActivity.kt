package com.example.a25mob_persistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        var lbSaudacao = findViewById<TextView>(R.id.lbSaudacao)

        val data = recuperaDadoArquivo("saudacao")
        val tokenizer = StringTokenizer(data,":")
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Tratamento"

        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        }
        else{
            lbSaudacao.text  = tratamento + " " + nome
        }
    }

    private fun recuperaDadoArquivo(filename: String): String {
        try {
            val fi = openFileInput(filename)
            val data = fi.readBytes()
            fi.close()
            data.toString()
            return data.toString(Charset.defaultCharset())
        }
        catch (e: FileNotFoundException){
            return ""
        }
        catch (e: IOException){
            return ""
        }
    }
}