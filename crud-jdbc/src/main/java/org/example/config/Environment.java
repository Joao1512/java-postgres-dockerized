package org.example.config;

public class Environment {
    public static final String DB_DESENV_ADRESS = "jdbc:postgresql://database-1.c1miooie4kuv.us-east-2.rds.amazonaws.com:5432/";
    public static final String DB_PROD_ADRESS = "jdbc:postgresql://database-1.c1miooie4kuv.us-east-2.rds.amazonaws.com:5432/";

    public static boolean desenv = true;

    public static boolean isDesenv() {
        return desenv;
    }
}