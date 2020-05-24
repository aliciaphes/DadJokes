package com.android.dadjokes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var apiClient = APIclient(APIservice.API_URL)
    private var service: APIservice? = null
    
    
    // ref: https://www.baeldung.com/retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        service = apiClient.createService()

        getRandomJoke()

        show_more.setOnClickListener{
            getRandomJoke()
        }
    }

    private fun getRandomJoke() {
        val call: Call<Joke>? = service?.getRandomJoke(/*null*/)
        call?.enqueue(object: Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                val jokeReceived = response.body()
                if(jokeReceived?.status == 200){
                    joke.text = jokeReceived.joke
                }
            }

            override fun onFailure(
                call: Call<Joke>,
                t: Throwable?
            ) { //Handle failure
                val a = 6
            }
        })
    }
}
