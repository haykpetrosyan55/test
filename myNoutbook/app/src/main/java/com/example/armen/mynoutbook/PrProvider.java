package com.example.armen.mynoutbook;


import android.content.res.Resources;

import com.example.armen.mynoutbook.models.ProductModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrProvider {


//    public static String[] setResources() {
//        String[] tag;
//        tag = Resources.getSystem().getStringArray(R.array.myarr);
//        return tag;
//    }

    private static List<ProductModel> prList = new ArrayList<>();

    public static List<ProductModel> getPrList() {
        if (!prList.isEmpty()) {
            prList.clear();
        }
        List<String> myList = new ArrayList<String>();
        myList.add("https://i2.rozetka.ua/goods/1867275/acer_predator_21_x_images_1867275662.jpg");
        myList.add("https://www.bhphotovideo.com/images/images2500x2500/asus_gx501gi_xs74_15_6_republic_of_gamers_1398349.jpg");
//        prList.add(new ProductModel("MSI GS63", "MSI", "1490","Latest 8th Gen. Intel® Core™ i7 processor Windows 10 Home / Windows 10 Pro Ultra slim 15.6'' gaming notebook", new ArrayList<String>().add("https://gamehall.com.ua/wp-content/uploads/2018/04/MSI-GS63-8RF-Stealth-3.jpg"), false, false));
        prList.add(new ProductModel(myList,"Acer Predator x21", "Predator", "2000", "esim inch hla vor", false, false));
//        prList.add(new ProductModel("Asus", "rog", "2899", "esim inch hla vor", new ArrayList<String>(){"https://www.bhphotovideo.com/images/images2500x2500/asus_gx501gi_xs74_15_6_republic_of_gamers_1398349.jpg"}, false, false));
//        prList.add(new ProductModel("Gigabyte Aero 15X v8-BK4", "gig", "$2299", "", new ArrayList<String>(){"https://www.bhphotovideo.com/images/images2500x2500/gigabyte_15_6_aero_15x_v8_bk4_1400601.jpg","https://www.bhphotovideo.com/images/images2500x2500/gigabyte_15_6_aero_15w_v8_bk4_1400597.jpg"}, false, false));
//        prList.add(new ProductModel("Apple macBook Pro 2018", "apple", "3899", "esim inch hla vor", new ArrayList<String>(){"https://www.bhphotovideo.com/images/images2500x2500/apple_z0v0_mr9357_bh_macbook_pro_i9_2_9g_1423790.jpg"}, false, false));
//        prList.add(new ProductModel("Razer Blade", "razer", "3899", "esim inch hla vor", new ArrayList<String>(){"https://www.bhphotovideo.com/images/images2500x2500/razer_rz09_01172e51_r3u1_17_pro_gaming_lt_256gb_1172147.jpg"}, false, false));
        Collections.shuffle(prList);
        return prList;
    }

    public static List<ProductModel> getListByCategory(String category) {
        List<ProductModel> listByCategory = new ArrayList<>();
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).getCategory().equals(category)) {
                listByCategory.add(prList.get(i));
            }

        }
        return listByCategory;
    }

    public static List<ProductModel> getListByFavorite() {
        List<ProductModel> favoriteList = new ArrayList<>();
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).isFavorite()) {
                favoriteList.add(prList.get(i));
            }
        }
        return favoriteList;
    }

    public static List<ProductModel> getListByCard() {
        List<ProductModel> cardList = new ArrayList<>();
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).isCardBy()) {
                cardList.add(prList.get(i));
            }
        }
        return cardList;
    }

    public static ProductModel getIntPosition(int position) {
        return prList.get(position);
    }
}
