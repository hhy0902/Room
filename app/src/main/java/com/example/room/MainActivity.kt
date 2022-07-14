package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 기본적으로 데이터베이스 작업은 메인 쓰레드에서 할 수 없다
        // 이유는, 데이터베이스 작업을 하는 동안 사용자가 기다려야 하기 때문
        // 해결책은 쓰레드를 이용하거나 async
        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).allowMainThreadQueries().build()



        findViewById<Button>(R.id.save).setOnClickListener {
            val userProfile = UserProfile("길동", "홍")
            database.userProfileDao().insert(userProfile)
            Log.d("testt" ,"저장 ")
        }

        findViewById<Button>(R.id.load).setOnClickListener {
            val userProfiles = database.userProfileDao().getAll()
            Log.d("testt" ,"${userProfiles}")

            userProfiles.forEach {
                Log.d("testt","${it}")
            }
        }

        findViewById<Button>(R.id.delete).setOnClickListener {
            database.userProfileDao().delete(1)
        }



    }
}








































