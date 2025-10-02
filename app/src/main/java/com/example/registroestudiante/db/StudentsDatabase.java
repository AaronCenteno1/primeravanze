package com.example.registroestudiante.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class StudentsDatabase {

    private DbHelper dbHelper;

    public StudentsDatabase(Context context){
        dbHelper = new DbHelper(context);
    }
    //insertar usuario
     public  long insertStudents(String name,String lastname,int age,String email, String carrer){
         SQLiteDatabase db = dbHelper.getWritableDatabase();
         ContentValues values = new ContentValues();
         values.put(StudentsContract.StudentsEntry.COLUMN_FIRSTNAME,name);
         values.put(StudentsContract.StudentsEntry.COLUMN_LASTNAME,lastname);
         values.put(StudentsContract.StudentsEntry.COLUMN_AGE,age);
         values.put(StudentsContract.StudentsEntry.COLUMN_MAIL,email);
         values.put(StudentsContract.StudentsEntry.COLUMN_CARRER,carrer);

         return db.insert(StudentsContract.StudentsEntry.TABLE_NAME,null, values);

     }
}
