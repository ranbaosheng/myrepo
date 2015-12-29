package com.fs.general.common.general;

import java.io.Serializable;
import java.util.List;

import com.fs.general.common.exception.DaoException;

/**
 * 
 * @author fangli
 *
 * @param <T>
 * @param <ID>
 */
public interface GeneralDao<T extends GeneralObject, ID extends Serializable> {
    /**
     * 根据主键删除
     * @param id
     * @return
     * @throws DaoException
     */
    int deleteByPrimaryKey(ID id) throws DaoException;
    /**
     * 新增
     * @param record
     * @return
     * @throws DaoException
     */
    int insert(T record) throws DaoException;
    /**
     * 根据主键id查找
     * @param id
     * @return
     * @throws DaoException
     */
    T selectByPrimaryKey(ID id) throws DaoException;
    /**
     * 修改部分列内容
     * @param record
     * @return
     * @throws DaoException
     */
    int updateByPrimaryKeySelective(T record) throws DaoException;
    /**
     * 修改全部的列内容
     * @param record
     * @return
     * @throws DaoException
     */
    int updateByPrimaryKey(T record) throws DaoException;
    /**
     * 总数量
     * @return
     */
    Long count();
    /**
     * 查找全部的记录
     */
    List<T> selectAll() throws DaoException;
}
