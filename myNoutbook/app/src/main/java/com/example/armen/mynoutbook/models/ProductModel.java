package com.example.armen.mynoutbook.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductModel {
    private String title;
    private String category;
    private String description;
    private List<String> imageUrl;
    private String price;
    private boolean favorite;
    private boolean cardBy;


    public ProductModel() {
    }

    public ProductModel(List<String> imageUrl,String title, String category, String price, String description, boolean favorite, boolean cardBy) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.favorite = favorite;
        this.cardBy = cardBy;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCardBy() {
        return cardBy;
    }

    public void setCardBy(boolean cardBy) {
        this.cardBy = cardBy;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {

        this.imageUrl = imageUrl;
    }
}
