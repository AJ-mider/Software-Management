package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.ManagerDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerMapper {
    List<ManagerDO> getManagers();

    List<ManagerDO> getManager(@Param("managerNum") String managerNum);

    int saveManager(@Param("manager") ManagerDO manager);

    int deleteManager(@Param("managerNum") String managerNum);
}
