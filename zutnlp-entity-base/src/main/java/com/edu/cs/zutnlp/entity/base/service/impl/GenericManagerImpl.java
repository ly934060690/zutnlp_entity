package com.edu.cs.zutnlp.entity.base.service.impl;

import com.edu.cs.zutnlp.entity.base.dao.GenericDao;
import com.edu.cs.zutnlp.entity.base.domain.BaseEntity;
import com.edu.cs.zutnlp.entity.base.service.GenericManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 *
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
@Transactional
public class GenericManagerImpl<T extends BaseEntity, PK extends Serializable> implements GenericManager<T, PK> {

	protected GenericDao<T, PK> dao;

	public void delete(PK id) {
		this.dao.deleteById(id);
	}

	public List<T> findAll() {
		return this.dao.findAll();
	}

	public Page<T> findAll(Pageable page) {
		Page<T> result = this.dao.findAll(page);
		return result;
	}

	public T findById(PK id) {
		return this.dao.getOne(id);
	}

	public List<T> save(Iterable<T> entities) {
		return this.dao.saveAll(entities);
	}

	public T save(T entity) {
		return this.dao.saveAndFlush(entity);
	}

}
