package com.example.harrypotter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Step 3: Populating RecyclerView with API Data
//      - configure recyclerview adapter for api data
//      - set adapter for recyclerview in onResponse method

class MainActivity : AppCompatActivity() {

    lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

        recycler = findViewById(R.id.hp_recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)

    }

    private fun getData() {
        val data = HarryPotterAPIService.hp_instance.getCharacters()
        data.enqueue(object: Callback<List<HarryPotterData>> {
            override fun onResponse(
                call: Call<List<HarryPotterData>>,
                response: Response<List<HarryPotterData>>?
            ) {
//                Log.d("API Fetch", response.body().toString())
                val resultData : List<HarryPotterData>? = response?.body()
                recycler.adapter = HarryPotterAdapter(this@MainActivity, resultData)
            }

            override fun onFailure(call: Call<List<HarryPotterData>>, t: Throwable) {
                Log.d("API Fetch", "Error while fetching", t)
            }

        })
    }
}