package es.ull.patrones.api;

public class Product {
  private int productId;
  private String title;
  private String url;
  private int favourites;
  private String totalAmount;
  private String currency;

  // Constructor
  public Product(int productId, String title, String url, int favourites, String totalAmount, String currency) {
    this.productId = productId;
    this.title = title;
    this.url = url;
    this.favourites = favourites;
    this.totalAmount = totalAmount;
    this.currency = currency;
  }

  // Getters
  public int getProductId() {
    return productId;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public int getFavourites() {
    return favourites;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  public String getCurrency() {
    return currency;
  }

  // Setters
  public void setProductId(int productId) {
    this.productId = productId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setFavourites(int favourites) {
    this.favourites = favourites;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}

