package com.hackathon.adgitm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.adgitm.model.FeedModel;

import java.util.ArrayList;
import java.util.List;

public class PendingApp extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_app);

        listView = findViewById(R.id.pending_apps_list);
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        list.add("Test");
        Adapter adapter = new Adapter(this, list);
        listView.setAdapter(adapter);
    }
    class Adapter extends ArrayAdapter<String>{

        public Adapter(Context context, ArrayList<String> list) {
            super(context, 0, list);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final String item = getItem(position);

            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.pending_apps_list_item, parent, false);
            }

            TextView text = convertView.findViewById(R.id.pending_user_name);
            text.setText(item);
            TextView approve = convertView.findViewById(R.id.approve);
            TextView deny = convertView.findViewById(R.id.deny);
            approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(PendingApp.this, "Approved!", Toast.LENGTH_SHORT).show();
                    remove(item);
                }
            });

            deny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(PendingApp.this, "Denied!", Toast.LENGTH_SHORT).show();
                    remove(item);
                }
            });

            return convertView;
        }
    }
}
