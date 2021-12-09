package ch.rz.quicklist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ch.rz.quicklist.R;

public class MainActivity extends AppCompatActivity {

    public String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToAdd(View view){
        Intent myIntent = new Intent(MainActivity.this, AddToDo.class);
        myIntent.putExtra("color", color); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }
    
}