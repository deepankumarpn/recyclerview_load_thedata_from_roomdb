package com.dk.productlist.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductListDao {
    @Insert
    public void insertProductList(ProductListEntity productListEntity);

    @Query("select * from productlisttable")
    public List<ProductListEntity> getProductList();

    @Query("UPDATE productlisttable SET productname = :product_name,productdescription = :product_des" +
            " WHERE itemnumber = :item_number")
    void updateProductList(int item_number, String product_name,String product_des);

    @Query("DELETE FROM productlisttable WHERE itemnumber =:item_number")
    void deleteProductList(int item_number);
}
