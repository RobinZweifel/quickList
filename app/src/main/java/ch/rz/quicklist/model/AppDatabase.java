package ch.rz.quicklist.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ToDo.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ToDoDao toDoDao();
}
