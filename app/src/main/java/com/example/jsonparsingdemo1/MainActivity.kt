package com.example.jsonparsingdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var textViewName: TextView
    lateinit var textViewSal: TextView
    var jsonString = "{\"employee\":{\"name\":\"adolf hitler\",\"salary\":65000}}"
    lateinit var name:String
    lateinit var salary:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        textViewName = findViewById(R.id.textViewName)
        textViewSal = findViewById(R.id.textViewSal)
        try {

            val obj = JSONObject(jsonString)
            val employee: JSONObject = obj.getJSONObject("employee")
            name = employee.getString("name")
            salary = employee.getString("salary")
            textViewName.text = "Name: $name"
            textViewSal.text = "Salary: $salary"
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}