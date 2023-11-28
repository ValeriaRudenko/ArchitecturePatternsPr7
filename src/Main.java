import es.ull.patrones.api.VintedApiSubject;
import es.ull.patrones.api.ParseJSON;
import es.ull.patrones.observer.Observer;
import es.ull.patrones.observer.PrintObserver;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese la página: ");
    int pagina = scanner.nextInt();
    System.out.print("Ingrese el precio mínimo: ");
    int precioMin = scanner.nextInt();

    System.out.print("Ingrese el precio máximo: ");
    int precioMax = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el objeto a buscar: ");
    String objeto = scanner.nextLine();

    // Crear instancia del sujeto
    VintedApiSubject vintedApiSubject = new VintedApiSubject();

    // Crear instancia del observador
    Observer printObserver = new PrintObserver();

    // Agregar el observador al sujeto
    vintedApiSubject.addObserver(printObserver);
    System.out.println("pagina: " + pagina + "\nprecio min: " + precioMin + "\nprecio max: " + precioMax + "\nArticulo: " + objeto);
    // Realizar la solicitud HTTP y notificar a los observadores
    vintedApiSubject.fetchData(pagina, objeto, precioMin, precioMax);
  }
}


