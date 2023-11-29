package es.ull.patrones.observer;

import es.ull.patrones.observer.Observer;

public class PrintObserver implements Observer {
  @Override
  public void update(String data) {
    System.out.println("Inicio");
    System.out.println(data);
    System.out.println("Fin");
  }
}