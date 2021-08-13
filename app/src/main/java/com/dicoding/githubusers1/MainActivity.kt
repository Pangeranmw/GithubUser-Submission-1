package com.dicoding.githubusers1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.githubusers1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listUser: ArrayList<UserData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listUser.addAll(DataUser.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = UserAdapter(listUser)
        binding.rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: UserData) {
                val listDataUser = UserData(
                    data.username,
                    data.name,
                    data.location,
                    data.repository,
                    data.company,
                    data.followers,
                    data.following,
                    data.avatar,
                )
                val detail = Intent(this@MainActivity, UserDetail::class.java)
                    .putExtra(UserDetail.EXTRA_DATA, listDataUser)
                startActivity(detail)
            }
        })
    }
}
