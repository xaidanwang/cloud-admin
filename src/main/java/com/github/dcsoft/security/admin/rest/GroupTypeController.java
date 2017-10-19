package com.github.dcsoft.security.admin.rest;

import com.github.dcsoft.security.admin.biz.GroupTypeBiz;
import com.github.dcsoft.security.admin.entity.GroupType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.dcsoft.security.admin.biz.UserBiz;
import com.github.dcsoft.security.admin.entity.User;
import com.github.dcsoft.security.common.msg.TableResultResponse;
import com.github.dcsoft.security.common.rest.BaseController;

import tk.mybatis.mapper.entity.Example;

/**
 * ${DESCRIPTION}
 *
 * @author dcdai
 * @create 2017-06-08 11:51
 */
@Controller
@RequestMapping("groupType")
public class GroupTypeController extends BaseController<GroupTypeBiz,GroupType> {

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<GroupType> page(int limit, int offset, String name){
        Example example = new Example(User.class);
        if(StringUtils.isNotBlank(name))
            example.createCriteria().andLike("name", "%" + name + "%");
        int count = baseBiz.selectCountByExample(example);
        PageHelper.startPage(offset, limit);
        return new TableResultResponse<GroupType>(count,baseBiz.selectByExample(example));
    }

}
