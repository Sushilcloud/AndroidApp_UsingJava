package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Model> my_list;
    Context context;

    public CustomAdapter(List<Model> my_list, Context context) {
        this.my_list = my_list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        Model model=my_list.get(position);
        holder.name.setText(model.getPlayer_name());
        holder.role.setText(model.getPlayer_role());
        holder.image.setImageDrawable(context.getResources().getDrawable(model.getImage()));

    }

    @Override
    public int getItemCount() {
        return my_list_size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name,role;
        public MyViewHolder( View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            role=itemView.findViewById(R.id.role);
        }
    }
}
