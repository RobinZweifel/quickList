package ch.rz.quicklist.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import ch.rz.quicklist.R;
import ch.rz.quicklist.controller.GestureListener;
import ch.rz.quicklist.controller.ToDoAdapter;
import ch.rz.quicklist.model.AppDatabase;
import ch.rz.quicklist.model.ToDoDao;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public String color;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    public int temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "todos").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        ToDoDao toDoDao = db.toDoDao();
        RecyclerView list = findViewById(R.id.toDoView);

        list.setAdapter(new ToDoAdapter(toDoDao.getAll(), getApplicationContext()));
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    public void goToAdd(View view) {
        Intent myIntent = new Intent(MainActivity.this, AddToDo.class);
        myIntent.putExtra("color", color);
        MainActivity.this.startActivity(myIntent);

    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        Log.e("test", "JAMANNNNN");
        temperature = (int) event.values[0];
        Log.e("Temptature", Integer.toString(temperature));
        View view = findViewById(R.id.viewMain);
        if(temperature < -20){
            view.setBackgroundColor(Color.argb(30 ,0 , 0, 200));
        }
        else if(temperature > -20 && temperature < -10){
            view.setBackgroundColor(Color.argb(30 ,50 , 0, 100));
        }
        else if(temperature > -10 && temperature < 0){
            view.setBackgroundColor(Color.argb(30 ,100 , 0, 80));
        }
        else if(temperature > 0 && temperature < 10){
            view.setBackgroundColor(Color.argb(30 ,130 , 0, 60));
        }
        else if(temperature > 10 && temperature < 20){
            view.setBackgroundColor(Color.argb(30 ,170 , 0, 40));
        }
        else if(temperature > 20 && temperature < 30){
            view.setBackgroundColor(Color.argb(30 ,200 , 0, 20));
        }
        else if(temperature > 30){
            view.setBackgroundColor(Color.argb(30 ,230 , 0, 0));

        }
        //view.setBackgroundColor(Color.argb(10 ,Math.min(255, temprature*5) , , 0));
        Log.e("Temp Log", Integer.toString(Math.min(255, temperature *5)));

    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}