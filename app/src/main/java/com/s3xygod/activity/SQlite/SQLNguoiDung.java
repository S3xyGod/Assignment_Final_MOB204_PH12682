package com.s3xygod.activity.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.s3xygod.activity.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class SQLNguoiDung extends SQLiteOpenHelper {
    SQLNguoiDung sqlNguoiDung;
    public SQLNguoiDung(@Nullable Context context) {
        super(context, "SQLiteUser.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_NguoiDung = "Create table NguoiDung(ID text primary key , Name Nvarchar(50), Phone varchar(50), Gmail text, STK text)";
        db.execSQL(create_NguoiDung);
    }
    public void addNguoiDung(NguoiDung nguoiDung){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",nguoiDung.getId());
        contentValues.put("Name",nguoiDung.getTen());
        contentValues.put("Phone",nguoiDung.getSdt());
        contentValues.put("Gmail",nguoiDung.getGmail());
        contentValues.put("STK", nguoiDung.getSTK());
        db.insert("NguoiDung",null,contentValues);
    }

    public NguoiDung timKiem(String id){
        String get_all = "SELECT * FROM NguoiDung";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String idMem,name,phone,gmail, stk;
            idMem = cursor.getString(0);
            name = cursor.getString(1);
            phone = cursor.getString(2);
            gmail = cursor.getString(3);
            stk = cursor.getString(4);
            if (id.equals(idMem)){
                NguoiDung nguoiDung = new NguoiDung(idMem,name,phone,gmail, stk);
                return nguoiDung;
            }
            cursor.moveToNext();
        }
        cursor.close();
        NguoiDung nguoiDung2 = new NguoiDung("@","","","", "");
        return nguoiDung2;
    }
    public List<NguoiDung> getall(){
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String get_all = "SELECT * FROM NguoiDung";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id,name,phone,gmail, stk;
            id = cursor.getString(0);
            name = cursor.getString(1);
            phone = cursor.getString(2);
            gmail = cursor.getString(3);
            stk = cursor.getString(4);
            NguoiDung nguoiDung = new NguoiDung(id,name,phone,gmail, stk);
            nguoiDungList.add(nguoiDung);
            cursor.moveToNext();
        }
        cursor.close();
        return nguoiDungList;
    }
    public boolean xoaNguoiDung(String id) {
        SQLiteDatabase db =getWritableDatabase();
        int kq = db.delete("NguoiDung","ID = ?",new String[]{id});
        if (kq > 0){
            return true;
        }
        return false;
    }
    public void suaNguoiDung(NguoiDung nguoiDung) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", nguoiDung.id);
        contentValues.put("Name", nguoiDung.ten);
        contentValues.put("Phone", nguoiDung.sdt);
        contentValues.put("Gmail", nguoiDung.gmail);
        contentValues.put("STK", nguoiDung.STK);

         db.update("NguoiDung", contentValues,
                "ID=?", new String[]{nguoiDung.getId()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
