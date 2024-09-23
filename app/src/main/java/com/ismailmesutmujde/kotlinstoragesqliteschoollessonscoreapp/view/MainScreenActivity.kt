package com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.adapter.LessonScoresRecyclerViewAdapter
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.dao.LessonScoresDao
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.databinding.ActivityMainScreenBinding
import com.ismailmesutmujde.kotlinstoragesqliteschoollessonscoreapp.model.LessonScores


class MainScreenActivity : AppCompatActivity() {

    private lateinit var bindingMainScreen : ActivityMainScreenBinding
    private lateinit var lessonScoreList:ArrayList<LessonScores>
    private lateinit var adapter:LessonScoresRecyclerViewAdapter
    private lateinit var dbh:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainScreen = ActivityMainScreenBinding.inflate(layoutInflater)
        val view = bindingMainScreen.root
        setContentView(view)

        bindingMainScreen.toolbar.title = "Lesson Score App"
        bindingMainScreen.toolbar.subtitle = "Average : 0"
        setSupportActionBar(bindingMainScreen.toolbar)

        bindingMainScreen.recyclerView.setHasFixedSize(true)
        bindingMainScreen.recyclerView.layoutManager = LinearLayoutManager(this)

        /*
        lessonScoreList = ArrayList()

        val l1 = LessonScores(1,"History", 40, 80)
        val l2 = LessonScores(2,"Chemistry", 70, 50)
        val l3 = LessonScores(3,"Physics",30,60)

        lessonScoreList.add(l1)
        lessonScoreList.add(l2)
        lessonScoreList.add(l3)

         */

        dbh = DatabaseHelper(this)
        lessonScoreList = LessonScoresDao().allLessonScores(dbh)

        adapter = LessonScoresRecyclerViewAdapter(this, lessonScoreList)
        bindingMainScreen.recyclerView.adapter = adapter

        var sum = 0
        for(ls in lessonScoreList) {
            sum = sum + (ls.score1 + ls.score2) / 2
        }

        if(sum != 0) {
            bindingMainScreen.toolbar.subtitle = "Average : ${sum/lessonScoreList.size}"
        }

        bindingMainScreen.fab.setOnClickListener {
            val intent = Intent(this@MainScreenActivity, LessonScoreRecordScreenActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}