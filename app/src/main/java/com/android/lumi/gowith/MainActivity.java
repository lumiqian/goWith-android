package com.android.lumi.gowith;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Lumi Qian on 11/6/17.
 */

public class MainActivity extends AppCompatActivity {

    private EditText participantNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        participantNameEditText = (EditText)findViewById(R.id.participant_name_edit_text);

        String[] listedEvents = {"Exhibition: Neighborhood Earth", "Fitness: Century Park Morning Run", "Market: Second-hand Party"};


        ListAdapter listAdapter = new EventListAdapter(this, listedEvents);

        ListView listView = (ListView)findViewById(R.id.eventListView);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String eventPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, eventPicked, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void OnGoingButtonClick(View view) {
        String participantName = "";

        if(participantNameEditText.getText().length() != 0){
            participantName = String.valueOf(participantNameEditText.getText());
        }

        //todo: need to send a POST API call to add this participantName to this event's participants list

        String yourConfirmedResponse = participantName + ", thank you for registering here!";
        Toast.makeText(this, yourConfirmedResponse, Toast.LENGTH_SHORT).show();
    }

}
