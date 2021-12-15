package ch.rz.quicklist.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ToDoDao {

    @Query("SELECT * FROM todo")
    List<ToDo> getAll();

    @Query("SELECT * FROM todo WHERE id IN (:id)")
    List<ToDo> loadAllByIds(int[] id);

    @Query("SELECT * FROM todo WHERE name IN (:name)")
    ToDo findByName(String name);

    @Query("SELECT * FROM todo WHERE cat IN (:cat)")
    ToDo findByCategory(String cat);

    @Query("UPDATE todo SET checked = :checked WHERE id == :id")
    void updateChecked(int id, boolean checked);

    @Insert
    void insertAll(ToDo... todos);

    @Delete
    void delete(ToDo toDo);

}
