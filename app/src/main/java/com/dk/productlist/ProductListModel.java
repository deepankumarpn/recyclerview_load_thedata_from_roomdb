package com.dk.productlist;

public class ProductListModel {
    String list_item_number;
    String list_item_price;
    String list_item_name;
    String list_item_des;

    public ProductListModel(String list_item_number, String list_item_price, String list_item_name, String list_item_des) {
        this.list_item_number = list_item_number;
        this.list_item_price = list_item_price;
        this.list_item_name = list_item_name;
        this.list_item_des = list_item_des;
    }

    public String getList_item_number() {
        return list_item_number;
    }

    public void setList_item_number(String list_item_number) {
        this.list_item_number = list_item_number;
    }

    public String getList_item_price() {
        return list_item_price;
    }

    public void setList_item_price(String list_item_price) {
        this.list_item_price = list_item_price;
    }

    public String getList_item_name() {
        return list_item_name;
    }

    public void setList_item_name(String list_item_name) {
        this.list_item_name = list_item_name;
    }

    public String getList_item_des() {
        return list_item_des;
    }

    public void setList_item_des(String list_item_des) {
        this.list_item_des = list_item_des;
    }
}
