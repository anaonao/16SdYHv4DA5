package com.tjetc.service.impl;

import com.tjetc.dao.ReceiverDao;
import com.tjetc.dao.impl.ReceiverDaoImpl;
import com.tjetc.domain.Receiver;
import com.tjetc.service.ReceiverService;
import com.tjetc.util.Page;

public class ReceiverServiceImpl implements ReceiverService {
    private ReceiverDao receiverDao = new ReceiverDaoImpl();
    @Override
    public int add(Receiver receiver) {
        if(receiver!=null){
            return receiverDao.add(receiver);
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return receiverDao.delete(id);
    }

    @Override
    public int update(Receiver receiver) {
        if(receiver!=null){
            return receiverDao.update(receiver);
        }
        return 0;
    }

    @Override
    public Page<Receiver> findAll(int pageNum, int pageSize) {
        return receiverDao.selectAll(pageNum,pageSize);
    }
}
