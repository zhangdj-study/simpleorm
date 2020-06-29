package com.neusiri.mapper;


import com.neusiri.model.UserDO;

import java.util.List;

/**
 * @author zhangdj
 * @date 2020/01/09 10:54
 */
public interface UserMapper {

    List<UserDO> queryById(Long id);

    List<UserDO> queryList(Long id);
}
