package vn.edu.ptithcm.quanlysinhvien.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="QLSV";
    private static final int DB_VER = 1;
    public Dbhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable1 =
                "CREATE TABLE lophocs(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " tenlop text not null)";

        String createTable2 =
                "CREATE TABLE sinhviens(id text primary key, " +
                " hoten text not null, ngaysinh text, lophocid INTEGER, " +
                " FOREIGN KEY (lophocid) REFERENCES lophocs(id))";

        db.execSQL(createTable1);
        db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
