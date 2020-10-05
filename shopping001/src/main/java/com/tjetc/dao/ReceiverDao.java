package com.tjetc.dao;

import com.tjetc.domain.Receiver;
import com.tjetc.util.Page;

public interface ReceiverDao {

    /**
     * 添加地址
     * @param receiver
     * @return
     */
    int add(Receiver receiver);

    /**
     * 删除地址
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改地址
     * @param receiver
     * @return
     */
    int update(Receiver receiver);

    /**
     * 查询所有地址
     * @return
     */
    Page<Receiver> selectAll(int pageNum, int pageSize);
    int countAll();
}
