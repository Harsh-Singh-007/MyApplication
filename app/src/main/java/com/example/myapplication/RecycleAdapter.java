package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    Context context;
    ArrayList<Hero> heroes;
    AlertDialog.Builder builder;

    public RecycleAdapter(Context context, ArrayList<Hero> heroes) {
        this.context=context;
        this.heroes=heroes;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        builder = new AlertDialog.Builder(context);
        addItem(position,holder);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setMessage("Do you want to delete this?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        heroes.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,heroes.size());
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Action for "no" button
                        dialog.cancel();
                        Toast.makeText(context,"Canceled",Toast.LENGTH_SHORT).show();
                    }
                });
                //Creating dialog box
                AlertDialog alert = builder.create();
                alert.setTitle("Are you sure");
                alert.show();
            }
        });

    }

    private void addItem(int position, ViewHolder holder) {

        Hero hero = heroes.get(position);
        holder.txtname.setText(hero.getName());
        holder.txtteam.setText(hero.getTeam());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtname;
        public TextView txtteam;
        public Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_listItem);
            this.txtname = (TextView) itemView.findViewById(R.id.txt_listname);
            this.txtteam = (TextView) itemView.findViewById(R.id.txt_listteam);
            this.btn = (Button) itemView.findViewById(R.id.btn_delete);
        }
    }


}
