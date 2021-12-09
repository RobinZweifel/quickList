package ch.rz.quicklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import ch.rz.quicklist.R;
import ch.rz.quicklist.model.AppDatabase;
import ch.rz.quicklist.model.ToDo;
import ch.rz.quicklist.model.ToDoDao;

public class AddToDo extends AppCompatActivity {


    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");

    }

    public void goToMain(View view) {
        testDb();
        Intent myIntent = new Intent(AddToDo.this, MainActivity.class);
        AddToDo.this.startActivity(myIntent);
    }

    public void testDb() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "todos").allowMainThreadQueries().build();

        ToDo toDo = new ToDo();
        toDo.name = ((TextView) findViewById(R.id.nameInput)).getText().toString();
        toDo.checked = false;

        ToDoDao toDoDao = db.toDoDao();
        toDoDao.insertAll(toDo);
    }


}