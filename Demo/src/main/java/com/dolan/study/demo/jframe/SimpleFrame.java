package com.dolan.study.demo.jframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimpleFrame extends JFrame {
  private static final int DEFAULT_WIDTH=300;
  private static final int DEFAULT_HEIGHT=200;
  
  private JPanel jp1=new JPanel();
  private JPanel jp2=new JPanel();
  private JTextArea jaInput = new JTextArea();
  private JTextArea jaOutput = new JTextArea();
  private JButton jBtn = new JButton();
  
  public SimpleFrame(){
    Container box = getContentPane();
    box.setLayout(new BorderLayout());//初始化边界布局管理器
    box.add(jp1,BorderLayout.NORTH);//添加到容器中
    box.add(jp2, BorderLayout.SOUTH);
    
    
    jBtn.setText("转换");
    jBtn.addActionListener(
          new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              String input = jaInput.getText();
              
            }
          }
        );

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSzie = kit.getScreenSize();
    setSize(screenSzie.width,screenSzie.height);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
