package com.hackathon.adgitm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ApprovedApps extends AppCompatActivity {


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_apps);

        listView = findViewById(R.id.approved_apps_list);
        ArrayList<String> list = new ArrayList<>();
        list.add("Shalini Jha");
        list.add("Lalit");
        list.add("Shikha Gupta");
        list.add("Komal");
        list.add("KD");
        list.add("ANkit");
        list.add("Shalini");
        list.add("Lalit");
        list.add("Rajiv");
        list.add("Pappu");
        Adapter adapter = new Adapter(this, list);
        listView.setAdapter(adapter);

    }
    class Adapter extends ArrayAdapter<String> {

        public Adapter(Context context, ArrayList<String> list) {
            super(context, 0, list);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final String item = getItem(position);

            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.approved_list_item, parent, false);
            }

            TextView name = convertView.findViewById(R.id.approved_apps_item);
            name.setText(item);
            return convertView;
        }
    }

}
