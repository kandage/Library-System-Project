package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.GuaranteeDAO;
import entity.Books;
import entity.Guarantee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuaranteeDAOImpl implements GuaranteeDAO {
    @Override
    public boolean save(Guarantee guarantee) throws Exception {
        return CrudUtil.execute("INSERT INTO Guarantee VALUES (?,?,?,?,?,?,?)",guarantee.getGID(),guarantee.getRegID(),guarantee.getGName(),guarantee.getGType(),guarantee.getMobile(),guarantee.getAddress(),guarantee.getEmail());
    }

    @Override
    public boolean update(Guarantee guarantee) throws Exception {
        return CrudUtil.execute("UPDATE Guarantee SET RegId=?, GName=?, GType=?, Mobile=?, Address=?,Email=? WHERE GID=?",
                guarantee.getRegID(),guarantee.getGName(),guarantee.getGType(),guarantee.getMobile(),guarantee.getAddress(),guarantee.getEmail(),guarantee.getGID());
    }

    @Override
    public boolean delete(String GID) throws Exception {
        return CrudUtil.execute("DELETE FROM Guarantee WHERE GID=?",GID);
    }

    @Override
    public Guarantee get(String GID) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Guarantee WHERE GID=?",GID);
        if (resultSet.next()) {
            return new Guarantee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<Guarantee> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Guarantee");
        ArrayList<Guarantee> guarantees = new ArrayList<>();
        while (resultSet.next()) {
            guarantees.add(new Guarantee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }
        return guarantees;
    }
}
