package com.jsite.busi.szy.dispatch.dao;

import java.util.List;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-25 12:45
 */
public interface BaseBatchDao<T> {
    int batchInsert(List<T> list, String proCd);
    int batchUpdate(List<T> list, String proCd);
}
