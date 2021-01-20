package dao;

import bo.custom.impl.MembersBoImpl;
import dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private  DaoFactory(){}
    public static DaoFactory getInstance(){
        return (daoFactory==null)? (daoFactory=new DaoFactory()) : daoFactory;}

    public enum DAOType{
        BOOKS,MEMBERS,ISSUEBOOKS,GUARANTEE,PAYMENT,QUERY,REGISTRATION
    }

    public <T extends SuperDAO> T getDao(DAOType type){
        switch (type){
            case BOOKS:
                return (T) new BooksDAOImpl();
            case MEMBERS:
                return (T) new MembersDAOImpl();
            case GUARANTEE:
                return (T) new GuaranteeDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case QUERY:
                return (T) new QuaryDAOImpl();
            case ISSUEBOOKS:
                return (T) new BorrowDetailDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            default:
                return null;
        }
    }
}
