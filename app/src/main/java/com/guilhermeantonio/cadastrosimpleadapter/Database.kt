package com.guilhermeantonio.cadastrosimpleadapter

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Bimore on 14/09/2017.
 */

class Database(context: Context?) : SQLiteOpenHelper(context, "cadastro", null, 1) {

    private val DATABASE_NAME = "cadastro"
    private val TABLE_NAME = "pessoas"
    private var CREATE_TABLE = "CREATE TABLE $TABLE_NAME (\n" +
            "  id INTEGER PRIMARY KEY,\n" +
            "  nome_chave TEXT NOT NULL,\n" +
            "  nome_valor TEXT NOT NULL,\n" +
            "  email_chave TEXT NOT NULL,\n" +
            "  email_valor TEXT NOT NULL,\n" +
            "  telefone_chave TEXT NOT NULL,\n" +
            "  telefone_valor TEXT NOT NULL,\n" +
            "  endereco_chave TEXT NOT NULL,\n" +
            "  endereco_valor TEXT NOT NULL\n" +
            ");"

    private val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DELETE_TABLE)
        onCreate(db)
    }
}