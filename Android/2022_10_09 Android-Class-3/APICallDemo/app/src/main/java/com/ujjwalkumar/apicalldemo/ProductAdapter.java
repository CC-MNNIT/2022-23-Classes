package com.ujjwalkumar.apicalldemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    ArrayList<Product> al;

    public ProductAdapter(Context context, ArrayList<Product> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_products, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product obj = al.get(position);
        holder.textView1.setText(obj.getTitle());
        holder.textView2.setText(String.valueOf(obj.getPrice()));

        Glide.with(context)
                .load(obj.image)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
