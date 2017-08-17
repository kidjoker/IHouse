package cn.kidjoker.IHouse.base.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.kidjoker.IHouse.base.dao.BaseDao;
import cn.kidjoker.IHouse.base.service.BaseService;

/**
 * <p>
 * OPay
 * </p>
 *
 * @author jinzhijie
 * @version 1.0.0
 * @since 1.0.0
 * @createTime 2017年8月17日 -上午10:52:02
 */
public abstract class BaseServiceImpl<M extends Serializable,D extends BaseDao<M>> implements BaseService<M> {

	public abstract D getDao();
	
	@Override
	public void add(M param) {
		getDao().insert(param);
	}

	@Override
	public void add(Map<String, Object> param) {
		getDao().insert(param);
	}

	@Override
	public M getModel(M param) {
		return getDao().selectOne(param);
	}

	@Override
	public M getModel(Map<String, Object> param) {
		return getDao().selectOne(param);
	}

	@Override
	public List<M> getAllList() {
		return getDao().selectAll();
	}

	@Override
	public List<M> getList(M param) {
		return getDao().selectList(param);
	}

	@Override
	public List<M> getList(Map<String, Object> param) {
		return getDao().selectList(param);
	}

	@Override
	public Integer getCount(M param) {
		return getDao().selectCount(param);
	}

	@Override
	public Integer getCount(Map<String, Object> param) {
		return getDao().selectCount(param);
	}

	@Override
	public void update(M param) {
		
	}

	@Override
	public void update(Map<String, Object> param) {
		
	}

}
