package com.example.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Entity
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "last_name")
    val lastName : String,
    @ColumnInfo(name = "first_name")
    val firstName : String
) {
    constructor(lastName: String, firstName: String) : this(0,lastName, firstName)
}




































