package service;

import pojo.cbook;

import java.util.List;

public interface cbookService {
    //按照分页给图形用户界面上输入信息
    List<cbook> outPutCbook();
    //按照isbn查找书籍信息
    cbook outPutCbook(String id);
    //删除功能的实现
    void deleteImpl(String id);
    //插入功能的实现
    void insertImpl(cbook cbook);
    //更改功能的实现
    void updateImpl(cbook cbook,String id);
}
