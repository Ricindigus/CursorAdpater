package com.example.dmorales.cursoradpater;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        cargarDatos();

        try{
            Data data = new Data(getApplicationContext());
            data.open();
            Cursor cursor = data.getAllItems();
            data.close();
            if(cursor != null){
                ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(),cursor);
                recyclerView.setAdapter(itemAdapter);
            }
        }catch (SQLException e){}
    }

    public void cargarDatos(){
        items = new ArrayList<Item>();
        items.add(new Item("43372489","Denis Ricardo","Morales Retamozo","984763597"));
        items.add(new Item("43358466","Luis Juan","Maldonado Gutierrez","984768755"));
        items.add(new Item("43372323","Julio Paolo","Pachioni Retamozo","985763452"));
        items.add(new Item("43233317","Diego Armando","Ramirez Lujan","956963597"));
        items.add(new Item("43372434","Denis Ricardo","Morales Retamozo","984763597"));
        items.add(new Item("43358421","Luis Juan","Maldonado Gutierrez","984768755"));
        items.add(new Item("43372411","Julio Paolo","Pachioni Retamozo","985763452"));
        items.add(new Item("43372422","Diego Armando","Ramirez Lujan","956963597"));
        items.add(new Item("43372478","Denis Ricardo","Morales Retamozo","984763597"));
        items.add(new Item("43358488","Luis Juan","Maldonado Gutierrez","984768755"));
        items.add(new Item("43375678","Julio Paolo","Pachioni Retamozo","985763452"));
        items.add(new Item("43346476","Diego Armando","Ramirez Lujan","956963597"));
        items.add(new Item("43373384","Denis Ricardo","Morales Retamozo","984763597"));
        items.add(new Item("43344456","Luis Juan","Maldonado Gutierrez","984768755"));
        items.add(new Item("43777755","Julio Paolo","Pachioni Retamozo","985763452"));
        items.add(new Item("43345267","Diego Armando","Ramirez Lujan","956963597"));
        Data data = new Data(getApplicationContext());
        data.open();
        data.insertarItems(items);
        data.close();
    }
}
