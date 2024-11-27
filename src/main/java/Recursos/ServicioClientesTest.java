package Recursos;

import DAOs.IDAOClientes;

public class ServicioClientesTest extends ServicioClientes{


    @Override
    public IDAOClientes getDao() {
        return new MockDAOClientes();
    }
}
