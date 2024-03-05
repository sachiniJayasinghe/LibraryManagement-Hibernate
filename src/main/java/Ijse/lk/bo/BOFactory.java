package Ijse.lk.bo;

import Ijse.lk.bo.custom.impl.BookBOImpl;
import Ijse.lk.bo.custom.impl.BranchBOImpl;
import Ijse.lk.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
       USER,Book,Branch
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
            default:
                return null;
        }
    }
}
