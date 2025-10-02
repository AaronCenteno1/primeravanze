package com.example.registroestudiante.db;

public class StudentsContract {

    private StudentsContract(){

    }
    public static class StudentsEntry{

        //asigne el nombre  de la tabla name
        public static  final String TABLE_NAME ="students";

        //asigne el nombre  id al atributo column_id
        public static  final String COLUMN_ID ="idStudents";

        //asigne el  firstname al atributo column_firstname
        public static  final String COLUMN_FIRSTNAME ="firstname";

        //asigne el  lastname al atributo column_lastname
        public static  final String COLUMN_LASTNAME ="lastname";
        //asigne  el age el atributo column_age
        public static  final String COLUMN_AGE ="age";
        //asigne el mail atributo column_mail
        public static  final String COLUMN_MAIL ="email";
        //asigne el carrer atributo column_carrer
        public static  final String COLUMN_CARRER ="carrer";
    }
}
