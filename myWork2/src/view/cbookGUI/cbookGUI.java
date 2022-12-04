package view.cbookGUI;

import view.component.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cbookGUI {
    JFrame jf=new JFrame(Final.TITLE);

    //组装试图
    public void init(){
        //给窗口设置属性
        jf.setSize(Final.FRAME_W,Final.FRAME_H);
        jf.setLayout(new BorderLayout());
        jf.setResizable(false);
        jf.setLocation(Final.FRAME_Y,Final.FRAME_X);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        JPanel jPanel=new JPanel();
//        jPanel.add(new UseMangerComponent(jf));
//        jPanel.setLayout(new GridLayout(1,1,Final.FRAME_W,Final.FRAME_H));
//        jf.add(jPanel);//将面板添加进去
//        jf.setVisible(true);
        //给窗口设置属性
        jf.setSize(Final.FRAME_W,Final.FRAME_H);
        jf.setLayout(new BorderLayout());
        jf.setResizable(false);
        jf.setLocation(Final.FRAME_Y,Final.FRAME_X);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置分割面板
        JSplitPane jSplitPane = new JSplitPane();

        //支持连续布局
        jSplitPane.setContinuousLayout(true);
        jSplitPane.setDividerLocation(150);
        jSplitPane.setDividerSize(7);
//        设计刷新按钮
        JButton addBtn=new JButton("刷新");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jSplitPane.setRightComponent(new UseMangerComponent(jf));
                jSplitPane.setDividerLocation(150);
            }
        });
        jSplitPane.setRightComponent(new UseMangerComponent(jf));
        jSplitPane.setLeftComponent(addBtn);
        jf.add(jSplitPane);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new cbookGUI().init();
    }
}

