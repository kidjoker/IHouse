/*
 * ================================================================
 * Copyright 2008-2017 Everelegance.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Everelegance Corp. Ltd, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Everelegance.
 * 
 * OPay项目组
 *
 * ================================================================
 *  创建人: jinzhijie
 *	创建时间: 2017年8月17日 - 上午9:48:54
 */
package cn.kidjoker.IHouse.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -上午9:48:54
 */
public interface BaseDao<M extends Serializable> {
	
	/** 插入 */
	public void Insert(M param) throws DataAccessException;
	
	/** 插入 */
	public void Insert(Map<String, Object> param) throws DataAccessException;
	
	/** 查询单条 */
	public M selectOne(M param) throws DataAccessException;
	
	/** 查询单条 */
	public M selectOne(Map<String, Object> param) throws DataAccessException;
	
	/** 查询全部 */
	public List<M> selectAll() throws DataAccessException;
	
	/** 查询多条 */
	public List<M> selectList(M param) throws DataAccessException;
	
	/** 查询多条 */
	public List<M> selectList(Map<String, Object> param) throws DataAccessException;
	
	/** 查询记录数 */
	public Integer selectCount(M param) throws DataAccessException;
	
	/** 查询多条 */
	public Integer selectCount(Map<String, Object> param) throws DataAccessException;
	
	/** 更新 */
	public void update(M param) throws DataAccessException;
	
	/** 更新 */
	public void update(Map<String, Object> param) throws DataAccessException;
}
