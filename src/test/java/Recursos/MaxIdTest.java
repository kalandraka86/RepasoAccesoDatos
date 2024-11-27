package Recursos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxIdTest {


    private ServicioClientesTest servicioClientes;

    @BeforeEach
    void setUp() {
        servicioClientes = new ServicioClientesTest();
        MockDAOClientes.getInstance().getClientes();
    }



    @Test
    void TestMax() {
        int max = servicioClientes.getMaxId().getId();
        assertEquals(98234,max);
    }
}