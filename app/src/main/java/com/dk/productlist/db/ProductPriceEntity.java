package com.dk.productlist.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "productpricetable")
public class ProductPriceEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "itemnumber")
    public int itemNumber;

    @ColumnInfo(name = "productprice")
    public int iProductPrice;

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getiProductPrice() {
        return iProductPrice;
    }

    public void setiProductPrice(int iProductPrice) {
        this.iProductPrice = iProductPrice;
    }
}
