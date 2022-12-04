package DAO.BaseDao;

import Util.JDBCUtil;
import pojo.cbook;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {
    private Class<cbook> clazz= cbook.class;

    //通用的增删改操作
    public int update(Connection conn, String sql, Object...args){
        PreparedStatement ps = null;
        try {
            //预编译Sql，返回prepareStatement的实例
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数声明错误
            }
            //执行
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            JDBCUtil.closeFile(null, ps);
        }
        return 0;
    }
    //通用的查询操作，用于返回数据表中的一条记录（考虑事务）
    public cbook getInstance(Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //预编译Sql;
            ps = connection.prepareStatement(sql);
            //提供占位符：从一开始
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //获取结果集
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsda = rs.getMetaData();
            //获取列数
            int columnCount = rsda.getColumnCount();
            if(rs.next()){
                cbook t=clazz.newInstance();//提供一个空参构造器，往里面存储数据
                for(int i=0;i<columnCount;i++){
                    //获取列的具体值，便于往空参构造器里存储
                    Object value = rs.getObject(i + 1);
                    //获取具体的别名，如果没有别名，就获取列名
                    String columnLabel = rsda.getColumnLabel(i + 1);
                    //通过反射往具体属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                return t;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeFile(null,ps,rs);
        }
        return null;
    }
    //通用的查询操作，用于返回数据表中的多条记录
    public List<cbook> getForList(Connection connection, String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //预编译Sql;
            ps = connection.prepareStatement(sql);
            //提供占位符：从一开始
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //获取结果集
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsda = rs.getMetaData();
            //获取列数
            int columnCount = rsda.getColumnCount();
            //创建集合对象
            ArrayList<cbook> list=new ArrayList<>();
            while (rs.next()){
                cbook t=clazz.newInstance();//提供一个空参构造器，往里面存储数据
                for(int i=0;i<columnCount;i++){
                    //获取列的具体值，便于往空参构造器里存储
                    Object value = rs.getObject(i + 1);
                    //获取具体的别名，如果没有别名，就获取列名
                    String columnLabel = rsda.getColumnLabel(i + 1);
                    //通过反射往具体属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeFile(null,ps,rs);
        }
        return null;
    }

}
