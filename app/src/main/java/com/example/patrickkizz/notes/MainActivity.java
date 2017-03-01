package com.example.patrickkizz.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent i;
    static ArrayList<String> notes =new ArrayList<String>();
    static ArrayAdapter<String> arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addNotes(){


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listView);

        notes.add("notes examples");
      arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                i=new Intent(getApplicationContext(),NotesAdder.class);
                i.putExtra("noteID",position);
                startActivity(i);
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item){

        int id=Item.getItemId();
        if(id==R.id.add){
          i= new Intent(getApplicationContext(),NotesAdder.class);
            startActivity(i);


            return true;

        }



        return super.onOptionsItemSelected(Item);
    }
}
