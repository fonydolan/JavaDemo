package com.dolan.study.demo.events;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerEvent implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    Date now = new Date();
    System.out.println("timer test "+now);
    Toolkit.getDefaultToolkit().beep();
  }

}
