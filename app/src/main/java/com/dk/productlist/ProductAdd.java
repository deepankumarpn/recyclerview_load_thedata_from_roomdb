package com.dk.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dk.productlist.db.ProductListEntity;
import com.dk.productlist.db.ProductPriceEntity;
import com.google.android.material.textfield.TextInputEditText;
import com.dk.productlist.R;

public class ProductAdd extends AppCompatActivity {
    int i_int_number;
    String str_item_number="",str_item_name="",str_item_des="",str_item_price="",str_item_type="";

    Button btn_save;
    TextInputEditText et_des,et_price,et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        Intent i = getIntent();
        str_item_number= i.getStringExtra("item_number");
        str_item_name= i.getStringExtra("item_name");
        str_item_des= i.getStringExtra("item_des");
        str_item_price= i.getStringExtra("item_price");
        str_item_type= i.getStringExtra("item_type");

        btn_save=findViewById(R.id.btn_save);
        et_des=findViewById(R.id.et_des);
        et_price=findViewById(R.id.et_price);
        et_name=findViewById(R.id.et_name);

        et_name.setText(str_item_name);
        et_price.setText(str_item_price);
        et_des.setText(str_item_des);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(str_item_type.equals("add")){
                    ProductListEntity productListEntity= new ProductListEntity();
                    ProductPriceEntity productPriceEntity= new ProductPriceEntity();
                    productListEntity.setsProductName(""+et_name.getText().toString());
                    productListEntity.setsProducDescription(""+et_des.getText().toString());
                    productPriceEntity.setiProductPrice(Integer.parseInt(et_price.getText().toString()));
                    MainActivity.productDb.productListDao().insertProductList(productListEntity);
                    MainActivity.productDb.productPriceDao().insertProductPrice(productPriceEntity);

                    Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }else if(str_item_type.equals("edit")){

                    MainActivity.productDb.productListDao().updateProductList(Integer.parseInt(str_item_number),
                            et_name.getText().toString(),
                            et_des.getText().toString());
                    MainActivity.productDb.productPriceDao().updateProductPrice(Integer.parseInt(str_item_number) ,
                            Integer.parseInt(et_price.getText().toString()) );

                    Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });
    }
}