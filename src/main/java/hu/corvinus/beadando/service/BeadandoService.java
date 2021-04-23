package hu.corvinus.beadando.service;

import java.util.Collection;

public interface BeadandoService {
    void record(BeadandoSzoveg beadandoSzoveg) throws Exception;
    Collection<BeadandoSzoveg> getAll();
}
