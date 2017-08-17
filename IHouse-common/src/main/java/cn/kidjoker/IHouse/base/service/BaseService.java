package cn.kidjoker.IHouse.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -上午10:34:26
 */
public interface BaseService<M extends Serializable> {
	
	/** 插入 */
	public void add(M param);
	
	/** 插入 */
	public void add(Map<String, Object> param);
	
	/** 查询单条 */
	public M getModel(M param);
	
	/** 查询单条 */
	public M getModel(Map<String, Object> param);
	
	/** 查询全部 */
	public List<M> getAllList();
	
	/** 查询多条 */
	public List<M> getList(M param);
	
	/** 查询多条 */
	public List<M> getList(Map<String, Object> param);
	
	/** 查询记录数 */
	public Integer getCount(M param);
	
	/** 查询多条 */
	public Integer getCount(Map<String, Object> param);
	
	/** 更新 */
	public void update(M param);
	
	/** 更新 */
	public void update(Map<String, Object> param);
	
}
