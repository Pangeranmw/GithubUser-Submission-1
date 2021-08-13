package com.dicoding.githubusers1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.githubusers1.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailBinding

    companion object{
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listUser = intent.getParcelableExtra<UserData>(EXTRA_DATA) as UserData

        listUser.avatar?.let { binding.detailAvatar.setImageResource(it) }
        binding.detailUsername.text = listUser.username
        binding.detailName.text = listUser.name
        binding.detailLocation.text = listUser.location
        binding.detailRepo.text = listUser.repository.toString()
        binding.detailCompany.text = listUser.company
        binding.detailFollowers.text = listUser.followers.toString()
        binding.detailFollowing.text = listUser.following.toString()

        supportActionBar!!.title = "${binding.detailName.text} Profile"

    }

}