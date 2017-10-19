package com.github.dcsoft.security.admin.biz;

import com.github.dcsoft.security.admin.entity.GateLog;
import com.github.dcsoft.security.admin.mapper.GateLogMapper;
import com.github.dcsoft.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author dcdai
 * @create 2017-07-01 14:36
 */
@Service
public class GateLogBiz extends BaseBiz<GateLogMapper,GateLog> {

    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
