package com.example.itc_databaseapiproject.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT * FROM " + Entity.TABLE_NAME)
    List<Entity> getAllData();
    @Insert
    void insertData(Entity entity); // untuk insert gak perlu pakek id
    @Delete
    void deleteData(Entity entity); // untuk delet perlu pakek cosntruct id karena harus data yang unik
    @Update
    void updateData(Entity entity);
}
