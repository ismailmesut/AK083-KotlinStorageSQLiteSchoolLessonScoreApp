package com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.model.LessonScores

class LessonScoresDao {
    @SuppressLint("Range")
    fun allLessonScores(dbh: DatabaseHelper) : ArrayList<LessonScores> {
        val db = dbh.writableDatabase
        val lessonScoreList = ArrayList<LessonScores>()
        val cursor = db.rawQuery("SELECT * FROM lessonscores", null)
        while (cursor.moveToNext()) {
            val lessonScore = LessonScores(cursor.getInt(cursor.getColumnIndex("lesson_id")),
                cursor.getString(cursor.getColumnIndex("lesson_name")),
                cursor.getInt(cursor.getColumnIndex("score1")),
                cursor.getInt(cursor.getColumnIndex("score2")))
            lessonScoreList.add(lessonScore)
        }
        return lessonScoreList
    }

    fun deleteLessonScore(dbh:DatabaseHelper, lesson_id:Int) {
        val db = dbh.writableDatabase
        db.delete("lessonscores", "lesson_id=?", arrayOf(lesson_id.toString()))
        db.close()
    }

    fun addLessonScore(dbh:DatabaseHelper, lesson_name:String, score1:Int, score2:Int) {
        val db = dbh.writableDatabase

        val values = ContentValues()
        values.put("lesson_name", lesson_name)
        values.put("score1", score1)
        values.put("score2", score2)

        db.insertOrThrow("lessonscores", null, values)
        db.close()
    }

    fun updateLessonScore(dbh:DatabaseHelper, lesson_id:Int, lesson_name:String, score1:Int, score2:Int) {
        val db = dbh.writableDatabase

        val values = ContentValues()
        values.put("lesson_name", lesson_name)
        values.put("score1", score1)
        values.put("score2", score2)

        db.update("lessonscores", values, "lesson_id=?", arrayOf(lesson_id.toString()))
        db.close()
    }
}