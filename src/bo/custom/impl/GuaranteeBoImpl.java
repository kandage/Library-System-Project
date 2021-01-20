package bo.custom.impl;

import bo.custom.GuaranteeBO;
import dao.DaoFactory;
import dao.QuaryDAO;
import dao.custom.GuaranteeDAO;
import dto.GuaranteeDTO;
import entity.Guarantee;
import java.util.ArrayList;
import java.util.List;

public class GuaranteeBoImpl implements GuaranteeBO {
    GuaranteeDAO gdao=DaoFactory.getInstance().getDao(DaoFactory.DAOType.GUARANTEE);
    QuaryDAO qDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);
    @Override
    public boolean saveGuarantee(GuaranteeDTO dto) throws Exception {
        return gdao.save(new Guarantee(dto.getGID(),dto.getRegID(),dto.getGName(),dto.getGType(),dto.getMobile(),dto.getAddress(),dto.getEmail()));
    }

    @Override
    public boolean updateGuarantee(GuaranteeDTO dto) throws Exception {
        return gdao.update(new Guarantee(dto.getGID(),dto.getRegID(),dto.getGName(),dto.getGType(),dto.getMobile(),dto.getAddress(),dto.getEmail()));
    }


    @Override
    public boolean deleteGuarantee(String GID) throws Exception {
        return gdao.delete(GID);
    }

    @Override
    public GuaranteeDTO getGuarantee(String GID) throws Exception {
        Guarantee g=gdao.get(GID);
        return new GuaranteeDTO(g.getGID(),g.getRegID(),g.getGName(),g.getGType(),g.getMobile(),g.getAddress(),g.getEmail());
    }

    @Override
    public ArrayList<GuaranteeDTO> getAllGuarantee() throws Exception {
        List<Guarantee> gList=gdao.getAll();
        ArrayList<GuaranteeDTO> dtoList= new ArrayList();
        for (Guarantee g : gList) {
            dtoList.add(new GuaranteeDTO(g.getGID(),g.getRegID(),g.getGName(),g.getGType(),g.getMobile(),g.getAddress(),g.getEmail()));
        }
        return dtoList;
    }

    @Override
    public int getGuaranteeCount() throws Exception {
        return 0;
    }
}
