package dao.custom.impl;

import dao.CrudUtil;
import dao.QuaryDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QuaryDAOImpl implements QuaryDAO {
    @Override
    public ArrayList<String> bookId() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT BID FROM Books");
        ArrayList<String> bookList = new ArrayList<>();

        while(set.next()){
            bookList.add((set.getString(1)));
        }
        return bookList;
    }
}
