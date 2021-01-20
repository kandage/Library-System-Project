package bo.custom;

import bo.SuperBO;
import dto.BorrowDetailDTO;

import java.util.ArrayList;

public interface BorrowDetailBO extends SuperBO {
    public boolean saveIssueBook(BorrowDetailDTO dto) throws Exception;
    public boolean updateIssueBook(BorrowDetailDTO dto) throws Exception;
    public boolean deleteIssueBook(String id) throws Exception;
    public BorrowDetailDTO gettIssueBook(String id) throws Exception;
    public ArrayList<BorrowDetailDTO> getAllIssueBook() throws Exception;
}
