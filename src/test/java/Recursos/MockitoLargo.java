package Recursos;

import DAOs.IDAOClientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoLargo {

    private IDAOClientes mockito;
    private ServicioClientes servicioClientes;

    @BeforeEach
    void setUp() {
        mockito = mock(IDAOClientes.class);
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(98234, "Juan Pérez", "juan.perez@example.com"));
        clientes.add(new Cliente(58392, "María González", "maria.g@example.com"));
        clientes.add(new Cliente(14756, "Carlos Ramírez", "carlos.ram@example.com"));
        clientes.add(new Cliente(73618, "Laura Rodríguez", "laura.rod@example.com"));
        clientes.add(new Cliente(49502, "Ana Martínez", "ana.mart@example.com"));

        when(mockito.getClientes()).thenReturn(clientes);
        servicioClientes = new ServicioClientes(mockito);

    }

    @Test
    void testMax() {
        int max = servicioClientes.getMaxId().getId();
        assertEquals(98234,max);
        verify(mockito).getClientes();
    }
}

