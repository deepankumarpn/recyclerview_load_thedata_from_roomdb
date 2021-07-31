package com.dk.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dk.productlist.R;

public class ProductDetails extends AppCompatActivity {

    TextView txt_name,txt_price,txt_des;
    Button btn_edit,btn_delete;

    String str_item_number="",str_item_name="",str_item_des="",str_item_price="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        txt_name=findViewById(R.id.txt_name);
        txt_price=findViewById(R.id.txt_price);
        txt_des=findViewById(R.id.txt_des);

        btn_edit=findViewById(R.id.btn_edit);
        btn_delete=findViewById(R.id.btn_delete);

        Intent i = getIntent();
        str_item_number= i.getStringExtra("item_number");
        str_item_name= i.getStringExtra("item_name");
        str_item_des= i.getStringExtra("item_des");
        str_item_price= i.getStringExtra("item_price");

        txt_name.setText(str_item_name);
        txt_price.setText("Rs : "+str_item_price);
        txt_des.setText(str_item_des);


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),ProductAdd.class);
                intent.putExtra("item_number",""+str_item_number);
                intent.putExtra("item_name",""+str_item_name);
                intent.putExtra("item_des",""+str_item_des);
                intent.putExtra("item_price",""+str_item_price);
                intent.putExtra("item_type","edit");
                startActivity(intent);
                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MainActivity.productDb.productListDao().deleteProductList(Integer.parseInt(str_item_number));
                MainActivity.productDb.productPriceDao().deleteProductPrice(Integer.parseInt(str_item_number));
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}