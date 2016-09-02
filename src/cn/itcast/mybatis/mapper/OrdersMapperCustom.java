package cn.itcast.mybatis.mapper;


import java.util.List;

import cn.itcast.mybatis.po.*;

public interface OrdersMapperCustom {
	
	// 查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	// 查询订单关联查询用户信息resultMap
	public List<Orders> findOrdersUserResultMap() throws Exception;
	// 查询订单（关联账号）及订单明细
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
	
	// 查询订单,用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
