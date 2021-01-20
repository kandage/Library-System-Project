package bo.custom;

import bo.SuperBO;
import dto.BooksDTO;

import java.util.ArrayList;

public interface BooksBO extends SuperBO {
    public boolean saveBooks(BooksDTO dto) throws Exception;
    public boolean updateBooks(BooksDTO dto) throws Exception;
    public boolean deleteBooks(String id) throws Exception;
    public BooksDTO getBook(String id) throws Exception;
    public ArrayList<BooksDTO> getAllBooks() throws Exception;
    public int getBookCount() throws Exception;
    public ArrayList<String> getBookId() throws Exception;

}

