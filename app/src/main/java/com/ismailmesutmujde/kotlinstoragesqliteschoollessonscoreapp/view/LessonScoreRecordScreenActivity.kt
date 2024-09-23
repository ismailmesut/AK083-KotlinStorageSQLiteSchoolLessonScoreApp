package com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.databinding.ActivityLessonScoreRecordScreenBinding

class LessonScoreRecordScreenActivity : AppCompatActivity() {

    private lateinit var bindingLessonScoreRecord : ActivityLessonScoreRecordScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLessonScoreRecord = ActivityLessonScoreRecordScreenBinding.inflate(layoutInflater)
        val view = bindingLessonScoreRecord.root
        setContentView(view)

        bindingLessonScoreRecord.toolbarLessonScoreRecord.title = "Lesson Score Record"
        setSupportActionBar(bindingLessonScoreRecord.toolbarLessonScoreRecord)

        bindingLessonScoreRecord.buttonSave.setOnClickListener {
            val intent = Intent(this@LessonScoreRecordScreenActivity, MainScreenActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}