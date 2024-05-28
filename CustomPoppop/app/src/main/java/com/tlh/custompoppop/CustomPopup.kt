package com.tlh.custompoppop

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomPopup(private val mContext: Context): RecyclerView.LayoutManager() {
    private var mPopupWindow: PopupWindow? = null
    @SuppressLint("MissingInflatedId")
    fun showPopup(anchorView: View?, message: String?) {
        // Inflate the popup_layout.xml

        val popupView: View = LayoutInflater.from(mContext).inflate(R.layout.popup_layout, null)

        // Create a PopupWindow
        mPopupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        // Set background color to transparent
        mPopupWindow!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Set animation style
        mPopupWindow!!.animationStyle = android.R.style.Animation_Dialog

        // Display the popup window
        mPopupWindow!!.showAsDropDown(anchorView)

        // Set message
        val textView = popupView.findViewById(R.id.textView_message) as TextView
        textView.text = message

        val button = popupView.findViewById(R.id.button) as Button
        button.setOnClickListener{it->
            Log.d("dokundu", "dokundu")
        }
    }

    fun dismissPopup() {
        if (mPopupWindow != null && mPopupWindow!!.isShowing) {
            mPopupWindow!!.dismiss()
        }
    }

    override fun addDisappearingView(child: View?) {
        z
    }
}

