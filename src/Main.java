import es.ull.patrones.gui.MainFrame;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
      /**
   HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://vinted3.p.rapidapi.com/getSearch?country=es&page=1&order=relevance&keyword=the%20last%20of%20us%202&minPrice=15&maxPrice=50"))
            .header("X-RapidAPI-Key", "fea5410740msha9d87817c8480e4p14a43ajsn72b7e0f19839")
            .header("X-RapidAPI-Host", "vinted3.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    // Patrón para encontrar comas fuera de corchetes
    Pattern pattern = Pattern.compile("(?<=\\})(,)(?=\\{|$)");
    //Pattern pattern = Pattern.compile("(?<=\\})(,)(?=\"){0,1}");

    // Utiliza un Matcher para encontrar coincidencias
    Matcher matcher = pattern.matcher(response.body());

    // Usa el método appendReplacement para reemplazar las comas fuera de corchetes
    StringBuffer result = new StringBuffer();
    while (matcher.find()) {
      matcher.appendReplacement(result, "\n");
    }
    matcher.appendTail(result);

    // Imprime el resultado
    System.out.println(result);
     */

    MainFrame mainFrame = new MainFrame();
  }
}


