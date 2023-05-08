package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import models.Product;

public class ReadCategoryProduct {
    
     //準備好產品清單  
    public static TreeMap<String, Product> readProduct() {
        //read_product_from_file(); //從檔案或資料庫讀入產品菜單資訊
        //放所有產品  產品編號  產品物件
        TreeMap<String, Product> product_dict = new TreeMap();
            ArrayList<String[]> product_array = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/information/product_information.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                product_array.add(item);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


{



        //一筆放入字典變數product_dict中
        for (String[] item : product_array) {
            Product product = new Product(
                    item[0], 
                    item[1], 
                    item[2], 
                    Integer.parseInt(item[3]), //價格轉為int
                    item[4], 
                    item[5]);
            //將這一筆放入字典變數product_dict中 
            product_dict.put(product.getProduct_id(), product);
        }
        return product_dict; 
    }
}
}
