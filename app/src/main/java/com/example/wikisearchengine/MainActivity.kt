package com.example.wikisearchengine

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wikisearchengine.models.Query
import com.example.wikisearchengine.models.WikiSearchModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var editTextSearch: EditText
    lateinit var imageBtnSearch: ImageButton
    lateinit var textViewTitle: TextView
    lateinit var textViewDescription: TextView
    lateinit var textViewDate: TextView
    lateinit var textViewTotalHits: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()

    }

    private fun initialization() {
        editTextSearch = findViewById(R.id.et_search)
        imageBtnSearch = findViewById(R.id.imgBtn_search)
        textViewTitle  = findViewById(R.id.tv_title)
        textViewDescription = findViewById(R.id.tv_description)
        textViewDate = findViewById(R.id.tv_date)
        textViewTotalHits = findViewById(R.id.tv_total_hits)


        clickListeners()

    }

    private fun clickListeners() {
        imageBtnSearch.setOnClickListener {

            val call : Call<WikiSearchModel> = WikiInterface.create().getWikiProfile(editTextSearch.text.toString())


            call.enqueue(object : Callback<WikiSearchModel>{
                override fun onResponse(
                    call: Call<WikiSearchModel>,
                    response: Response<WikiSearchModel>
                ) {

                    val query : Query = response.body()!!.query

                    textViewTitle.text = query.search.get(0).title
                    textViewTotalHits.text = Html.fromHtml(query.searchinfo.totalhits.toString())
                    textViewDescription.text = Html.fromHtml(query.search.get(0).snippet)
                   val time = query.search.get(0).timestamp
                    textViewDate.text = time.substringBefore("T")


                }

                override fun onFailure(call: Call<WikiSearchModel>, t: Throwable) {
                    Log.d("Error::",t.message.toString())
                }
            })



        }
    }



}


