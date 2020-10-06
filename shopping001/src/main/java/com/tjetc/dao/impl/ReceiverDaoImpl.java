package com.tjetc.dao.impl;

import com.tjetc.dao.ReceiverDao;
import com.tjetc.domain.Receiver;
import com.tjetc.domain.User;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceiverDaoImpl implements ReceiverDao {
    @Override
    public int add(Receiver receiver) {
        String sql = "insert into receiver(receiver_name,receiver_phone,receiver_username,user_id) values(?,?,?,?)";
        int n = DBUtil.addDeleteUpdate(sql, receiver.getReceiverName(), receiver.getReceiverPhone(), receiver.getReceiverUserName(), receiver.getUser().getUserId());
        return n;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from receiver where receiver_id=?";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(Receiver receiver) {
        String sql = "update receiver set receiver_name=?,receiver_phone=?,receiver_username=?,user_id=? where receiver_id=?";
        int n = DBUtil.addDeleteUpdate(sql, receiver.getReceiverName(), receiver.getReceiverPhone(), receiver.getReceiverUserName(), receiver.getUser().getUserId(), receiver.getReceiverId());
        return n;
    }

    @Override
    public Page<Receiver> selectAll(int pageNum, int pageSize) {
        Page<Receiver> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<Receiver> list = new ArrayList<>();
        String sql = "select receiver_id,receiver_name,receiver_phone,receiver_username,user_id from receiver limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                Receiver receiver = new Receiver();
                receiver.setReceiverId(rs.getInt("receiver_id"));
                receiver.setReceiverName(rs.getString("receiver_name"));
                receiver.setReceiverPhone(rs.getString("receiver_phone"));
                receiver.setReceiverUserName(rs.getString("receiver_username"));

                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                receiver.setUser(user);
                list.add(receiver);
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public int countAll() {
        String sql = "select count(1) from receiver";
        ResultSet rs = DBUtil.select(sql);
        int n = 0;
        try {
            if(rs.next()){
                n=rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }

    }
}
