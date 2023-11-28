package es.ull.patrones.api;

import es.ull.patrones.observer.Observer;
import es.ull.patrones.observer.PrintObserver;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class VintedApiSubject {
  String data;
  private List<Observer> observers = new ArrayList<>();

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void notifyObservers(String data) {
    for (Observer observer : observers) {
      observer.update(data);
    }
  }

  // Método que realiza la solicitud HTTP y procesa la respuesta
  public void fetchData(int pagina, String objeto,int precioMin,int precioMax) {
    try {
      String obj = convertir(objeto);
      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create("https://vinted3.p.rapidapi.com/getSearch?country=es&page="+pagina+"&order=relevance&keyword="+obj+"&minPrice="+precioMin+"&maxPrice="+precioMax))
              .header("X-RapidAPI-Key", "fea5410740msha9d87817c8480e4p14a43ajsn72b7e0f19839")
              .header("X-RapidAPI-Host", "vinted3.p.rapidapi.com")
              .method("GET", HttpRequest.BodyPublishers.noBody())
              .build();
      HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      // Notifica a los observadores con los datos procesados
      //System.out.println(response.body()); Muestra la lista de objetos
      data = response.body();
      new ParseJSON(data);
      //notifyObservers(result.toString());

    } catch (InterruptedException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String convertir(String objeto) {
    String obj = objeto.replace(" ", "%20");
    System.out.println(obj);
    return obj;
  }
}
