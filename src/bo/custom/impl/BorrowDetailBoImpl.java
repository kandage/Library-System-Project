package bo.custom.impl;

import bo.BoFactory;
import bo.custom.BorrowDetailBO;
import dao.DaoFactory;
import dao.custom.BorrowDetailDAO;
import dto.BooksDTO;
import dto.BorrowDetailDTO;
import entity.Books;
import entity.BorrowDetail;

import java.util.ArrayList;

public class BorrowDetailBoImpl implements BorrowDetailBO {
    BorrowDetailDAO bDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ISSUEBOOKS);

    @Override
    public boolean saveIssueBook(BorrowDetailDTO dto) throws Exception {
        return bDao.save(new BorrowDetail(
                dto.getBODeId(),
                dto.getRegId(),
                dto.getBookID(),
                dto.getISBN(),
                dto.getLanguage(),
                dto.getIssueDate(),
                dto.getDueToReturn(),
                dto.getReturnDate(),
                dto.getExpiringDate(),
                dto.getFine()
        ));
    }

    @Override
    public boolean updateIssueBook(BorrowDetailDTO dto) throws Exception {
        return bDao.update(new BorrowDetail(dto.getBODeId(),dto.getRegId(),dto.getBookID(),dto.getISBN(),dto.getLanguage(),dto.getIssueDate(),dto.getDueToReturn(),dto.getReturnDate(),dto.getExpiringDate(),dto.getFine()));
    }

    @Override
    public boolean deleteIssueBook(String id) throws Exception {
        return false;
    }

    @Override
    public BorrowDetailDTO gettIssueBook(String BoDeId) throws Exception {
        BorrowDetail b=bDao.get(BoDeId);
        return new BorrowDetailDTO(b.getBODeId(),b.getRegId(),b.getBookID(),b.getISBN(),b.getLanguage(),b.getIssueDate(),b.getDueToReturn(),b.getReturnDate(),b.getExpiringDate(),b.getFine());
    }


    @Override
    public ArrayList<BorrowDetailDTO> getAllIssueBook() throws Exception {
        return null;
    }
}
