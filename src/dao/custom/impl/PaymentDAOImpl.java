package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.Books;
import entity.Payment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment) throws Exception {
        return CrudUtil.execute("INSERT INTO Payment VALUES (?,?,?,?,?)",
                payment.getPayID(),payment.getRegId(),payment.getAmount(),payment.getPDate(),payment.getPayType());
    }
    @Override
    public boolean update(Payment payment) throws Exception {
        return CrudUtil.execute("UPDATE Payment SET RegId=?, Amount=?, PDate=?, PayType=? WHERE PayID=?",
                payment.getRegId(),payment.getAmount(),payment.getPDate(),payment.getPayType(),payment.getPayID());
    }


    @Override
    public boolean delete(String PayID) throws Exception {
        return CrudUtil.execute("DELETE FROM Payment WHERE PayID=?",PayID);
    }

    @Override
    public Payment get(String PayID) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Payment WHERE PayID=?",PayID);
        if (resultSet.next()) {
            return new Payment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<Payment> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Payment");
        ArrayList<Payment> payments = new ArrayList<>();
        while (resultSet.next()) {
            payments.add(new Payment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return payments;
    }
}
