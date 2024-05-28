package com.tlh.custompoppop


// ItemClass

// ItemClass
import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // From the MainActivity, find the RecyclerView.
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Create and set the layout manager
        // For the RecyclerView.
        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)
        val itemClasses: MutableList<ItemClass> = ArrayList<ItemClass>()

        // pass the arguments
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutOne,
                "Item Type 1"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutOne,
                "Item Type 1"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Item Type 2", "Text"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutOne,
                "Item Type 1"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Item Type 2", "Text"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Item Type 2", "Text"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutOne,
                "Item Type 1"
            )
        )
        itemClasses.add(
            ItemClass(
                ItemClass.LayoutTwo, R.drawable.icon,
                "Item Type 2", "Text"
            )
        )
        val adapterClass = AdapterClass(itemClasses)
        val adapter = AdapterClass(adapterClass)

        // set the adapter
        recyclerView.setAdapter(adapter)

     val l = LinearLayoutManager(applicationContext)
        c = LayoutManager.
    }
    override fun addDis
}

