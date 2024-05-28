package com.tlh.recyclervievdata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tlh.recyclervievdata.R
import com.tlh.recyclervievdata.models.Post

class PostAdapter(val list: List<Post>) :
    RecyclerView.Adapter<PostItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        return PostItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {

        holder.bindItem(list.get(position))

    }


    override fun getItemCount(): Int {
        return list.size
    }


}