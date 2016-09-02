package cn.itcast.mybatis.first;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.mapper.OrdersMapperCustom;
import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class OrdersTset {

	@Test
	public void TestfindOrdersUser() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom orderMapper = sqlSession.getMapper(OrdersMapperCustom.class);
	
		
		List<OrdersCustom>  count = orderMapper.findOrdersUser();
		System.out.println(count);
	}
	
	@Test
	public void TestfindOrdersUserResultMap() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom orderMapper = sqlSession.getMapper(OrdersMapperCustom.class);
	
		
		List<Orders>  count = orderMapper.findOrdersUserResultMap();
		System.out.println(count);
	}
	@Test
	public void TestfindOrdersAndOrderDetailResultMap() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom orderMapper = sqlSession.getMapper(OrdersMapperCustom.class);
	
		
		List<Orders>  count = orderMapper.findOrdersAndOrderDetailResultMap();
		System.out.println(count);
	}
	
	@Test
	public void TestfindOrdersUserLazyLoading() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom orderMapper = sqlSession.getMapper(OrdersMapperCustom.class);
	
		
		List<Orders>  count = orderMapper.findOrdersUserLazyLoading();
		System.out.println(count);
	}
}
