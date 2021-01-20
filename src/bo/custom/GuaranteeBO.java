package bo.custom;

import bo.SuperBO;
import dto.GuaranteeDTO;

import java.util.ArrayList;

public interface GuaranteeBO extends SuperBO {
    public boolean saveGuarantee(GuaranteeDTO dto) throws Exception;
    public boolean updateGuarantee(GuaranteeDTO dto) throws Exception;
    public boolean deleteGuarantee(String id) throws Exception;
    public GuaranteeDTO getGuarantee(String id) throws Exception;
    public ArrayList<GuaranteeDTO> getAllGuarantee() throws Exception;
    public int getGuaranteeCount() throws Exception;
}
