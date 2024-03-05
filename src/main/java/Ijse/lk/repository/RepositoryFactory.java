package Ijse.lk.repository;

import Ijse.lk.bo.custom.impl.UserBOImpl;
import Ijse.lk.repository.custom.impl.BookRepositoryImpl;
import Ijse.lk.repository.custom.impl.BranchRepositoryImpl;
import Ijse.lk.repository.custom.impl.UserRepositoryImpl;

public class RepositoryFactory {
    private static RepositoryFactory daoFactory;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new RepositoryFactory() : daoFactory;
    }

    public enum DAOTypes {
        USER,BOOK,Branch
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserRepositoryImpl();
            case BOOK:
                return new BookRepositoryImpl();
            case Branch:
                return new BranchRepositoryImpl();
            default:
                return null;
        }
    }

}
