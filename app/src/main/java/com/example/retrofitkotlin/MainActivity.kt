package com.example.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.model.Item
import com.example.retrofitkotlin.model.MainModel
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog
    lateinit var recyclerMovieList: RecyclerView
    lateinit var search_btn: Button
    lateinit var search_txt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerMovieList= findViewById(R.id.recyclerMovieList)

        search_txt = findViewById(R.id.input_view)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        search_btn = findViewById(R.id.search_button)
        search_btn.setOnClickListener{
            var search: String= search_txt.text.toString().trim()
            getAllMovieList(search)
        }
    }

    private fun getAllMovieList(search_txt: String) {
        dialog.show()
        mService.getMovieList(search_txt).enqueue(object : Callback<MainModel> {
            override fun onFailure(call: Call<MainModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<MainModel>,
                                    response: Response<MainModel>) {
                adapter = MyMovieAdapter(baseContext, response.body() as MainModel)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
                dialog.dismiss()
            }
        })
    }
}