package org.sci.serivceIntegrationTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sci.model.Carte;
import org.sci.repository.CarteRepo;
import org.sci.service.CarteService;

import static org.junit.jupiter.api.Assertions.*;

public class CarteServiceIntegrationTest {
    //testeaza o functionalitate intreaga

    private CarteService carteService;
    private CarteRepo carteRepo;
    private Carte carteIntegrationTest;

    @BeforeEach
    public void init() {
        carteIntegrationTest = new Carte();
        carteIntegrationTest.setNumeCarte("Beautiful Obilivion");
        carteIntegrationTest.setNumeAutor(new String[]{"Jamie McGuire"});
        carteIntegrationTest.setStare(true);
        carteIntegrationTest.setAnApartitie(2014);
        carteIntegrationTest.setNrPagini(320);
        carteIntegrationTest.setId(606717219);
        carteIntegrationTest.setEditura("Atria Books");

        carteRepo = new CarteRepo();
        carteService = new CarteService(carteRepo);

        carteRepo.deleteCarte(carteIntegrationTest);
        assertNull(carteService.readCarte(carteIntegrationTest));
    }

    @Test
    public void createCarteIntegratiopnTest() {
        carteService.createCarte(carteIntegrationTest);
        assertEquals(carteService.readCarte(carteIntegrationTest), carteIntegrationTest); //verifica/vede daca obiectul este in baza de date
    }


}
