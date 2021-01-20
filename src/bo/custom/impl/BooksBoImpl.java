package bo.custom.impl;

import bo.custom.BooksBO;
import dao.DaoFactory;
import dao.QuaryDAO;
import dao.custom.BooksDAO;
import dto.BooksDTO;
import entity.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksBoImpl implements BooksBO {
    BooksDAO dao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.BOOKS);
    QuaryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    @Override
    public boolean saveBooks(BooksDTO dto) throws Exception {
        return dao.save(new Books(dto.getBID(),dto.getBookName(),dto.getTitle(),dto.getISBN(),dto.getLanguage(),dto.getCatagory(),dto.getAuthor(),dto.getPrice(),dto.getAddedDate()));
    }

    @Override
    public boolean updateBooks(BooksDTO dto) throws Exception {
        System.out.println("dto = " + dto);
        return dao.update(new Books(dto.getBID(),dto.getBookName(),dto.getTitle(),dto.getISBN(),dto.getLanguage(),dto.getCatagory(),dto.getAuthor(),dto.getPrice(),dto.getAddedDate()));
    }

    @Override
    public boolean deleteBooks(String BID) throws Exception {
        return dao.delete(BID);
    }

    @Override
    public BooksDTO getBook(String BID) throws Exception {
        Books b=dao.get(BID);
        return new BooksDTO(b.getBID(),b.getBookName(),b.getTitle(),b.getISBN(),b.getLanguage(),b.getCatagory(),b.getAuthor(),b.getPrice(),b.getAddedDate());
    }

    @Override
    public ArrayList<BooksDTO> getAllBooks() throws Exception {
        List<Books> bList=dao.getAll();
        ArrayList<BooksDTO> dtoList= new ArrayList();
        for (Books b : bList) {
            dtoList.add(new BooksDTO(b.getBID(),b.getBookName(),b.getTitle(),b.getISBN(),b.getLanguage(),b.getCatagory(),b.getAuthor(),b.getPrice(),b.getAddedDate()));
        }
        return dtoList;
    }

    @Override
    public int getBookCount() throws Exception {
        return dao.getBookCount();
    }

    @Override
    public ArrayList<String> getBookId() throws Exception {
         return qDao.bookId();
    }

}
