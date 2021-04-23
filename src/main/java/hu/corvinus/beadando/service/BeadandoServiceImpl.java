package hu.corvinus.beadando.service;

import hu.corvinus.beadando.dao.BeadandoDao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class BeadandoServiceImpl implements BeadandoService {

    private final BeadandoDao beadandoDao;

    public BeadandoServiceImpl(BeadandoDao beadandoDao) {
        this.beadandoDao = beadandoDao;
    }

    @Override
    public void record(BeadandoSzoveg beadandoSzoveg) throws Exception {
        Collection<BeadandoSzoveg> all = getAll();
        for (BeadandoSzoveg szoveg: all) {
            if (szoveg.equals(beadandoSzoveg)){
                throw new Exception();
            }
        }
        beadandoDao.save(
                new hu.corvinus.beadando.dao.BeadandoSzoveg.Builder()
                        .szoveg(beadandoSzoveg.getSzoveg())
                        .build());
    }

    @Override
    public Collection<BeadandoSzoveg> getAll() {
        return beadandoDao.readAll().stream().map(
                daoBeadando -> new BeadandoSzoveg.Builder()
                        .szoveg(daoBeadando.getSzoveg())
                        .build())
                .collect(Collectors.toList());
    }
}
