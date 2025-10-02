package com.example.registroestudiante.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Siempre agregar extension SQLiteOpenHelper
public class DbHelper extends SQLiteOpenHelper {

    // ASIGNO LA VERSION ALA BASE DE DATOS
    public static final int DATABASE_VERSION = 1;
    // LE ASIGNO EL NOMBRE A MI BASE DE DATOS
    public static  final String DATABASE_NAME ="students.db";

    //LA asignando mi varlo ala variable le asigno el codigo de  creacion de mi tabla

    private static final String SQL_CREATE_ENTRIES=
            "CREATE TABLE " + StudentsContract.StudentsEntry.TABLE_NAME + " (" +
                    StudentsContract.StudentsEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    StudentsContract.StudentsEntry.COLUMN_FIRSTNAME + " VARCHAR(32)," +
                    StudentsContract.StudentsEntry.COLUMN_LASTNAME + " VARCHAR(32)," +
                    StudentsContract.StudentsEntry.COLUMN_AGE + " INTEGER," +
                    StudentsContract.StudentsEntry.COLUMN_MAIL + " TEXT," +
                    StudentsContract.StudentsEntry.COLUMN_CARRER + " VARCHAR(32));";


    public  DbHelper(Context context){
        super(context,DATABASE_NAME , null, DATABASE_VERSION);
    }

    //creacion de la tabla
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }
   //borrar tablas si actualizo DATABASE_VERSION y crearlas de forma automatica
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + StudentsContract.StudentsEntry.TABLE_NAME);
        onCreate(db);
    }

}
