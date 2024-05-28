package com.tlh.recyclervievdata


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tlh.recyclervievdata.adapters.PostAdapter
import com.tlh.recyclervievdata.datas.DummyUsers

class MainActivity : AppCompatActivity() {
    private lateinit var postList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        postList = findViewById(R.id.postList)
        postList.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        val posts = DummyUsers.getUsers().posts
        val adapter = PostAdapter(posts)
        postList.adapter = adapter

    }
}
