package service.Impl;

import DAO.cbookImpl.Impl.cbookDAOImpl;
import Util.JDBCUtil;
import pojo.cbook;
import service.cbookService;

import java.sql.Connection;
import java.util.List;

public class cbookServiceImpl implements cbookService {
    cbookDAOImpl cbookDAO = new cbookDAOImpl();
    @Override
    public List<cbook> outPutCbook() {
        Connection connection=null;
        try {
            connection = JDBCUtil.getConnection();
            List<cbook> all = cbookDAO.getAll(connection);
            return all;
        } catch (Exception e) {
            System.out.println("文本信息获取不到");
        }
        finally {
            JDBCUtil.closeFile(connection,null);
        }
        return null;
    }

    @Override
    public cbook outPutCbook(String id) {
        Connection connection=null;
        try {
            connection = JDBCUtil.getConnection();
            cbook cbook = cbookDAO.getcbookById(connection, id);
            return cbook;
        } catch (Exception e) {
            System.out.println("书籍信息查询不到");
        }
        finally {
            JDBCUtil.closeFile(connection,null);
        }
        return null;
    }

    @Override
    public void deleteImpl(String id) {
        Connection connection=null;
        try {
            connection = JDBCUtil.getConnection();
            cbookDAO.deleteById(connection,id);
        } catch (Exception e) {
            System.out.println("删除失败");
        }
        finally {
            JDBCUtil.closeFile(connection,null);
        }
    }

    @Override
    public void insertImpl(cbook cbook) {
        Connection connection=null;
        try {
            connection = JDBCUtil.getConnection();
//            Date date = Date.valueOf("2009-01-01");
            cbookDAO.insert(connection,cbook);
        } catch (Exception e) {
            System.out.println("插入信息失败");

        }
        finally {
            JDBCUtil.closeFile(connection,null);
        }
    }

    @Override
    public void updateImpl(cbook cbook, String id) {
        Connection connection=null;
        try {
            connection = JDBCUtil.getConnection();
            cbookDAO.updteById(connection,cbook,id);
        } catch (Exception e) {
            System.out.println("文本信息获取不到");

        }
        finally {
            JDBCUtil.closeFile(connection,null);
        }
    }


}
