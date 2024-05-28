package com.tlh.recyclervievdata.adapters

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tlh.recyclervievdata.MainActivity
import com.tlh.recyclervievdata.R
import com.tlh.recyclervievdata.models.Post

class PostItemHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {


    fun bindItem(itemModel: Post) {
        val r_title = itemView.findViewById<TextView>(R.id.r_title)
        val r_userId = itemView.findViewById<TextView>(R.id.r_userId)

        r_title.text = itemModel.title
        r_userId.text = itemModel.userId.toString()

        itemView.setOnClickListener {
            Log.d(TAG, "bindItem:clikc $itemModel")
            val i = Intent(itemView.context, MainActivity::class.java)
            itemView.context.startActivity(i)
        }
    }
}