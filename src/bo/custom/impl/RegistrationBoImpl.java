package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DaoFactory;
import dao.custom.RegistrationDAO;
import dto.RegistrationDTO;
import entity.Registration;

import java.util.ArrayList;

public class RegistrationBoImpl implements RegistrationBO {
    RegistrationDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.REGISTRATION);
    @Override
    public boolean saveRegistration(RegistrationDTO dto) throws Exception {
        return qDao.save(new Registration(dto.getRegId(),dto.getMID(),dto.getRegDate()));
    }


    @Override
    public boolean updateRegistration(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRegistration(String id) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO gettRegistration(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistration() throws Exception {
        return null;
    }
}
