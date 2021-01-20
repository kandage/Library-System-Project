package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RegistrationDAO;
import entity.Registration;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean save(Registration registration) throws Exception {
        return CrudUtil.execute("INSERT INTO Registration VALUES (?,?,?)",registration.getRegId(),registration.getMID(),registration.getRegDate());
    }

    @Override
    public boolean update(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Registration get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Registration> getAll() throws Exception {
        return null;
    }
}
