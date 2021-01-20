package bo.custom.impl;

import bo.custom.PaymentBO;
import dao.DaoFactory;
import dao.custom.MembersDAO;
import dao.custom.PaymentDAO;
import dto.BooksDTO;
import dto.PaymentDTO;
import entity.Books;
import entity.Members;
import entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO dao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.PAYMENT);
    @Override
    public boolean savePayment(PaymentDTO dto) throws Exception {
        return dao.save(new Payment(dto.getPayID(),dto.getRegId(),dto.getAmount(),dto.getPDate(),dto.getPayType()));
    }


    @Override
    public boolean updatePayment(PaymentDTO dto) throws Exception {
        return dao.update(new Payment(dto.getPayID(),dto.getRegId(),dto.getAmount(),dto.getPDate(),dto.getPayType()));
    }

    @Override
    public boolean deletePayment(String PayID) throws Exception {
        return dao.delete(PayID);
    }


    @Override
    public PaymentDTO gettPayment(String PayID) throws Exception {
        Payment p=dao.get(PayID);
        return new PaymentDTO(p.getPayID(),p.getRegId(),p.getAmount(),p.getPDate(),p.getPayType());
    }


    @Override
    public ArrayList<PaymentDTO> getAllPayment() throws Exception {
        List<Payment> bList = dao.getAll();
        ArrayList<PaymentDTO> dtoList = new ArrayList();
        for (Payment p : bList) {
            dtoList.add(new PaymentDTO(p.getPayID(),p.getRegId(),p.getAmount(),p.getPDate(),p.getPayType()));
        }
        return dtoList;
    }
}
