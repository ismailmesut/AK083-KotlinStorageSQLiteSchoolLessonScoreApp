package com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "lessonscores.sqlite", null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE lessonscores(lesson_id INTEGER PRIMARY KEY AUTOINCREMENT, lesson_name TEXT, score1 INTEGER, score2 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS lessonscores")
        onCreate(db)
    }
}