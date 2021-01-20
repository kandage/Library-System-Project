package bo;

import bo.custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return (boFactory==null)? (boFactory=new BoFactory()) : boFactory;
    }
    public enum BOType{
        BOOKS,MEMBERS,ISSUEBOOKS,GUARANTEE,PAYMENT,REGISTRATION, ADDREG
    }

    public <T extends SuperBO> T getBo(BoFactory.BOType type){
        switch (type){
            case BOOKS:
                return (T) new BooksBoImpl();
            case ISSUEBOOKS:
                return (T) new BorrowDetailBoImpl();
            case MEMBERS:
                return (T) new MembersBoImpl();
            case GUARANTEE:
                return (T) new GuaranteeBoImpl();
            case PAYMENT:
                return (T) new PaymentBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBoImpl();
            case ADDREG:
                return (T) new AddRegistrationBoImpl();
            default:
                return null;
        }
    }
}
