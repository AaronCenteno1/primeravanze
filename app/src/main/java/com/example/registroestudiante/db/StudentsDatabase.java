package com.example.registroestudiante.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public class StudentsDatabase {

    private static DbHelper dbHelper;

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

     //crearemos una funcion que retorne la lista
    public static List<String> callList(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<String> dataLogin = new ArrayList<>();
        //creacion del cursor para llamar datos
        Cursor cursor = db.query(StudentsContract.StudentsEntry.TABLE_NAME,new String[]{
                StudentsContract.StudentsEntry.COLUMN_ID,
                StudentsContract.StudentsEntry.COLUMN_FIRSTNAME,
                StudentsContract.StudentsEntry.COLUMN_LASTNAME,
                StudentsContract.StudentsEntry.COLUMN_AGE,
                StudentsContract.StudentsEntry.COLUMN_MAIL,
                StudentsContract.StudentsEntry.COLUMN_CARRER
        },null,null,null,null,null);
        //recorre la  base de datos
        if(cursor.moveToFirst()){
            do {
                String id = cursor.getString(cursor.getColumnIndexOrThrow(StudentsContract.StudentsEntry.COLUMN_ID));
                String firstname = cursor.getString(cursor.getColumnIndexOrThrow(StudentsContract.StudentsEntry.COLUMN_FIRSTNAME));
                String lastname = cursor.getString(cursor.getColumnIndexOrThrow(StudentsContract.StudentsEntry.COLUMN_LASTNAME));
                String age = cursor.getString(cursor.getColumnIndexOrThrow(StudentsContract.StudentsEntry.COLUMN_AGE));
                String mail = cursor.getString(cursor.getColumnIndexOrThrow(StudentsContract.StudentsEntry.COLUMN_MAIL));
                String carrer = cursor.getString(cursor.getColumnIndexOrThrow(StudentsContract.StudentsEntry.COLUMN_CARRER));

                dataLogin.add(""+id+"\n"+firstname+"\n"+lastname+"\n"+age+"\n"+mail+"\n"+carrer);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return dataLogin;
    }
    //funcion para eliminar datos
    public boolean deleteStudent(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rowsDeleted = db.delete(
                StudentsContract.StudentsEntry.TABLE_NAME,
                StudentsContract.StudentsEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
        db.close();
        return rowsDeleted > 0;
    }

    //funciom para actualizar datos
    public boolean updateStudent(int id, String name, String lastname, int age, String email, String carrer){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentsContract.StudentsEntry.COLUMN_FIRSTNAME, name);
        values.put(StudentsContract.StudentsEntry.COLUMN_LASTNAME, lastname);
        values.put(StudentsContract.StudentsEntry.COLUMN_AGE, age);
        values.put(StudentsContract.StudentsEntry.COLUMN_MAIL, email);
        values.put(StudentsContract.StudentsEntry.COLUMN_CARRER, carrer);

        int rowsUpdated = db.update(
                StudentsContract.StudentsEntry.TABLE_NAME,
                values,
                StudentsContract.StudentsEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
        db.close();
        return rowsUpdated > 0;
    }
}



