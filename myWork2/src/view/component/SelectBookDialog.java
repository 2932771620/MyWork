package view.component;

import pojo.cbook;
import service.Impl.cbookServiceImpl;
import view.cbookGUI.Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectBookDialog extends JDialog {
    Component component=null;
    service.cbookService cbookService = new cbookServiceImpl();
    final int WIDTH=800;
    final int HEIGHT=150;
    //
    public SelectBookDialog(JFrame jf, boolean isModel, String title){

        super(jf, title, isModel);

        this.setBounds((Final.SCREEN_W-WIDTH)/2,(Final.SCREEN_H-HEIGHT)/2,WIDTH,HEIGHT);
        Box vBox = Box.createVerticalBox();
        //组装
        //文本信息空间
        Box horizontalBox1 = Box.createHorizontalBox();
        JLabel jLabel = new JLabel("输入你要查找的isbn号码");
        JTextField InputJTextField = new JTextField(10);
        horizontalBox1.add(jLabel);
        InputJTextField.setPreferredSize(new Dimension(100,30));
        horizontalBox1.add(Box.createHorizontalStrut(10));
        horizontalBox1.add(InputJTextField);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(horizontalBox1);
        Box horizontalBox2= Box.createHorizontalBox();
        JLabel jLabel1 = new JLabel("书籍：");
        JTextField OutputJTextField = new JTextField(10);
        horizontalBox2.add(jLabel1);
        OutputJTextField.setPreferredSize(new Dimension(700,30));
        horizontalBox2.add(OutputJTextField);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(horizontalBox2);
        //查询按钮
        Box horizontalBox = Box.createHorizontalBox();
        JButton btn=new JButton();//添加模块
        btn.setText("查询");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String trim = InputJTextField.getText().trim();
                    cbook cbook = cbookService.outPutCbook(trim);

                    if(cbook!=null){
                        OutputJTextField.setText(cbook.toString());
                    }else {
                        JOptionPane.showMessageDialog(component,"未找到");
                        dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
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
