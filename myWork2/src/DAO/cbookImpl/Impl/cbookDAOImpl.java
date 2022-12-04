package DAO.cbookImpl.Impl;

import DAO.BaseDao.BaseDAO;
import DAO.cbookImpl.cbookDAO;
import pojo.cbook;

import java.sql.Connection;
import java.util.List;

public class cbookDAOImpl extends BaseDAO implements cbookDAO {
    @Override
    public void insert(Connection connection, cbook cust) {
        String sql="insert into cbook values(?,?,?,?,?,?,?,?)";
        update(connection,sql,cust.getIsbn(),cust.getCless(),cust.getSubclass(),cust.getName(),cust.getAuthor(),cust.getPrice(),cust.getPubdate(),cust.getIntroduction());
    }

    @Override
    public void deleteById(Connection conn, String id) {
        String sql="delete from cbook where isbn=?";
        update(conn,sql,id);
    }

    @Override
    public void updteById(Connection conn, cbook cust, String id) {
        String sql="update cbook set isbn=?,class=?,subclass=?,`name`=?,author=?,price=?,pubdate=?,introduction=? where isbn=?";
        update(conn,sql,cust.getIsbn(),cust.getCless(),cust.getSubclass(),cust.getName(),cust.getAuthor(),cust.getPrice(),cust.getPubdate(),cust.getIntroduction(),id);
    }

    @Override
    public cbook getcbookById(Connection conn, String id) {
        String sql="select isbn,class cless,subclass,`name`,author,price,pubdate,introduction from cbook where isbn=?";
        cbook instance = getInstance(conn, sql, id);
        return instance;
    }

    @Override
    public List<cbook> getAll(Connection conn) {
        String sql="select isbn,class cless,subclass,`name`,author,price,pubdate,introduction from cbook";
        List<cbook> forList = getForList(conn, sql);
        return forList;
    }

}
