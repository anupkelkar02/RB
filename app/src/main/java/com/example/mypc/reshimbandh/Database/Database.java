package  com.example.mypc.reshimbandh.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mypc.reshimbandh.Modal.DropDownData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Swapnil.N on 11/1/2016.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "reshimband";
    private static final int DATABASE_VERSION = 4;

    //tables
    private static final String TABLE_LOGIN = "user";
    private static final String TABLE_HEIGHT_MASTER = "height_master";
    private static final String TABLE_CITY_MASTER = "city_master";
    private static final String TABLE_ABOVE_APP_MASTER = "above_app_master";
    private static final String TABLE_RELIGION_MASTER = "religion_master";
    private static final String TABLE_M_TONGUE_MASTER = "mother_tongue_master";
    private static final String TABLE_CASTE_MASTER = "caste_master";
    private static final String TABLE_SUB_CASTE_MASTER = "sub_caste_master";
    private static final String TABLE_MARITAL_STATUS_MASTER = "marital_status_master";
    private static final String TABLE_OCCUPATION_MASTER = "occupation_master";
    private static final String TABLE_QUALIFICATION_MASTER = "qualification_master";

    //tables fields
    private static final String TABLE_LOGIN_ID = "id";
    private static final String TABLE_LOGIN_USERNAME = "username";
    private static final String TABLE_LOGIN_EMAIL = "email";
    private static final String TABLE_LOGIN_NAME = "name";
    private static final String TABLE_LOGIN_AGE = "age";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create user table
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_USERNAME + " TEXT UNIQUE,"
                + TABLE_LOGIN_EMAIL + " TEXT,"
                + TABLE_LOGIN_NAME + " TEXT,"
                + TABLE_LOGIN_AGE + " TEXT"
                + ")";

        String CREATE_HEIGHT_MASTER = "CREATE TABLE " + TABLE_HEIGHT_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_CITY_MASTER = "CREATE TABLE " + TABLE_CITY_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_ABOVE_APP_MASTER = "CREATE TABLE " + TABLE_ABOVE_APP_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_RELIGION_MASTER = "CREATE TABLE " + TABLE_RELIGION_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_M_TONGUE_MASTER = "CREATE TABLE " + TABLE_M_TONGUE_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_CASTE_MASTER = "CREATE TABLE " + TABLE_CASTE_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_SUB_CASTE_MASTER = "CREATE TABLE " + TABLE_SUB_CASTE_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_MARITAL_MASTER = "CREATE TABLE " + TABLE_MARITAL_STATUS_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_OCCUPATION_MASTER = "CREATE TABLE " + TABLE_OCCUPATION_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";
        String CREATE_QUALIFICATION_MASTER = "CREATE TABLE " + TABLE_QUALIFICATION_MASTER + "("
                + TABLE_LOGIN_ID + " INTEGER PRIMARY KEY,"
                + TABLE_LOGIN_EMAIL + " TEXT"
                + ")";

        db.execSQL(CREATE_LOGIN_TABLE);
        db.execSQL(CREATE_HEIGHT_MASTER);
        db.execSQL(CREATE_CITY_MASTER);
        db.execSQL(CREATE_ABOVE_APP_MASTER);
        db.execSQL(CREATE_RELIGION_MASTER);
        db.execSQL(CREATE_M_TONGUE_MASTER);
        db.execSQL(CREATE_CASTE_MASTER);
        db.execSQL(CREATE_SUB_CASTE_MASTER);
        db.execSQL(CREATE_MARITAL_MASTER);
        db.execSQL(CREATE_OCCUPATION_MASTER);
        db.execSQL(CREATE_QUALIFICATION_MASTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HEIGHT_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ABOVE_APP_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RELIGION_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_M_TONGUE_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASTE_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUB_CASTE_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARITAL_STATUS_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OCCUPATION_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUALIFICATION_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITY_MASTER);
        // Create tables again
        onCreate(db);
    }


    public void saveLogin(String name,  String usrname, String email, String  age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_LOGIN_NAME, name);
        values.put(TABLE_LOGIN_EMAIL, email);
        values.put(TABLE_LOGIN_USERNAME, usrname);
        values.put(TABLE_LOGIN_AGE, age);
        db.insert(TABLE_LOGIN, null, values);
        db.close();
    }

    public void logout(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LOGIN);
        db.close();
    }

    public boolean checkLogin() {
        boolean flag = false;
        String selectQuery = "SELECT * FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            flag = true;
        }
        return flag;
    }

    public HashMap getCurrentUser(){
        HashMap user = new HashMap();
        String selectQuery = "SELECT * FROM " + TABLE_LOGIN +" LIMIt 1";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            user.put(TABLE_LOGIN_ID, cursor.getString(0));
            user.put(TABLE_LOGIN_NAME, cursor.getString(1));
            user.put(TABLE_LOGIN_EMAIL, cursor.getString(2));
            user.put(TABLE_LOGIN_USERNAME, cursor.getString(3));
            user.put(TABLE_LOGIN_AGE, cursor.getString(4));
        }
        return user;
    }

    public void saveMaster(String id,String name,int action){
        String TABLE_NAME = "";
        switch (action){
            case 1:
                TABLE_NAME = TABLE_HEIGHT_MASTER;
                break;
            case 2:
                TABLE_NAME = TABLE_ABOVE_APP_MASTER;
                break;
            case 3:
                TABLE_NAME = TABLE_RELIGION_MASTER;
                break;
            case 4:
                TABLE_NAME = TABLE_M_TONGUE_MASTER;
                break;
            case 5:
                TABLE_NAME = TABLE_CASTE_MASTER;
                break;
            case 6:
                TABLE_NAME = TABLE_SUB_CASTE_MASTER;
                break;
            case 7:
                TABLE_NAME = TABLE_MARITAL_STATUS_MASTER;
                break;
            case 8:
                TABLE_NAME = TABLE_OCCUPATION_MASTER;
                break;
            case 9:
                TABLE_NAME = TABLE_QUALIFICATION_MASTER;
                break;
            case 10:
                TABLE_NAME = TABLE_CITY_MASTER;
                break;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE_LOGIN_ID, id);
        values.put(TABLE_LOGIN_NAME, name);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<String> getMaster(int action){
        List<String > list = new ArrayList<>();
        String TABLE_NAME = "";
        switch (action){
            case 1:
                TABLE_NAME = TABLE_HEIGHT_MASTER;
                break;
            case 2:
                TABLE_NAME = TABLE_ABOVE_APP_MASTER;
                break;
            case 3:
                TABLE_NAME = TABLE_RELIGION_MASTER;
                break;
            case 4:
                TABLE_NAME = TABLE_M_TONGUE_MASTER;
                break;
            case 5:
                TABLE_NAME = TABLE_CASTE_MASTER;
                break;
            case 6:
                TABLE_NAME = TABLE_SUB_CASTE_MASTER;
                break;
            case 7:
                TABLE_NAME = TABLE_MARITAL_STATUS_MASTER;
                break;
            case 8:
                TABLE_NAME = TABLE_OCCUPATION_MASTER;
                break;
            case 9:
                TABLE_NAME = TABLE_QUALIFICATION_MASTER;
                break;
            case 10:
                TABLE_NAME = TABLE_CITY_MASTER;
                break;
        }

        SQLiteDatabase db = this.getReadableDatabase();
        String searchQuery = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(searchQuery,null);
        int index =0;
        if (cursor != null ) {
            if  (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex(TABLE_LOGIN_ID));
                    String name = cursor.getString(cursor.getColumnIndex(TABLE_LOGIN_NAME));
                    list.add(index,name);index++;
                }while (cursor.moveToNext());
            }
        }
        return list;
    }

