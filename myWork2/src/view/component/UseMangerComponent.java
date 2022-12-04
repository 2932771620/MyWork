package view.component;

import pojo.cbook;
import service.Impl.cbookServiceImpl;
import service.cbookService;
import view.cbookGUI.Final;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class UseMangerComponent extends Box {

    service.cbookService cbookService = new cbookServiceImpl();
    final int WIDTH=850;
    final int HEIGHT=600;
    private JTable table;
    private Vector<String> titles;
    JFrame jFrame=null;
    private Vector<Vector> tableData=new Vector<>();
    private DefaultTableModel tableModel;
    public UseMangerComponent(JFrame jf) {

        super(BoxLayout.Y_AXIS);
        //组装视图
        JPanel btnPanel=new JPanel();
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));//按钮大小
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));//按钮放置位置
//        设计四个按钮
        JButton addBtn=new JButton("添加");
        JButton deleteBtn=new JButton("删除");
        JButton updateBtn=new JButton("修改");
        JButton selectBtn=new JButton("查询");
        //响应添加按钮
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                弹出对话框
                new addbookDialog(jf,true,"添加图书").setVisible(true);
            }
        });
        //响应删除按钮
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deleteBookDialog(jf,true,"删除图书").setVisible(true);

            }
        });

        //响应修改按钮
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectUpdateBookDialog(jf,true,"修改图书").setVisible(true);
            }
        });

        //响应查询按钮
        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectBookDialog(jf,true,"查找图书").setVisible(true);
            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(selectBtn);
        this.add(btnPanel);
        this.jFrame=jf;
        //组装表格
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        titles=new Vector<>();
        titles.add("isbn");
        titles.add("class");
        titles.add("subclass");
        titles.add("name");
        titles.add("author");
        titles.add("price");
        titles.add("pubdate");
        titles.add("introduction");
        tableData=new Vector<>();
        resquestData(titles);
        //设置只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //添加滚动条
        JScrollPane jScrollPane = new JScrollPane(table);
        this.add(jScrollPane);
    }
    //请求数据
    public void resquestData(Vector<String> titles){
        try {
            //清空tabledata的数据
            tableData.clear();
            List<cbook> cbooks = cbookService.outPutCbook();
            Vector<Vector> data = new Vector<Vector>();
            if(cbooks.size()!=0){
                for (int i=0;i<cbooks.size();i++){
                    Vector vector=new Vector();
                    vector.add(cbooks.get(i).getIsbn());
                    vector.add(cbooks.get(i).getCless());
                    vector.add(cbooks.get(i).getSubclass());
                    vector.add(cbooks.get(i).getName());
                    vector.add(cbooks.get(i).getAuthor());
                    vector.add(cbooks.get(i).getPrice());
                    vector.add(cbooks.get(i).getPubdate());
                    vector.add(cbooks.get(i).getIntroduction());
                    data.add(vector);
                }
                tableModel.setDataVector(data,titles);
            }else {
                tableModel.setDataVector(null,titles);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "系统错误！请仔细检查！");
        }
    }
}
