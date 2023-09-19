package DAO;

import DAO.Book.BookDAO;
import DAO.Book.BookDaoImpl;
import DAO.User.UserDAO;
import DAO.User.UserDaoImpl;
import DAO.loan.LoanDAO;
import DAO.loan.LoanDAOImpl;

public class DAO {
    private static BookDAO bookDAO;
    private static UserDAO userDAO;
    private static LoanDAO loanDAO;

    public static BookDAO getBookDAO(){
        if (bookDAO == null) {
            bookDAO = new BookDaoImpl();
        }
        return bookDAO;
    }

    public static UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDaoImpl();
        }
        return userDAO;
    }

    public static LoanDAO getLoanDAO() {
        if(loanDAO == null) {
            loanDAO = new LoanDAOImpl();
        }
        return loanDAO;
    }

}
