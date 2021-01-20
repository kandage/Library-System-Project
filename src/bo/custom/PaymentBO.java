package bo.custom;
import bo.SuperBO;
import dto.PaymentDTO;

import java.util.ArrayList;
public interface PaymentBO extends SuperBO {
    public boolean savePayment(PaymentDTO dto) throws Exception;
    public boolean updatePayment(PaymentDTO dto) throws Exception;
    public boolean deletePayment(String id) throws Exception;
    public PaymentDTO gettPayment(String id) throws Exception;
    public ArrayList<PaymentDTO> getAllPayment() throws Exception;
}
