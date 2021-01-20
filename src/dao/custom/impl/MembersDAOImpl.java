package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.MembersDAO;
import entity.Books;
import entity.Members;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembersDAOImpl implements MembersDAO {
    @Override
    public boolean save(Members members) throws Exception {
        return CrudUtil.execute("INSERT INTO Members VALUES(?,?,?,?,?,?)",members.getMID(),members.getName(),members.getEmail(),members.getDOB(),members.getMobile(),members.getAddress());
    }

    @Override
    public boolean update(Members members) throws Exception {
        return CrudUtil.execute("UPDATE Members SET Name=?,Email=?,DOB=?,Mobile=?,Address=? WHERE MID=?",
                members.getName(),members.getEmail(),members.getDOB(),members.getMobile(),members.getAddress(),members.getMID());
    }
    @Override
    public boolean delete(String MID) throws Exception {
        return CrudUtil.execute("DELETE FROM Members WHERE MID=?",MID);
    }

    @Override
    public Members get(String MID) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Members WHERE MID=?",MID);
        if (resultSet.next()) {
            return new Members(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)

            );
        } else {
            return null;
        }
    }

    @Override
    public List<Members> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Members");
        ArrayList<Members> members = new ArrayList<>();
        while (resultSet.next()) {
            members.add(new Members(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }
        return members;
    }

    @Override
    public int getMembersCount() throws Exception {
        int count=0;
        ResultSet resultSet=CrudUtil.execute("SELECT COUNT(MID) from Members");
        if(resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }
}
