package dao.custom;

import dao.CrudDao;
import entity.Books;

public interface BooksDAO extends CrudDao.CrudDAO<Books,String> {
    public int getBookCount() throws Exception;
}
