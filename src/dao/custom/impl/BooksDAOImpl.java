package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BooksDAO;
import entity.Books;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOImpl implements BooksDAO {
    @Override
    public boolean save(Books books) throws Exception {
        return CrudUtil.execute("INSERT INTO Books VALUES (?,?,?,?,?,?,?,?,?)",books.getBID(),books.getBookName(),books.getTitle(),books.getISBN(),
                books.getLanguage(),books.getCatagory(),books.getAuthor(),books.getPrice(),books.getAddedDate());
    }

    @Override
        public boolean update(Books books) throws Exception {
            return CrudUtil.execute("UPDATE Books SET BookName=?, Title=?, ISBN=?, Language=?, Catagory=?,Author=?,Price=?,AddedDate=? WHERE BID=?",
                    books.getBookName(),books.getTitle(),books.getISBN(),books.getLanguage(),books.getCatagory(),books.getAuthor(),books.getPrice(),books.getAddedDate(),books.getBID());
        }

    @Override
    public boolean delete(String BID) throws Exception {
        return CrudUtil.execute("DELETE FROM Books WHERE BID=?",BID);
    }

    @Override
    public Books get(String BID) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Books WHERE BID=?",BID);
        if (resultSet.next()) {
            return new Books(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<Books> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Books");
        ArrayList<Books> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(new Books(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            ));
        }
        return books;
    }

    @Override
    public int getBookCount() throws Exception {
        int count=0;
        ResultSet resultSet=CrudUtil.execute("SELECT COUNT(BID) from Books");
        if(resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }
}
