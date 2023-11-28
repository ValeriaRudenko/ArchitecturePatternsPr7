package es.ull.patrones.observer;

import es.ull.patrones.api.ParseJSON;

import es.ull.patrones.api.VintedApiSubject;

public interface Observer {
  void update(String data);
}
