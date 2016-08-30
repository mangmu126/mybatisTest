package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
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
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件
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
		// 得到配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> users = sqlSession.selectList("test.findUserByName","小明");
		
		System.out.println(users);
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() throws IOException
	{
		String resource = "SqlMapConfig.xml";
		// 得到配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 插入对象
		User user = new User();
		user.setUsername("王小军");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");
		sqlSession.insert("test.insertUser",user);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void deleteUserTest() throws IOException{
		String resource = "SqlMapConfig.xml";
		// 得到配置文件
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
		// 得到配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(27);
		user.setUsername("王大军1");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("河南");
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
}
