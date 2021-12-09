package ch.rz.quicklist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;
import java.util.Objects;

import ch.rz.quicklist.R;
import ch.rz.quicklist.model.AppDatabase;
import ch.rz.quicklist.model.ToDo;
import ch.rz.quicklist.model.ToDoDao;

public class MainActivity extends AppCompatActivity {

    public String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    public void goToAdd(View view){
        Intent myIntent = new Intent(MainActivity.this, AddToDo.class);
        myIntent.putExtra("color", color);
        MainActivity.this.startActivity(myIntent);
        testDb();

    }

    public void testDb(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        ToDoDao toDoDao = db.toDoDao();
        List<ToDo> toDos = toDoDao.getAll();



    }


}