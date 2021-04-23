package hu.corvinus.beadando.dao;

import java.util.Collection;

public interface BeadandoDao {
    Collection<BeadandoSzoveg> readAll();
    void save(BeadandoSzoveg beadandoSzoveg);
}
