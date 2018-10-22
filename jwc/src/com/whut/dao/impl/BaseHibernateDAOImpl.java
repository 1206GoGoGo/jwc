package com.whut.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.whut.dao.BaseHibernateDAO;
import com.whut.pojo.pyjhkcxxZhcxObj;
import com.whut.utils.HibernateUtils;

/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAOImpl implements BaseHibernateDAO {

	@SuppressWarnings("rawtypes")
	public List search(String sql) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List alist = null;
		try {
			alist = session.createQuery(sql).list();
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return alist;
	}


	public void modify(Object obj) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateUtils.getCurrentSession();
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
		} catch (HibernateException ex) {
			throw ex;
		} 
	}

	
	public Object getObject(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Object obj;
		List l;
		try {
			l = session.createQuery(hql).list();
			tx.commit();
			if (l.size() != 0) {
				obj = l.get(0);
			} else {
				obj = null;
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
			throw ex;
		} 
		return obj;
	}


	public void add(Object obj) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getCurrentSession();
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} 
	}


	public void delete(Object obj) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
		} catch (HibernateException ex2) {
			throw ex2;
		}
	}


	public void deleteByHql(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			tran.commit();
		} catch (HibernateException ex2) {
			throw ex2;
		} 
	}


	public Object getObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		try {
			return session.load(clazz, id); // ��¼������ʱ,���׳�ObjectNotFoundException
		} catch (HibernateException ex) {
			ex.printStackTrace();
			throw ex;
		} 
	}


	public List getObjects(Class clazz) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		List alist = null;
		try {
			session.getTransaction().begin();
			alist = session.createQuery("from " + clazz.getName()).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return alist;
	}


	public List getLimitObjects(Class clazz, int start, int pageSize) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		List alist = null;
		try {
			session = HibernateUtils.getCurrentSession();
			session.flush();
			session.getTransaction().begin();
			alist = session.createQuery("from " + clazz.getName())
					.setFirstResult(start).setMaxResults(pageSize).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alist;
	}


	public int getSize(Class clazz, String param) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer num = 0;
		try {
			session = HibernateUtils.getCurrentSession();
			Criteria c = session.createCriteria(clazz);
			num = (Integer) c.setProjection(Projections.countDistinct(param))
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num.intValue();
	}


	public Long count(String hql) {
		// TODO Auto-generated method stub
		Query q = HibernateUtils.getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}


	public Long getmaxid(String table, String idString) {
		// TODO Auto-generated method stub
		BigDecimal l = (BigDecimal) HibernateUtils.getCurrentSession().createQuery(
				"select max(n." + idString + ") from " + table + " n")
				.uniqueResult();
		return new Long(l.longValue());
	}


	public List<pyjhkcxxZhcxObj> pyjhkcxxZhcx(String sql) {
		// TODO Auto-generated method stub
		Session session = null;
		List<pyjhkcxxZhcxObj> list = null;
		try {
			session = HibernateUtils.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createSQLQuery(sql).setResultTransformer(
					Transformers.aliasToBean(com.whut.pojo.pyjhkcxxZhcxObj.class));
			list = q.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

}