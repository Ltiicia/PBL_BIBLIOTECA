package DAO.Reserva;

import DAO.CRUD;
import Model.Reserva;
import Model.Leitor;
import Model.Livro;

public interface ReservaDAO extends CRUD<Reserva, Exception> {
    public Reserva findReservas(Leitor leitor, Livro livro);

}
