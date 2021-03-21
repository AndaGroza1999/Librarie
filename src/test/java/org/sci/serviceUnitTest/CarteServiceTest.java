package org.sci.serviceUnitTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.sci.model.Carte;
import org.sci.repository.CarteRepo;
import org.sci.service.CarteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarteServiceTest {
    //testeaza o metoda
    private CarteRepo carteRepoMock;
    private Carte c;
    private CarteService carteService;

    @BeforeAll
    public void initializare() {
        //carteRepo = new CarteRepo();
        carteRepoMock = mock(CarteRepo.class);

        c = new Carte();
        c.setNumeCarte("Beautiful Obilivion");
        c.setNumeAutor(new String[]{"Jamie McGuire"});
        c.setStare(true);
        c.setAnApartitie(2014);
        c.setNrPagini(320);
        c.setId(606717219);
        c.setEditura("Atria Books");

        when(carteRepoMock.createCarte(anyObject())).thenReturn(c);

        carteService = new CarteService(carteRepoMock);
    }

    @Test
    public void createCarteTest() {
        //assertNotNull(verify(carteRepoMock, times(1)).createCarte(c));
        carteService.createCarte(c);
        verify(carteRepoMock, times(1)).createCarte(anyObject());
        //assertEquals(null, true);
    }

    @Test
    public void readCarteTest() {
        assertEquals(true, false);
    }

    @Test
    public void updateCarteTest() {
        assertEquals(true, true);
    }

    @Test
    public void deleteCarteTest() {
        assertEquals(true, true);
    }
}
