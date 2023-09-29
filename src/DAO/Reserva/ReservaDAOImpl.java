package DAO.Reserva;

import Model.Leitor;
import Model.Livro;
import Model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImpl implements ReservaDAO{

    private ArrayList<Reserva> listReserva;
    private int proxID;

    public ReservaDAOImpl() {
        this.listReserva = new ArrayList<>();
        this.proxID = 0;
    }

    private int getProxID() {
        return this.proxID++;
    }

    @Override
    public Reserva create(Reserva reserva) {
        this.listReserva.add(reserva);
        return reserva;
    }

    @Override
    public void delete(Reserva reserva){
        this.listReserva.remove(reserva);
    }


    @Override
    public Reserva update(Reserva reserva) {
        int index = this.listReserva.indexOf(reserva);
        this.listReserva.set(index, reserva);
        return reserva;
    }

    @Override
    public List<Reserva> findMany() {
        return this.listReserva;
    }

    @Override
    public Reserva findById(int id) {
        for (Reserva reserva : this.listReserva) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

    @Override
    public Reserva findReservas(Leitor leitor, Livro livro) {
        for (Reserva reserva: this.listReserva){
            if(reserva.getLeitor().equals(leitor) && reserva.getLivro().equals(livro) ) {
                return reserva;
            }
        }
        return null;
    }
}
