package Ijse.lk.bo;

import Ijse.lk.bo.custom.impl.*;
import Ijse.lk.repository.custom.impl.BranchRepositoryImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
       USER,Book,Branch,Admin,Borrowing,Login
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case USER:
                return new UserBOImpl();
            case Book:
                return new BookBOImpl();
            case Branch:
                return new BranchBOImpl();
            case Admin:
                return new AdminBOImpl();
            case Borrowing:
                return new BorrowingBOImpl();
            case Login:
                return new LoginBOImpl();
            default:
                return null;
        }
    }
}
