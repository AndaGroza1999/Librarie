package org.sci.service;

import org.sci.model.Utilizator;
import org.sci.repository.UtilizatorRepo;

public class UtilizatorService {

    private UtilizatorRepo utilizatorRepo;

    public UtilizatorService(UtilizatorRepo utilizatorRepo) {
        this.utilizatorRepo = utilizatorRepo;
    }

    //CRUD

    public Utilizator createUtilizator(Utilizator utilizator) {
        return utilizatorRepo.createUtilizator(utilizator);
    }

    public Utilizator readUtilizator(Utilizator utilizator) {
        return utilizatorRepo.readUtilizator(utilizator);
    }

    public Utilizator updateUtilizator(Utilizator utilizator) {
        return utilizatorRepo.updateUtilizator(utilizator);
    }

    public boolean deleteUtilizator(Utilizator utilizator) {
        return utilizatorRepo.deleteUtilizator(utilizator);
    }
}
