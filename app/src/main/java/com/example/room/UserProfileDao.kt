package com.example.room

import androidx.room.*

@Dao
interface UserProfileDao {
    // query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userProfile: UserProfile)

    @Query("DELETE FROM userprofile WHERE id = :userId")
    fun delete(userId: Int)

    @Query("SELECT * FROM userprofile")
    fun getAll() : MutableList<UserProfile>

}
