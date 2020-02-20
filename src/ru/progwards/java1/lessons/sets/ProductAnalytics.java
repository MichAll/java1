package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;
//- список всех имеющихся в ассортименте товаров.
// Все товары, присутствующие в магазинах, обязательно присутствуют в products,
// но так же тут могут быть и товары, которых нет в магазинах

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    //  - товары из products, которые имеются во всех магазинах
    public Set<Product> existInAll() {
        HashSet result = new HashSet(products);
        for (Shop shop : shops)
            result.retainAll(shop.getProducts());
        return result;
    }

    //- товары из products, которые имеются хотя бы в одном магазине
    public Set<Product> existAtListInOne() {
        HashSet result = new HashSet();
        for (Shop shop : shops)
            result.addAll(shop.getProducts());
        return result;
    }

    // - товары из products, которых нет ни в одном магазине
    public Set<Product> notExistInShops() {
        HashSet result = new HashSet(products);
        for (Shop shop : shops)
            result.removeAll(shop.getProducts());
        return result;
    }

    //  - товары из products, которые есть только в одном магазине
    public Set<Product> existOnlyInOne() {
        HashSet result = new HashSet();
        HashSet result1 = new HashSet();

        for (Product product : products) {
            int i = 0;
            for (Shop shop : shops){
                if (shop.getProducts().contains(product))
                    i++;
            }
            if (i == 1)
                result.add(product);
        }
        return result;
    }

    public static void main(String[] args) {
        Product prod0 = new Product("p0");
        Product prod1 = new Product("p1");
        Product prod2 = new Product("p2");
        Product prod3 = new Product("p3");
        Product prod4 = new Product("p4");
        Product prod5 = new Product("p5");
        Product prod6 = new Product("p6");
        Product prod7 = new Product("p7");
        Product prod8 = new Product("p8");
        Product prod9 = new Product("p9");
        Product prod10 = new Product("pp");


        List<Product> abc = new ArrayList<>();
        abc.add(prod0);
        abc.add(prod2);
        abc.add(prod4);
        abc.add(prod6);
        abc.add(prod8);

        List<Product> bbc = new ArrayList<>();
        bbc.add(prod0);
        bbc.add(prod1);
        bbc.add(prod3);
        bbc.add(prod5);
        bbc.add(prod7);
        bbc.add(prod9);

        List<Product> acdc = new ArrayList<>();
        acdc.add(prod0);
        acdc.add(prod1);
        acdc.add(prod3);
        acdc.add(prod8);

        List<Product> r2d2 = new ArrayList<>();
        r2d2.add(prod0);
        r2d2.add(prod1);
        r2d2.add(prod2);
        r2d2.add(prod3);
        r2d2.add(prod4);
        r2d2.add(prod5);


        Shop shop1 = new Shop(abc);
        Shop shop2 = new Shop(bbc);
        Shop shop3 = new Shop(acdc);
        Shop shop4 = new Shop(r2d2);


        List<Product> products = new ArrayList<>();
        products.add(prod0);
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);
        products.add(prod5);
        products.add(prod6);
        products.add(prod7);
        products.add(prod8);
        products.add(prod9);
        products.add(prod10);

        List<Shop> shops = new ArrayList<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);
        shops.add(shop4);

        ProductAnalytics prodAnal = new ProductAnalytics(products, shops);
        //System.out.println(prodAnal.existInAll().size());
        //System.out.println(prodAnal.existAtListInOne().size());
        //System.out.println(prodAnal.notExistInShops().size());
        System.out.println(prodAnal.existOnlyInOne().size());
    }
}
