package com.example.hello

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNames.layoutManager = LinearLayoutManager(baseContext)
        val namesAdapter = NamesRecyclerViewAdapter(courselist = ListOf(
            courses(course_id : 2,course_name:"C++",course_code:1,instructor:"George",description:"C++ development")
            courses(course_id : 3,course_name:"Front-end Development",course_code:12,instructor:"Purity",description:"Front-end course")
            courses(course_id : 4,course_name:"UI/UX Design",course_code:8,instructor:"Nyandia",description:"UI/UX design course")
            courses(course_id : 5,course_name:"UI_UX Development",course_code:7,instructor:"Jeff",description:"UI_UX course")
            courses(course_id : 6,course_name:"Maths ",course_code:5,instructor:"Malcom",description:"Math course")
            courses(course_id : 7,course_name:"Machine Learning",course_code:4,instructor:"Lewis",description:"Machine Learning course")
            courses(course_id : 8,course_name:"Ruby",course_code:3,instructor:"Sarah",description:"Ruby course")
            courses(course_id : 9,course_name:"Java",course_code:2,instructor:"Wendy",description:"Java course")
            courses(course_id : 10,course_name:"C#",course_code:6,instructor:"Valary",description:"C# course")
        )


        rvNames.adapter = namesAdapter
    }
}