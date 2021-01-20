package dao.custom;

import dao.CrudDao;
import entity.Members;

public interface MembersDAO extends CrudDao.CrudDAO<Members,String>{
    public int getMembersCount() throws Exception;
}
