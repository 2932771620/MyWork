package DAO.cbookImpl;

import pojo.cbook;

import java.sql.Connection;
import java.util.List;

public interface cbookDAO {
    //将cbook的对象插入表中
    void insert(Connection connection, cbook cust);
    //删除cbook表中的指定数据
    void deleteById(Connection conn, String id);

    //针对表中的cust对象，去修改数据表中指定的记录
    void updteById(Connection conn,cbook cust,String id);

    //针对指定Id去查询对应的cbook对象
    cbook getcbookById(Connection conn, String id);

    //查询表中的所有记录构成的集合

    List<cbook> getAll(Connection conn);

}
