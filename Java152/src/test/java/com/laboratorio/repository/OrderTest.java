package com.laboratorio.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @TestMethodOrder(MethodOrderer.Random.class)
// @TestMethodOrder(MethodOrderer.MethodName.class)
// @TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(CustomOrderer.class)
public class OrderTest {
    private static Logger log = LogManager.getFormatterLogger(OrderTest.class);
    
    @Test
    @DisplayName("01")
    public void prueba5() {
        log.info("Ejecución de la prueba 5");
        Assertions.assertTrue(true);
    }
    
    @Test
    @DisplayName("03")
    public void prueba1() {
        log.info("Ejecución de la prueba 1");
        Assertions.assertTrue(true);
    }
    
    @Test
    @DisplayName("04")
    public void prueba2() {
        log.info("Ejecución de la prueba 2");
        Assertions.assertTrue(true);
    }
    
    @Test
    @DisplayName("05")
    public void prueba3() {
        log.info("Ejecución de la prueba 3");
        Assertions.assertTrue(true);
    }
    
    @Test
    @DisplayName("02")
    public void prueba4() {
        log.info("Ejecución de la prueba 4");
        Assertions.assertTrue(true);
    }
}