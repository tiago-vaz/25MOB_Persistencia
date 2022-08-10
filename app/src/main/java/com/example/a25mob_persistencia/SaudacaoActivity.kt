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

        //Realiza chamada à função recuperaDadoArquivo, que faz a leitura no arquivo
        val data = recuperaDadoArquivo("saudacao")

        //Faz a separação dos dados do arquivo recuperado que estão delimitados por :
        val tokenizer = StringTokenizer(data,":")

        // Recupera o valor do primeiro elemento e atribui na variável nome. Caso esteja vazio, seta como "Sem Nome"
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Nome"
        // Recupera o valor do primeiro elemento e atribui na variável tratamento. Caso esteja vazio, seta como "Sem Tratamento"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Tratamento"

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

    //Função utilitária para recuperar os dados em arquivo
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