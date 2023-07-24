package com.izdeveloper.wishlistappv2;

public class Article {

    private String itemName, itemDescription;
    private long timeOfAddition;
    private boolean star;

    public Article(String itemName, String itemDescription, boolean star) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.star = star;
        this.timeOfAddition = System.currentTimeMillis();
    }

    public Article(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public long getTimeOfAddition() {
        return timeOfAddition;
    }

    public boolean isStar() {
        return star;
    }

}
