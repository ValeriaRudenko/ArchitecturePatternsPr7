package es.ull.patrones.observer;

import es.ull.patrones.api.Product;
import es.ull.patrones.gui.ProductFrame;
import javax.swing.*;
import java.util.List;

public class PrintObserver implements Observer {
  @Override
  public void update(List<Product> productList) {
    SwingUtilities.invokeLater(() -> {
      ProductFrame productFrame = new ProductFrame(productList);
    });
  }
}