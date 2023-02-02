package com.example.dictionaryapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionaryapp2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var kelimelerListe : ArrayList<Kelimeler>
    private lateinit var adapter : KelimelerAdapter
    private lateinit var kelimelerDaoInterface : KelimelerDaoInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.toolbar.title = "Dictionary"
        setSupportActionBar(binding.toolbar)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        kelimelerDaoInterface = ApiUtils.getKelimelerDaoInterface()

        tumKelimeler()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        aramaYap(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        aramaYap(newText)
        return true
    }

    fun tumKelimeler() {
        kelimelerDaoInterface.tumKelimeler().enqueue(object : Callback<KelimelerResponse>{

            override fun onResponse(call: Call<KelimelerResponse>, response: Response<KelimelerResponse>) {
                if(response != null) {

                    val liste = response.body()!!.kelimeler
                    adapter = KelimelerAdapter(liste as ArrayList<Kelimeler>)
                    binding.recyclerView.adapter = adapter

                }

            }

            override fun onFailure(call: Call<KelimelerResponse>, t: Throwable) {
            }

        })
    }

    fun aramaYap(aramaKelime : String) {
        kelimelerDaoInterface.kelimeAra(aramaKelime).enqueue(object : Callback<KelimelerResponse>{

            override fun onResponse(call: Call<KelimelerResponse>, response: Response<KelimelerResponse>) {
                if(response != null) {

                    val liste = response.body()!!.kelimeler
                    adapter = KelimelerAdapter(liste as ArrayList<Kelimeler>)
                    binding.recyclerView.adapter = adapter

                }

            }

            override fun onFailure(call: Call<KelimelerResponse>, t: Throwable) {
            }

        })
    }


}