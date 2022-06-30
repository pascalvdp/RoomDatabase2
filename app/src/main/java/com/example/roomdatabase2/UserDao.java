package com.example.roomdatabase2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    //@Query("DELETE FROM user")
    //void deleteTable();

    //@Delete
    //void deleteDatabase(AppDatabase appDatabase);

    //@Query(DROP TABLE IF EXISTS user)

    @Query("SELECT * FROM user")
    List<User> getAll();// public User[] getAll()

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("SELECT * FROM user WHERE first_name LIKE :first LIMIT 1")
    User searchToFirstName(String first);

    @Query("SELECT * FROM user WHERE last_name LIKE :last")
    User searchToLastName(String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Delete
    void deleteAll(User... users);

    @Delete
    void deleteAllTest(List<User> users); //User... users

    @Delete
    void deleteAllUsers(List<User> users);

    @Insert
    void insertAllUsersTest(UserTest... userTests);
}
