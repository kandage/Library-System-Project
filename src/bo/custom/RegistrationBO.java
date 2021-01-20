package bo.custom;

import bo.SuperBO;
import dto.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {
    public boolean saveRegistration(RegistrationDTO dto) throws Exception;
    public boolean updateRegistration(RegistrationDTO dto) throws Exception;
    public boolean deleteRegistration(String id) throws Exception;
    public RegistrationDTO gettRegistration(String id) throws Exception;
    public ArrayList<RegistrationDTO> getAllRegistration() throws Exception;
}
