package com.dk.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dk.productlist.db.ProductPriceEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.dk.productlist.R;
import com.dk.productlist.db.ProductDb;
import com.dk.productlist.db.ProductListEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ProductDb productDb;
    FloatingActionButton fab;

    private static RecyclerView.Adapter listAdapter;
    RecyclerView rv_recycle_view;
    RecyclerView.LayoutManager  layoutManager;
    static View.OnClickListener onClickList;

    private static ArrayList<ProductListModel> listData;

    ArrayList<String> arrayItemNumber =null;
    ArrayList<String> arrayProductPrice =null;
    ArrayList<String> arrayProductName= null ;
    ArrayList<String> arrayProductDes =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productDb = Room.databaseBuilder(getApplicationContext(),ProductDb.class,"product")
                .allowMainThreadQueries().build();

        fab=findViewById(R.id.fab);

        arrayItemNumber = new ArrayList<String>();
        arrayProductPrice = new ArrayList<String>();
        arrayProductName = new ArrayList<String>();
        arrayProductDes = new ArrayList<String>();

        List<ProductListEntity> getProductList = MainActivity.productDb.productListDao().getProductList();
        List<ProductPriceEntity> getProductPrice = MainActivity.productDb.productPriceDao().getProductPrice();
        if(getProductList.size() != 0 &&getProductPrice.size()!= 0){
            for (ProductListEntity productListEntity : getProductList){
                arrayItemNumber.add(String.valueOf(productListEntity.getItemNumber()));
                arrayProductName.add(productListEntity.getsProductName());
                arrayProductDes.add(productListEntity.getsProducDescription());
                Log.e("get_value",""+productListEntity.getsProductName()+""
                        +productListEntity.getsProducDescription()+""+
                        String.valueOf(productListEntity.getItemNumber())+"");
            }
            for (ProductPriceEntity productPriceEntity : getProductPrice){
                arrayProductPrice.add(String.valueOf(productPriceEntity.getiProductPrice()));
            }
        }else{
            Toast.makeText(this, "Empty Data..", Toast.LENGTH_SHORT).show();
        }

        onClickList= new ListPreview(getApplicationContext());
        rv_recycle_view=findViewById(R.id.rv_recycle_view);
        rv_recycle_view.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        rv_recycle_view.setLayoutManager(layoutManager);
        rv_recycle_view.setItemAnimator(new DefaultItemAnimator());

        listData = new ArrayList<ProductListModel>();
        for (int i = 0; i < arrayItemNumber.size(); i++) {
            listData.add(new ProductListModel(
                    arrayItemNumber.get(i),arrayProductPrice.get(i),arrayProductName.get(i),arrayProductDes.get(i)
            ));
        }
        listAdapter = new ProductListAdapter(listData);

        rv_recycle_view.setAdapter(listAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),ProductAdd.class);
                intent.putExtra("item_type","add");
                startActivity(intent);
            }
        });
    }

    private  class ListPreview implements View.OnClickListener {
        private final Context context;
        private ListPreview(Context context) {
            this.context = context;
        }
        @Override
        public void onClick(View v) {
            removeItem(v);
        }
        private void removeItem(View v) {
            int iPos = rv_recycle_view.getChildAdapterPosition(v);

            Intent intent =new Intent(getApplicationContext(),ProductDetails.class);
            intent.putExtra("item_number",""+arrayItemNumber.get(iPos));
            intent.putExtra("item_name",""+arrayProductName.get(iPos));
            intent.putExtra("item_des",""+arrayProductDes.get(iPos));
            intent.putExtra("item_price",""+arrayProductPrice.get(iPos));
            startActivity(intent);
        }
    }
}