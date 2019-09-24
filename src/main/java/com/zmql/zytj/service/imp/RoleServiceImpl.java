package com.zmql.zytj.service.imp;

import com.zmql.zytj.mapper.RoleMapper;
import com.zmql.zytj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public int judgeCardNO(int cardNO, String database) {
        return roleMapper.judgeCardNO(cardNO,database);
    }

    @Override
    public String getCardStatus(String database, Integer cardNO) {
        return roleMapper.getCardStatus(database,cardNO);
    }
}
