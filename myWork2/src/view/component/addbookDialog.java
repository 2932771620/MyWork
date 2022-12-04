package view.component;

import pojo.cbook;
import service.Impl.cbookServiceImpl;
import view.cbookGUI.Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class addbookDialog extends JDialog {
    Component component=null;
    service.cbookService cbookService = new cbookServiceImpl();
    final int WIDTH=500;
    final int HEIGHT=500;
    //
    public addbookDialog(JFrame jf,boolean isModel,String title){
        super(jf, title, isModel);
        this.setBounds((Final.SCREEN_W-WIDTH)/2,(Final.SCREEN_H-HEIGHT)/2,WIDTH,HEIGHT);
        Box vBox = Box.createVerticalBox();
        //组装
        String[] str=new String[]{"isbn","class","subclass","name","author","price","pubdate","introduction" };
        ArrayList<String> arrayList=new ArrayList<>();
        ArrayList<JTextField> arrayList1=new ArrayList<>();

        for(int i=0;i<str.length;i++){
            Box horizontalBox = Box.createHorizontalBox();
            JLabel jLabel = new JLabel(str[i]);
            JTextField jTextField = new JTextField(10);
            arrayList1.add(jTextField);
            jTextField.setPreferredSize(new Dimension(240,30));
            horizontalBox.add(jLabel);
            horizontalBox.add(Box.createHorizontalStrut(10));
            horizontalBox.add(jTextField);
            vBox.add(Box.createVerticalStrut(10));
            vBox.add(horizontalBox);
        }
        Box horizontalBox = Box.createHorizontalBox();
        JButton btn=new JButton();//添加模块
        btn.setText("添加");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //获取用户的录入
                    for (int i=0;i<8;i++){
                        String trim = arrayList1.get(i).getText().trim();
                        arrayList.add(trim);
                    }
                    cbook cust=new cbook(arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),Float.parseFloat(arrayList.get(5)), Date.valueOf(arrayList.get(6)),arrayList.get(7));
                    if(cust!=null){
                        cbookService.insertImpl(cust);
                        JOptionPane.showMessageDialog(component,"添加成功");
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(component,"输入为空");
                        dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(component,"添加失败，请检查数据");
                }
            }
        });
        btn.setPreferredSize(new Dimension(60,44));//给模块赋值大小
        btn.setFont(new Font("粗体",Font.BOLD,20));//调节模块中字体的值的大小
        horizontalBox.add(btn);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(horizontalBox);
        //增加间距
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));
        this.add(hBox);
    }


}