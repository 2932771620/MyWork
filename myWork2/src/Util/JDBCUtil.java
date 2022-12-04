package Util;

import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //读取配置文件的4个基本信息
        String url="jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=UTF8";
        String user="root";
        String password="abc123";
        //加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 关闭资源
     * @param pre Statement资源
     * @param con 连接资源
     */
    public static void closeFile(Connection con, Statement pre){
        try {
            if(con!=null){
                con.close();
            }
            if(pre!=null){
                pre.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeFile(Connection con, Statement pre, ResultSet rs){
        try {
            if(con!=null){
                con.close();
            }
            if(pre!=null){
                pre.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
