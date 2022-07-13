package com.example.tarea2_3jonathan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tarea2_3jonathan.Procesos.Adapter;
import com.example.tarea2_3jonathan.Procesos.DatabaseHandler;

public class ActivityMostrar extends AppCompatActivity {

    DatabaseHandler objectDatabaseHandler;
    RecyclerView objectRecycleView;
    Adapter objectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        try {
            objectRecycleView=findViewById(R.id.listimagen);
            objectDatabaseHandler=new DatabaseHandler(this);

        } catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void getData(View view) {
        try {
            objectAdapter=new Adapter(objectDatabaseHandler.getAllImagesData());
            objectRecycleView.setHasFixedSize(true);

            objectRecycleView.setLayoutManager(new LinearLayoutManager(this));
            objectRecycleView.setAdapter(objectAdapter);
        }
        catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}