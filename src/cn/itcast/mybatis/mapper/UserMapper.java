package cn.itcast.mybatis.mapper;


import java.util.List;

import cn.itcast.mybatis.po.*;

public interface UserMapper {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	// 用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	// 用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息
	public User findUserByIdResultMap(int id) throws Exception;
}
