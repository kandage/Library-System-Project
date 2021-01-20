package bo.custom;

import bo.SuperBO;
import dto.MembersDTO;

import java.util.ArrayList;

public interface MembersBO extends SuperBO {
    public boolean saveMembers(MembersDTO dto) throws Exception;
    public boolean updateMembers(MembersDTO dto) throws Exception;
    public boolean deleteMembers(String id) throws Exception;
    public MembersDTO gettMembers(String id) throws Exception;
    public ArrayList<MembersDTO> getAllMembers() throws Exception;
    public int getMembersCount() throws Exception;
}
