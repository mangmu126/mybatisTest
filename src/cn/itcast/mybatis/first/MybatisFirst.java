package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.*;



public class MybatisFirst {
	
	@Test
	public void findUserByIdTest() throws IOException
	{	
		//mybatis閰嶇疆鏂囦欢
		String resource = "SqlMapConfig.xml";
		// 寰楀埌閰嶇疆鏂囦欢
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById",1);
		
		System.out.println(user);
		sqlSession.close();
	}
	@Test
	public void findUserByNameTest() throws IOException
	{
		String resource = "SqlMapConfig.xml";
		// 寰楀埌閰嶇疆鏂囦欢
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> users = sqlSession.selectList("test.findUserByName","大毛");
		
		System.out.println(users);
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() throws IOException
	{
		String resource = "SqlMapConfig.xml";
		// 寰楀埌閰嶇疆鏂囦欢
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 鎻掑叆瀵硅薄
		User user = new User();
		user.setUsername("hai");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("mao");
		sqlSession.insert("test.insertUser",user);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void deleteUserTest() throws IOException{
		String resource = "SqlMapConfig.xml";
		// 寰楀埌閰嶇疆鏂囦欢
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser",28);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Test
	public void updateUserTest() throws IOException{
		String resource = "SqlMapConfig.xml";
		// 寰楀埌閰嶇疆鏂囦欢
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(27);
		user.setUsername("你好大毛");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("天河");
		sqlSession.update("test.updateUser",user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	@Test
	public void testFindUserById() throws Exception
	{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(27);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserList() throws Exception
	{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setSex("2");
//		userCustom.setUsername("大毛");
//		userQueryVo.setUserCustom(userCustom);
		List<Integer> list = new ArrayList<Integer>();
		list.add(26);
		list.add(29);
		userQueryVo.setIds(list);
		
		List<UserCustom> lists = userMapper.findUserList(userQueryVo);
		System.out.println(lists);
	}
	
	@Test
	public void testFindUserCount() throws Exception
	{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("2");
		userCustom.setUsername("大毛");
		userQueryVo.setUserCustom(userCustom);
		
		int  count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception
	{
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user= userMapper.findUserByIdResultMap(27);
		System.out.println(user);
	}
}
