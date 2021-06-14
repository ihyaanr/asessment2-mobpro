package org.d3if2005.itemreminder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RemindAdapter extends RecyclerView.Adapter<RemindAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyReminder> myReminder;

    public RemindAdapter(Context c, ArrayList<MyReminder> p){
        context = c;
        myReminder = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_reminder, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.titlereminder.setText(myReminder.get(i).getTitlereminder());
        viewHolder.locationreminder.setText(myReminder.get(i).getLocationreminder());
        viewHolder.datereminder.setText(myReminder.get(i).getDatereminder());

        final String getTitleReminder = myReminder.get(i).getTitlereminder();
        final String getLocationReminder = myReminder.get(i).getLocationreminder();
        final String getDateReminder = myReminder.get(i).getDatereminder();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Reminder1.class);
//                intent.putExtra("titlereminder", getTitleReminder);
//                intent.putExtra("locationreminder", getLocationReminder);
//                intent.putExtra("datereminder", getDateReminder);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myReminder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titlereminder, locationreminder, datereminder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titlereminder = (TextView) itemView.findViewById(R.id.titlereminder);
            locationreminder = (TextView) itemView.findViewById(R.id.locationreminder);
            datereminder = (TextView) itemView.findViewById(R.id.datereminder);
        }
    }
}
