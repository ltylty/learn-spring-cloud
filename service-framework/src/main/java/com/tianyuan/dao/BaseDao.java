package com.tianyuan.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseDao<P> extends Mapper<P>, MySqlMapper<P> {

}
