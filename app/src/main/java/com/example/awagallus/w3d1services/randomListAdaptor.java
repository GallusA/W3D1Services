package com.example.awagallus.w3d1services;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by HP on 8/16/2017.
 */

public class randomListAdaptor extends RecyclerView.Adapter<randomListAdaptor.ViewHolder> {
    Context context;
    List<RandomNum> ramdomList = new ArrayList<>();

    public randomListAdaptor(List<RandomNum> ramdomList) {
        this.ramdomList = ramdomList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView randomN;

        public ViewHolder(View itemView) {
            super(itemView);

            randomN = (TextView) itemView.findViewById(R.id.textView2);

        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_list_item, parent, false);
        return new ViewHolder(view);
    }
    private int lastPosition = -1;
    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: ");
        final RandomNum randomA = ramdomList.get(position);
        holder.randomN.setText(""+ randomA.getRandom());

    }

    public int getItemCount() {
        return ramdomList.size();
    }


}