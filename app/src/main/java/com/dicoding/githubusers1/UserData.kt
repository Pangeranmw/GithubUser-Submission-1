package com.dicoding.githubusers1
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    var username: String?=null,
    var name: String?=null,
    var location: String?=null,
    var repository: Int?=null,
    var company: String?=null,
    var followers: Int?=null,
    var following: Int?=null,
    var avatar: Int?=null
): Parcelable