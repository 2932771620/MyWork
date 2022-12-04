package view.cbookGUI;

import java.awt.*;

public class Final {
    public static final int FRAME_W = 1000;//窗口宽
    public static final int FRAME_H = 600;//窗口高
    public static final int SCREEN_W = Toolkit.getDefaultToolkit().getScreenSize().width;//屏幕的宽
    public static final int SCREEN_H = Toolkit.getDefaultToolkit().getScreenSize().height;//屏幕的高
    public static final int FRAME_X = (SCREEN_H - FRAME_H) / 2;//窗口所位于的中心位置
    public static final int FRAME_Y = (SCREEN_W - FRAME_W) / 2;
    public static final String TITLE = "书本信息管理系统";//窗口的标题
}
