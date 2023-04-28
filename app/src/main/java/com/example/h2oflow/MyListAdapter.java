package com.example.h2oflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private ArrayList<MyListData> myListDataArrayList;
    private SelectListener listener;


    public MyListAdapter(SelectListener listener, ArrayList<MyListData> myListDataArrayList, Context context) {
        this.myListDataArrayList = myListDataArrayList;
        this.listener = listener;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<MyListData> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        myListDataArrayList = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        MyListData model = myListDataArrayList.get(position);
        holder.customerTV.setText(model.getCustomer());
        holder.meterNoTV.setText(model.getMeterNo());
        holder.statusTV.setText(model.getStatus());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(myListDataArrayList.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        // returning the size of array list.
        return myListDataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private final TextView customerTV;
        private final TextView meterNoTV;
        private final TextView statusTV;
        private final CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            customerTV = itemView.findViewById(R.id.idCustomer);
            meterNoTV = itemView.findViewById(R.id.idMeterNo);
            statusTV = itemView.findViewById(R.id.idStatus);
            cardView = itemView.findViewById(R.id.main_container);
        }
    }



}