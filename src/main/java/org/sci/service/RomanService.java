package org.sci.service;

import org.sci.model.Utilizator;
import org.sci.newModel.Roman;
import org.sci.repository.RomanRepo;

public class RomanService {

    private RomanRepo romanRepo;

    public RomanService(RomanRepo romanRepo) {
        this.romanRepo = romanRepo;
    }

    //CRUD

    public Roman createRoman(Roman roman) {
        return romanRepo.createRoman(roman);
    }

    public Roman readRoman(Roman roman) {
        return romanRepo.readRoman(roman);
    }

    public Roman updateRoman(Roman roman) {
        return romanRepo.updateRoman(roman);
    }

    public boolean deleteRoman(Roman roman) {
        return romanRepo.deleteRoman(roman);
    }
}
