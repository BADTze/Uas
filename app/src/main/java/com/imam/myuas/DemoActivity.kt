package com.imam.myuas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.imam.myuas.model.DataModel
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {
    var data: ArrayList<DataModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        data = ArrayList()
        val activityName = intent.getStringExtra("activityName")

        data?.add(DataModel(R.drawable.cacaban))

        recyclerview.adapter = DataAdapter(data, object : DataAdapter.OnClickListener{
            override fun detail(item: DataModel?) {
                intent.putExtra("gambar", item?.gambar)
                startActivity(intent)
            }

        })
    }
}
