package com.example.a25mob_persistencia

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Criação do DatabaseManager que é utilizado na MainActivity para armazenar e ler dados no SQLITE
class DatabaseManager (context: Context, name: String?) : SQLiteOpenHelper(context, name, null, 1) {
    //Criação da tabela a ser utilizada, ao instalar o app
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL PRIMARY KEY,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20)\n" +
                "\t);")
    }

    //Criação da tabela a ser utilizada, ao atualizar o app
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL PRIMARY KEY,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20),\n" +
                "\t);")
    }

    //Cria uma saudação na tabela, com base no id, nome e tratamento fornecidos
    fun insereSaudacao(id: Int, nome: String, tratamento: String){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put("ID_SAUDACAO",id)
        cv.put("NOME", nome)
        cv.put("TRATAMENTO", tratamento)
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    //Retorna todos os registros da tabela
    fun listaSaudacao(): Cursor {
        var db = this.readableDatabase
        var cur = db.rawQuery("select nome, tratamento from saudacao", null)
        return cur
    }

    //Remove o registro da tabela que possui id = 1
    fun removeSaudacao(){
        var db = this.writableDatabase
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }

}