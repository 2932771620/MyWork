package view.component;

import pojo.cbook;
import service.Impl.cbookServiceImpl;
import view.cbookGUI.Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectUpdateBookDialog extends JDialog {
    Component component=null;
    service.cbookService cbookService = new cbookServiceImpl();
    final int WIDTH=500;
    final int HEIGHT=150;
    //
    public SelectUpdateBookDialog(JFrame jf, boolean isModel, String title){
        super(jf, title, isModel);
        this.setBounds((Final.SCREEN_W-WIDTH)/2,(Final.SCREEN_H-HEIGHT)/2,WIDTH,HEIGHT);
        Box vBox = Box.createVerticalBox();
        //组装
        //文本信息空间
        Box horizontalBox1 = Box.createHorizontalBox();
        JLabel jLabel = new JLabel("输入你要查找的isbn号码");
        JTextField jTextField = new JTextField(10);
        horizontalBox1.add(jLabel);
        horizontalBox1.add(Box.createHorizontalStrut(10));
        horizontalBox1.add(jTextField);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(horizontalBox1);
        //查询按钮
        Box horizontalBox = Box.createHorizontalBox();
        JButton btn=new JButton();//添加模块
        btn.setText("查询");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trim = jTextField.getText().trim();
                cbook cbook = cbookService.outPutCbook(trim);
                if(cbook!=null){
                    ArrayList<String> list=new ArrayList<>();
                    list.add(cbook.getIsbn());
                    list.add(cbook.getCless());
                    list.add(cbook.getSubclass());
                    list.add(cbook.getName());
                    list.add(cbook.getAuthor());
                    list.add(String.valueOf(cbook.getPrice()));
                    list.add(String.valueOf(cbook.getPubdate()));
                    list.add(cbook.getIntroduction());
                    new updateBookDialog(jf,isModel,title,list,trim).setVisible(true);
                    dispose();

                }else {
                    JOptionPane.showMessageDialog(component,"未找到");
                    dispose();

                }
            }
        });
        btn.setPreferredSize(new Dimension(60,44));//给模块赋值大小
        btn.setFont(new Font("粗体",Font.BOLD,20));//调节模块中字体的值的大小
        horizontalBox.add(btn);
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
