package Ijse.lk.repository;

import Ijse.lk.bo.custom.impl.UserBOImpl;
import Ijse.lk.repository.custom.impl.*;

public class RepositoryFactory {
    private static RepositoryFactory daoFactory;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new RepositoryFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER,BOOK,Branch,Admin,Borrowing
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserRepositoryImpl();
            case BOOK:
                return new BookRepositoryImpl();
            case Branch:
                return new BranchRepositoryImpl();
            case Admin:
                return new AdminRepositoryImpl();
            case Borrowing:
                return new BorrowingRepositoryImpl();
            default:
                return null;
        }
    }

}
