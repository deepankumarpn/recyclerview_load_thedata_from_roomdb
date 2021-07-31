package com.dk.productlist.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ProductPriceDao {

    @Insert
    public void insertProductPrice(ProductPriceEntity productPriceEntity);

    @Query("select * from productpricetable")
    public List<ProductPriceEntity> getProductPrice();

    @Query("UPDATE productpricetable SET productprice = :product_price WHERE itemnumber = :item_number")
    void updateProductPrice(int item_number, int product_price);

    @Query("DELETE FROM productpricetable WHERE itemnumber =:item_number")
    void deleteProductPrice(int item_number);

}
