package com.example.patrickkizz.notes;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NotesAdder extends AppCompatActivity implements TextWatcher {

    Intent i;
    int notesId;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notesadder, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_adder);
        setTitle("Edit your Notes");
        EditText editText=(EditText)findViewById(R.id.userText);
        i=getIntent();
       notesId=i.getIntExtra("noteID",- 1);
        if(notesId != -1){

            editText.setText(MainActivity.notes.get(notesId));
        }

        editText.addTextChangedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item){

        int id=Item.getItemId();
        if(id==R.id.back){

            i= new Intent(getApplicationContext(),MainActivity.class);

            startActivity(i);


            return true;

        }
        return super.onOptionsItemSelected(Item);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        MainActivity.notes.set(notesId,String.valueOf(s));
        MainActivity.arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
