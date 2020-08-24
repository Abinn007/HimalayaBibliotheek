//package com.bibliotheek.himalaya.service;
//
//import com.bibliotheek.himalaya.model.Medewerker;
//import com.bibliotheek.himalaya.repositories.MedewerkerRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//public class MedewerkerServiceTest {
//
//    @MockBean
//    MedewerkerRepository medewerkerRepository = Mockito.mock(MedewerkerRepository.class);
//
//    MedewerkerService medewerkerService = new MedewerkerService(medewerkerRepository);
//
//    public MedewerkerServiceTest(){
//        super();
//    }
//
//
//    @Test
//    void findGebruikerByGebruikersnaam () {
//        Medewerker medewerker = new Medewerker("B.S.", "Beek","barty","beek12345");
//        Mockito.when(medewerkerService.getMedewerkerByGebruikersnaam(medewerker.getGebruikersnaam())).thenReturn(medewerker);
//        Medewerker actual = medewerkerService.getMedewerkerByGebruikersnaam("barty");
//        assertEquals(medewerker, actual);
//    }
//
//
//
//}
