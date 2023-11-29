package es.ull.patrones.api;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSON {

  //ProductData productData;

  public ParseJSON(String data) {
    doParsing(data);
  }

  public void doParsing(String data) {
    JSONArray productsArray = new JSONArray(data);

    // Assuming each item in the array represents a product
    for (int i = 0; i < productsArray.length(); i++) {
      JSONObject productJson = productsArray.getJSONObject(i);
      int favourites = productJson.getInt("favourites");
      // Extract product details from the JSON and create corresponding objects
      if (favourites >= 15) {
        int productId = productJson.getInt("productId");
        String title = productJson.getString("title");
        String url = productJson.getString("url");
        JSONObject price = productJson.getJSONObject("price");
        String totalAmount = price.getString("totalAmount");
        String currency = price.getString("currency");
        // ... (extract other product details)
        System.out.println("Product ID: " + productId);
        System.out.println("Title: " + title);
        System.out.println("URL: " + url);
        System.out.println("Total Amount: " + totalAmount + " " + currency);
        System.out.println("-------------------------");
      }


      // You can do something with the product object, like adding it to a list
      // productList.add(product);
    }

    // If needed, you can create a ProductData object to encapsulate the list of products
    // productData = new ProductData(productList);
  }

  /*public ProductData getProductData() {
    return productData;
  }*/
}
