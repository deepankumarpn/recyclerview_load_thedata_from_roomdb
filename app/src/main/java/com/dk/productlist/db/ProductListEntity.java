package com.dk.productlist.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "productlisttable")
public class ProductListEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "itemnumber")
    public int itemNumber;

    @ColumnInfo(name = "productname")
    public String sProductName;

    @ColumnInfo(name = "productdescription")
    public String sProducDescription;

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getsProductName() {
        return sProductName;
    }

    public void setsProductName(String sProductName) {
        this.sProductName = sProductName;
    }

    public String getsProducDescription() {
        return sProducDescription;
    }

    public void setsProducDescription(String sProducDescription) {
        this.sProducDescription = sProducDescription;
    }
}