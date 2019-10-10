package com.hackathon.adgitm.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackathon.adgitm.R;
import com.hackathon.adgitm.model.FeedModel;

import java.util.ArrayList;

public class FeedAdapter extends ArrayAdapter<FeedModel> {

    public FeedAdapter(Context context, ArrayList<FeedModel> list) {
        super(context, 0, list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FeedModel item = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.feed_list_item, parent, false);
        }

        TextView heading = convertView.findViewById(R.id.feed_heading);
        heading.setText(item.getHeading());

        TextView answer = convertView.findViewById(R.id.feed_data);
        answer.setText(String.valueOf(item.getAnswer()));

        return convertView;

    }
}
