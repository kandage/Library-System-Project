package bo.custom;

import bo.SuperBO;
import dto.AddRegDto;

public interface AddRegistrationBo extends SuperBO {
    public boolean addReg(AddRegDto dto) throws Exception;
}
