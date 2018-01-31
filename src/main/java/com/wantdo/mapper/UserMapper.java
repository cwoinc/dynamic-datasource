package com.wantdo.mapper;

import com.wantdo.datasource.TargetDataSource;
import com.wantdo.entity.User;
import com.wantdo.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	@TargetDataSource("ds2")
    int countByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

	@TargetDataSource("ds1")
    int insert(User record);

	@TargetDataSource("ds2")
    int insertSelective(User record);

	@TargetDataSource("ds1")
    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}