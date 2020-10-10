package edu.weber.cs.w1234567.roomdemo.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("Select * from user")
    LiveData<List<User>> getAll();

    @Query("Select * from user WHERE uid=:uid")
    User getUserByID(int uid);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void deleteUser(User user);
}
