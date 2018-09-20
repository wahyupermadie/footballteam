package com.example.wahyupermadi.footballteam.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class SQLiteOpenHelper(ctx : Context) : ManagedSQLiteOpenHelper(ctx, "favoriteTeam.db", null, 1) {
    companion object {
        private var instance : SQLiteOpenHelper? = null

        @Synchronized
        fun getInstance(ctx : Context): SQLiteOpenHelper {
            if (instance == null){
                instance = SQLiteOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.createTable(Favorite.TABLE_FAVORITE, true,
                Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Favorite.TEAM_ID to TEXT + UNIQUE,
                Favorite.TEAM_NAME to TEXT,
                Favorite.TEAM_BADGE to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.dropTable(Favorite.TABLE_FAVORITE, true)
    }

}

val Context.database : SQLiteOpenHelper
    get() = SQLiteOpenHelper.getInstance(applicationContext)