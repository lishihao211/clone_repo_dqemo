package org.imooc.dao;

import org.imooc.bean.Ad;

public interface AdDao {
    
    /**
     * 新增
     * @param ad 广告表对象
     * @return 影响行数
     */
    int insert(Ad ad);

}