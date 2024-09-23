package com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.R
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.databinding.ActivityLessonScoreDetailScreenBinding
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.model.LessonScores


class LessonScoreDetailScreenActivity : AppCompatActivity() {

    private lateinit var bindingLessonScoreDetailScreen : ActivityLessonScoreDetailScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLessonScoreDetailScreen = ActivityLessonScoreDetailScreenBinding.inflate(layoutInflater)
        val view = bindingLessonScoreDetailScreen.root
        setContentView(view)

        bindingLessonScoreDetailScreen.toolbarLessonScoreDetail.title = "Lesson Score Detail"
        setSupportActionBar(bindingLessonScoreDetailScreen.toolbarLessonScoreDetail)

        val lessonScore = intent.getSerializableExtra("obj") as LessonScores

        bindingLessonScoreDetailScreen.editTextLessonDetail.setText(lessonScore.lesson_name)
        bindingLessonScoreDetailScreen.editTextScore1Detail.setText((lessonScore.score1).toString())
        bindingLessonScoreDetailScreen.editTextScore2Detail.setText((lessonScore.score2).toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_delete -> {
                Snackbar.make(bindingLessonScoreDetailScreen.toolbarLessonScoreDetail, "Delete it?",Snackbar.LENGTH_SHORT)
                    .setAction("YES") {
                        startActivity(Intent(this@LessonScoreDetailScreenActivity, MainScreenActivity::class.java))
                        finish()
                    }.show()
                return true
            }
            R.id.action_edit -> {
                val intent = Intent(this@LessonScoreDetailScreenActivity, MainScreenActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return false
        }
    }
}