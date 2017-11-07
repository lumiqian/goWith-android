package com.android.lumi.gowith;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lumi Qian on 11/6/17.
 */

public class EventListAdapter extends ArrayAdapter<String> {


    public EventListAdapter(Context context, String[] eventNames) {
        super(context, R.layout.event_row_layout, eventNames);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInFlater = LayoutInflater.from(getContext());
        View theView = theInFlater.inflate(R.layout.event_row_layout, parent, false);

        String displayedEvent = getItem(position);
        TextView eventTextView = (TextView)theView.findViewById(R.id.event_text_view);
        eventTextView.setText(displayedEvent);

        ImageView imageView = (ImageView)theView.findViewById(R.id.image_view_1);
        imageView.setImageResource(R.drawable.dot);

        String participants = "Participants: ";

        //Todo: need to send a GET API call to get participant list and then append to participants string

        TextView participantsTextView = (TextView)theView.findViewById(R.id.participants_text_view);
        participantsTextView.setText(participants);

        return theView;
    }
}
