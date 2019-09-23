package com.zmql.zytj.service.imp;

import com.zmql.zytj.bean.ConsumeLogs;
import com.zmql.zytj.bean.ConsumeLogsExcel;
import com.zmql.zytj.mapper.ConsumeLogsMapper;
import com.zmql.zytj.service.ConsumeLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeLogsServiceImpl implements ConsumeLogsService {
    @Autowired
    private ConsumeLogsMapper consumeLogsMapper;
    @Override
    public int insertConsumeLogs(ConsumeLogs consumeLogs) {
        return consumeLogsMapper.insertConsumeLogs(consumeLogs);
    }

    @Override
    public ConsumeLogs getConsumeLogsLastDataByCardNo(int cardNO) {
        return consumeLogsMapper.getConsumeLogsLastDataByCardNo(cardNO);
    }

    @Override
    public int updateConsumeLogs(ConsumeLogs consumeLogs) {
        return consumeLogsMapper.updateConsumeLogs(consumeLogs);
    }

    @Override
    public List<ConsumeLogs> statisticalResources() {
        return consumeLogsMapper.statisticalResources();
    }

    @Override
    public List<ConsumeLogsExcel> getAllConsumeLogs() {
        return consumeLogsMapper.getAllConsumeLogs();
    }
}
