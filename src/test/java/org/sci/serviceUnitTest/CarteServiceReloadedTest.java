package org.sci.serviceUnitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sci.model.Carte;
import org.sci.repository.CarteRepo;
import org.sci.service.CarteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CarteServiceReloadedTest {

    @Mock
    private CarteRepo carteRepoMock;

    private Carte c;

    @InjectMocks
    private CarteService carteService;


    @BeforeEach
    public void initializare() {

        c = new Carte();
        c.setNumeCarte("Beautiful Obilivion");
        c.setNumeAutor(new String[]{"Jamie McGuire"});
        c.setStare(true);
        c.setAnApartitie(2014);
        c.setNrPagini(320);
        c.setId(606717219);
        c.setEditura("Atria Books");

        when(carteRepoMock.createCarte(anyObject())).thenReturn(c);
    }

    @Test
    public void createCarteTest() {
        assertEquals(carteService.createCarte(c), c);
        verify(carteRepoMock, times(1)).createCarte(anyObject());
    }
}
