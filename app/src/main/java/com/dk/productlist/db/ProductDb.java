package com.dk.productlist.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {ProductPriceEntity.class,ProductListEntity.class},version = 1, exportSchema = false)
public abstract class ProductDb extends RoomDatabase {

    public abstract ProductPriceDao productPriceDao();
    public abstract ProductListDao productListDao();

    private static volatile ProductDb productDbInstance;
    public static ProductDb getDatabase(final Context context) {
        if (productDbInstance == null) {
            synchronized (ProductDb.class) {
                if (productDbInstance == null) {
                    productDbInstance = Room.databaseBuilder(context.getApplicationContext(),
                            ProductDb.class, "product")
                            .build();
                }
            }
        }
        return productDbInstance;
    }
}
