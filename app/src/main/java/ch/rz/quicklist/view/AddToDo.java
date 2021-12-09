package ch.rz.quicklist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ch.rz.quicklist.R;

public class AddToDo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
    }
    public void goToMain(View view){
        Intent myIntent = new Intent(AddToDo.this, MainActivity.class);
        AddToDo.this.startActivity(myIntent);
    }
}