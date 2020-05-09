package com.winby.demo.core.dao.persistence;

import com.winby.demo.core.entity.Demo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface DemoDao extends Mapper<Demo> {
}
