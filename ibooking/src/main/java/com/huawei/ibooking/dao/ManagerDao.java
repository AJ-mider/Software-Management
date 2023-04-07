package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.ManagerMapper;
import com.huawei.ibooking.model.ManagerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerDao {
    @Autowired
    private ManagerMapper managerMapper;

    public List<ManagerDO> getManagers() {
        return managerMapper.getManagers();
    }

    public List<ManagerDO> getManager(final String managerNum) {
        return managerMapper.getManager(managerNum);
    }

    public boolean saveManager(final ManagerDO manager) {
        return managerMapper.saveManager(manager) > 0;
    }

    public boolean deleteManager(final String managerNum) {
        return managerMapper.deleteManager(managerNum) > 0;
    }
}
