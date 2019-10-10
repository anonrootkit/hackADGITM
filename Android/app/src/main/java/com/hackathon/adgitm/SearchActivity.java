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

import com.hackathon.adgitm.model.Search;
import com.hackathon.adgitm.retrofit.WebApiHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

//    ProgressDialog dialog;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView = findViewById(R.id.search_results);
        WebApiHelper.getInstance().getSearch(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Search search = response.body();
                Adapter adapter = new Adapter(SearchActivity.this, search.getArr());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Some error occurred!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    class Adapter extends ArrayAdapter<String>{

        public Adapter(Context context, ArrayList<String> list) {
            super(context, 0, list);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            String item = getItem(position);

            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.search_list_item, parent, false);
            }
            TextView name = convertView.findViewById(R.id.doc_name);
            name.setText(item);
            return convertView;
        }
    }
}
