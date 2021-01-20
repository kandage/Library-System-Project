package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BorrowDetailDAO;
import entity.Books;
import entity.BorrowDetail;

import java.sql.ResultSet;
import java.util.List;

public class BorrowDetailDAOImpl implements BorrowDetailDAO {
    @Override
    public boolean save(BorrowDetail b) throws Exception {
        return CrudUtil.execute("INSERT INTO BorrowDetail VALUES(?,?,?,?,?,?,?,?,?,?)",
                b.getBODeId(),
                b.getRegId(),
                b.getBookID(),
                b.getISBN(),
                b.getLanguage(),
                b.getIssueDate(),
                b.getDueToReturn(),
                b.getReturnDate(),
                b.getExpiringDate(),
                b.getFine());
    }

    @Override
    public boolean update(BorrowDetail borrowDetail) throws Exception {
        return CrudUtil.execute("UPDATE BorrowDetail SET RegId=?, BID=?, ISBN=?, Language=?, IssueDate=?,DueReturn=?,ReturnDate=?,ExpringDate=?,FineTotPrice=? WHERE BoDeId=?",
                borrowDetail.getRegId(),borrowDetail.getBookID(),borrowDetail.getISBN(),borrowDetail.getLanguage(),borrowDetail.getIssueDate(),borrowDetail.getDueToReturn(),borrowDetail.getReturnDate(),borrowDetail.getExpiringDate(),borrowDetail.getFine(),borrowDetail.getBODeId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public BorrowDetail get(String BoDeId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM BorrowDetail WHERE BoDeId=?",BoDeId);
        if (resultSet.next()) {
            return new BorrowDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getDouble(10)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<BorrowDetail> getAll() throws Exception {
        return null;
    }
}
