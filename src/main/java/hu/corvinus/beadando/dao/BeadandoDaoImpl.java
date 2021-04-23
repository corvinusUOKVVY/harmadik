package hu.corvinus.beadando.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BeadandoDaoImpl implements BeadandoDao {

    private final List<BeadandoSzoveg> beadandoSzovegList = new ArrayList<>();

    @Override
    public Collection<BeadandoSzoveg> readAll() {
        return beadandoSzovegList;
    }

    @Override
    public void save(BeadandoSzoveg beadandoSzoveg) {
        beadandoSzovegList.add(beadandoSzoveg);
    }
}
