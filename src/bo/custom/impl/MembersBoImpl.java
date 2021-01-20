package bo.custom.impl;

import bo.custom.MembersBO;
import dao.DaoFactory;
import dao.custom.MembersDAO;
import dto.BooksDTO;
import dto.MembersDTO;
import entity.Books;
import entity.Members;

import java.util.ArrayList;
import java.util.List;

public class MembersBoImpl implements MembersBO {
    MembersDAO dao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.MEMBERS);
    @Override
    public boolean saveMembers(MembersDTO dto) throws Exception {
      return dao.save(new Members(dto.getMID(),dto.getName(),dto.getEmail(),dto.getDOB(),dto.getMobile(),dto.getAddress()));
    }

    @Override
    public boolean updateMembers(MembersDTO dto) throws Exception {
        return dao.update(new Members(dto.getMID(),dto.getName(),dto.getEmail(),dto.getDOB(),dto.getMobile(),dto.getAddress()));
    }

    @Override
    public boolean deleteMembers(String MID) throws Exception {
        return dao.delete(MID);
    }

    @Override
    public MembersDTO gettMembers(String MID) throws Exception {
        Members m=dao.get(MID);
        return new MembersDTO(m.getMID(),m.getName(),m.getEmail(),m.getDOB(),m.getMobile(),m.getAddress());
    }

    @Override
    public ArrayList<MembersDTO> getAllMembers() throws Exception {
        List<Members> mList=dao.getAll();
        ArrayList<MembersDTO> dtoList= new ArrayList();
        for (Members m : mList) {
            dtoList.add(new MembersDTO(m.getMID(),m.getName(),m.getEmail(),m.getDOB(),m.getMobile(),
                    m.getAddress()));
        }
        return dtoList;
    }

    @Override
    public int getMembersCount() throws Exception {
        return dao.getMembersCount();
    }
}
