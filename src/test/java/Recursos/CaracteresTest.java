package Recursos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaracteresTest {

    private ServicioClientesTest servicioClientes;

    @BeforeEach
    void setUp() {
        servicioClientes = new ServicioClientesTest();
        MockDAOClientes.getInstance().getClientes();
    }

    @Test
    void TestMax() {
        int max = servicioClientes.nCaracteresNCompleto();
        assertEquals(15,max);
    }


}