package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.ManagerDao;
import com.huawei.ibooking.model.ManagerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManagerBusiness {
    @Autowired
    private ManagerDao managerDao;
    public List<ManagerDO> getManagers(){
        return managerDao.getManagers();
    }
    public Optional<ManagerDO> getManager(final String managerNum){
        List<ManagerDO> managers=managerDao.getManager(managerNum);
        if(managers.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(managers.get(0));
    }
    public boolean saveManager(final ManagerDO manager){
        return managerDao.saveManager(manager);
    }

    public boolean deleteManager(final String managerNum){
        return managerDao.deleteManager(managerNum);
    }
}
