package br.com.matheuscastiglioni.ideotastruco.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.UUID;

import br.com.matheuscastiglioni.ideotastruco.model.Statistics;

/**
 * Created by matheus on 26/08/17.
 */

public class DAO extends SQLiteOpenHelper {

    public DAO(Context context) {
        super(context, "IdeotasTruco", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
        initTable(sqLiteDatabase, "A");
        initTable(sqLiteDatabase, "B");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "";
        sqLiteDatabase.close();
    }

    public Statistics getStatistics(String team) {
        Statistics statistics = null;
        SQLiteDatabase database = getReadableDatabase();
        String sql = "select * from statistics where team = ?";
        Cursor cursor = database.rawQuery(sql, new String[]{team});
        while (cursor.moveToNext()) {
            statistics = new Statistics(
                cursor.getString(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("team")),
                cursor.getInt(cursor.getColumnIndex("bo3")),
                cursor.getInt(cursor.getColumnIndex("matchs")),
                cursor.getInt(cursor.getColumnIndex("wins")),
                cursor.getInt(cursor.getColumnIndex("loses"))
            );
        }
        return statistics;
    }

    public void updateStatistics(String field, String team) {
        String sql = String.format("update statistics set %s = (%s + 1) where team = '%s'", field, field, team);
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    private void createTable(SQLiteDatabase database) {
        StringBuilder sql = new StringBuilder();
        sql.append("create table statistics (");
        sql.append("id char(36) not null,");
        sql.append("team char(1) not null,");
        sql.append("bo3 integer not null default 0,");
        sql.append("matchs integer not null default 0,");
        sql.append("wins integer not null default 0,");
        sql.append("loses integer not null default 0,");
        sql.append("constraint pkstatistics primary key(id)");
        sql.append(");");
        database.execSQL(sql.toString());
    }

    private void initTable(SQLiteDatabase database, String team) {
        ContentValues values = new ContentValues();
        values.put("id", UUID.randomUUID().toString());
        values.put("team", team);
        database.insert("statistics", null, values);
    }

}
