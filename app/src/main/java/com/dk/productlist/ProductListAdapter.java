package com.dk.productlist;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dk.productlist.R;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private ArrayList<ProductListModel> listData;
    public ProductListAdapter(ArrayList<ProductListModel> listData){
        this.listData=listData;
    }

    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row, viewGroup, false);
        view.setOnClickListener(MainActivity.onClickList);
        ProductListAdapter.ViewHolder viewHolder = new ProductListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( ProductListAdapter.ViewHolder holder, int position) {
        TextView txt_list_name = holder.txt_list_name;
        txt_list_name.setText(""+listData.get(position).getList_item_name());
        TextView txt_list_price = holder.txt_list_price;
        txt_list_price.setText("Rs: "+listData.get(position).getList_item_price());
        TextView txt_list_des = holder.txt_list_des;
        txt_list_des.setText(""+listData.get(position).getList_item_des());
        Log.e("list_value",""+listData.get(position).getList_item_name());
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_list_name,txt_list_price,txt_list_des;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_list_name = (TextView) itemView.findViewById(R.id.txt_list_name);
            this.txt_list_price=(TextView)itemView.findViewById(R.id.txt_list_price);
            this.txt_list_des = (TextView) itemView.findViewById(R.id.txt_list_des);
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