//    public HashMap login(String username, String password) {
//        HashMap user = new HashMap();
//        String selectQuery = "SELECT * FROM " + TABLE_LOGIN +
//                " WHERE " + TABLE_LOGIN_USERNAME + "='" +username + "' AND "
//                + TABLE_LOGIN_PASSWORD +"='"+password+"'";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        // Move to first row
//        cursor.moveToFirst();
//        if(cursor.getCount() > 0){
//            user.put(TABLE_LOGIN_ID, cursor.getString(0));
//            user.put(TABLE_LOGIN_FIRSTNAME, cursor.getString(1));
//            user.put(TABLE_LOGIN_LASTNAME, cursor.getString(2));
//            user.put(TABLE_LOGIN_USERNAME, cursor.getString(3));
//            user.put(TABLE_LOGIN_PASSWORD, cursor.getString(4));
//            user.put(TABLE_LOGIN_MOBILE, cursor.getString(5));
//        }
//        cursor.close();
//        db.close();
//        return user;
//    }

//    public void offerRide(String fromdest,String todest,String datetime,String amount){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(TABLE_RIDE_FROM, fromdest);
//        values.put(TABLE_RIDE_TO, todest);
//        values.put(TABLE_RIDE_DATE, datetime);
//        values.put(TABLE_RIDE_AMOUNT, amount);
//        db.insert(TABLE_RIDE, null, values);
//        db.close();
//    }

//    public ArrayList<DataObject> searchRide(){
//        ArrayList<DataObject> data = new ArrayList();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String searchQuery = "SELECT * FROM "+TABLE_RIDE;
//        Cursor cursor = db.rawQuery(searchQuery,null);
//        int index =0;
//        if (cursor != null ) {
//            if  (cursor.moveToFirst()) {
//                do {
//                  //  data.add(Integer.parseInt(TABLE_LOGIN_ID),cursor.getString(0));
//                   // data.add(TABLE_RIDE_FROM,cursor.getString(1).toString());
//
//                    String id = cursor.getString(cursor.getColumnIndex(TABLE_LOGIN_ID));
//                    String fromd = cursor.getString(cursor.getColumnIndex(TABLE_RIDE_FROM));
//                    String tod = cursor.getString(cursor.getColumnIndex(TABLE_RIDE_TO));
//                    String amount = cursor.getString(cursor.getColumnIndex(TABLE_RIDE_AMOUNT));
//                    String date = cursor.getString(cursor.getColumnIndex(TABLE_RIDE_DATE));
//                    DataObject obj = new DataObject(fromd,tod,amount,date,id);
//                    data.add(index, obj);index++;
//                }while (cursor.moveToNext());
//            }
//        }
//        return  data;
//    }

}
