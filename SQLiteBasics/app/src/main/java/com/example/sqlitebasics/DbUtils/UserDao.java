package com.example.sqlitebasics.DbUtils;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface UserDao {
    @Insert
    void  createUser(User user);

    @Query("Select * FROM user where username like :strUsername")
    User getUserByUsername(String strUsername);
}
