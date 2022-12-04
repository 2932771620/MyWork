package view.component;

import service.Impl.cbookServiceImpl;
import view.cbookGUI.Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteBookDialog extends JDialog {
    Component component=null;
    service.cbookService cbookService = new cbookServiceImpl();
    final int WIDTH=500;
    final int HEIGHT=150;
    //
    public deleteBookDialog(JFrame jf, boolean isModel, String title){
        super(jf, title, isModel);
        this.setBounds((Final.SCREEN_W-WIDTH)/2,(Final.SCREEN_H-HEIGHT)/2,WIDTH,HEIGHT);
        Box vBox = Box.createVerticalBox();
        //组装
        //文本信息空间
        Box horizontalBox1 = Box.createHorizontalBox();
        JLabel jLabel = new JLabel("输入你要删除的isbn号码");
        JTextField jTextField = new JTextField(10);
        horizontalBox1.add(jLabel);
        horizontalBox1.add(Box.createHorizontalStrut(10));
        horizontalBox1.add(jTextField);
        vBox.add(Box.createVerticalStrut(10));
        vBox.add(horizontalBox1);
        //删除按钮
        Box horizontalBox = Box.createHorizontalBox();
        JButton btn=new JButton();//添加模块
        btn.setText("删除");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String trim = jTextField.getText().trim();
                    if(trim!=null){
                        cbookService.deleteImpl(trim);
                        JOptionPane.showMessageDialog(component, "删除成功");
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(component, "删除失败");
                        dispose();

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(component, "删除失败");
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
