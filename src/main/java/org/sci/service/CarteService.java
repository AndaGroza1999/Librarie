package org.sci.service;

import org.sci.model.Carte;
import org.sci.repository.CarteRepo;

public class CarteService {

    private CarteRepo carteRepo;

    public CarteService(CarteRepo carteRepo) {
        this.carteRepo = carteRepo;
    }

    //CRUD - Create, Read, Update, Delete

    public Carte createCarte(Carte carte) {
        //transformam in DTO
        return carteRepo.createCarte(carte/*DTO*/);
        //transforma DTO-ul in model si return
    } //apeleaza createCarte din repository(vezi packege ul)

    public Carte readCarte(Carte carte) {
        return carteRepo.readCarte(carte);
    }

    public Carte updateCarte(Carte carte) {
        return carteRepo.updateCarte(carte);
    }

    public boolean deleteCarte(Carte carte) {
        return carteRepo.deleteCarte(carte);
    }
}
