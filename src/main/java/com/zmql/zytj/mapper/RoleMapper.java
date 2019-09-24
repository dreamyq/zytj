package com.zmql.zytj.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 对老师和学生的角色进行操作的mapper
 */
public interface RoleMapper {
    /**
     * 判断输入的卡号是否存在，如果不存在则不允许进入
     */
    int judgeCardNO(@Param("cardNO") int cardNO,@Param("database")String database);

    String getCardStatus(@Param("role")String role,@Param("card")Integer card);
}
