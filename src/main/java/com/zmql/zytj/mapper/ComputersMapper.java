package com.zmql.zytj.mapper;

import com.zmql.zytj.bean.Computers;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.HashMap;
import java.util.List;

public interface ComputersMapper {
    /**
     * 通过电脑ip得到电脑的数据
     * @param ip
     * @return
     */
    Computers getComputerByIp(String ip);

    /**
     * 存储过程，执行刷卡操作的时候修改学生或者是老师的状态信息
     * @param cardNO
     * @param role
     * @param readRoomId
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Select("call updateRoleStatus(#{cardNO},#{role},#{readRoomId})")
    @Options(statementType= StatementType.CALLABLE )
    public HashMap updateRoleStatus(@Param("cardNO") int cardNO,@Param("role")String role,@Param("readRoomId")int readRoomId);
}
