package com.example.shiva.recyclerviewitemclicklistener;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    List<Model> my_list;
    Context context;

    public CustomAdapter(List<Model> my_list,Context context)
    {
        this.my_list=my_list;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        final Model model=my_list.get(position);
        holder.name.setText(model.getPlayer_name());
        holder.role.setText(model.getPlayer_role());
        holder.image.setImageDrawable(context.getResources().getDrawable(model.getImage()));

        //code for when click on item

        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("name",model.getPlayer_name());
                intent.putExtra("role",model.getPlayer_role());
                context.startActivity(intent);
            }
        });

        // Code end here

    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
{
    ImageView image;
    TextView name,role;
    RelativeLayout relative;
    public MyViewHolder(View itemView) {
        super(itemView);

        image=itemView.findViewById(R.id.image);
        name=itemView.findViewById(R.id.name);
        role=itemView.findViewById(R.id.role);
        relative=itemView.findViewById(R.id.relative);


    }
}

}
