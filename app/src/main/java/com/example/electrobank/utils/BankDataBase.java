package com.example.electrobank.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.electrobank.model.User;
import com.example.electrobank.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class BankDataBase {
    public static final String ELECTRO_BANK_DB = "ed";
    private final String ELECTRO_BANK_DATABASE_TABLE = "electroBank";

    private final String id = "id";
    private final String first_name = "first_name";
    private final String last_Name = "last_name";
    private final String email = "email";
    private final String password = "password";

    private final SQLiteDatabase mLiteDatabase;


    public BankDataBase(SQLiteDatabase liteDatabase) {
        mLiteDatabase = liteDatabase;
    }
    private void createBankRecordData() {
        String query = "CREATE TABLE IF NOT EXISTS " + ELECTRO_BANK_DATABASE_TABLE + "(" +
                id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                 first_name + " VARCHAR(100) NOT NULL," +
                last_Name + " VARCHAR(5) NOT NULL," +
                email+ " VRCHAR(100) NOT NULL," +
                password + " VARCHAR(5) NOT NULL "+ ")";
        mLiteDatabase.execSQL(query);
    }
    public void saveBankData(User user){
        String query = "INSERT INTO " + ELECTRO_BANK_DATABASE_TABLE + "("
                + first_name + "," + last_Name + "," + email + "," + password + ")" +
                "VALUES ('"+user.firstName+"' , '"+user.lastName+"' , '"+
                user.email+"', '"+user.password+"')";
        mLiteDatabase.execSQL(query);
    }
    public UserDetails getUserDetails(String id) {
        Cursor cursor = mLiteDatabase.rawQuery("SELECT * FROM " + ELECTRO_BANK_DATABASE_TABLE + " WHERE id='"+id+"'", null);
        cursor.moveToFirst();
        UserDetails userDetails = new UserDetails(cursor.getString(1), cursor.getString(2),cursor.getString(3)
                ,cursor.getString(4));
        userDetails.setId(cursor.getString(0));
        return userDetails;
    }



    public List<UserDetails> getBankUserData(String email, String password) {
        Cursor cursor = mLiteDatabase.rawQuery("SELECT * FROM " + ELECTRO_BANK_DATABASE_TABLE+ " WHERE email='"+email+"' " + " WHERE password = '"+password+"'" , null);
        List<UserDetails> userDetails = new ArrayList<>();
        while (cursor.moveToNext()){
            UserDetails userDetail = new UserDetails(cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4));
            userDetail.setId(cursor.getString(0));
        }
        return userDetails;
    }

    public void deleteData(UserDetails userDetails) {
        String query = "DELETE FROM " + ELECTRO_BANK_DATABASE_TABLE + " WHERE id='"+userDetails.getId()+"'";
        mLiteDatabase.execSQL(query);
    }
    public void updateData(UserDetails userDetails) {
        String query = "UPDATE " + ELECTRO_BANK_DATABASE_TABLE + " SET " +
                first_name + "='" + userDetails.firstName  + "', " +
                last_Name + "='" + userDetails.lastName  + "', " +
                email + "='" + userDetails.email  + "', " +
                password + "='" + userDetails.password  + "' " +
                "WHERE " + id + "='"+userDetails.getId()+"'";
        Log.d("UpdateQuery", "updateData: "+ query);
        mLiteDatabase.execSQL(query);
    }
    public static BankDataBase buildWith(SQLiteDatabase historyDatabase) {
        BankDataBase dataBase = new BankDataBase(historyDatabase);
        dataBase.createBankRecordData();
        return dataBase;
    }
}