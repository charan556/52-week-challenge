package com.charan.test;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GNotification {
  public static void main(String[] args) {
    String message = "You got a new notification message. Isn't it awesome to have such a notification message.";
    String header = "This is header of notification message";

    ImageIcon headingIcon = new ImageIcon("glass.jpg");

    final JFrame frame = new JFrame();
    frame.setSize(350, 200);
    frame.setUndecorated(true);

    Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
    Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the
                                                                                                      // task bar
    frame.setLocation((scrSize.width - 100) - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());
    frame.setAlwaysOnTop(true);
    frame.setLayout(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1.0f;
    constraints.weighty = 1.0f;
    constraints.insets = new Insets(5, 5, 5, 5);
    constraints.fill = GridBagConstraints.BOTH;
    
    JLabel headingLabel = new JLabel(header);
    headingLabel.setIcon(headingIcon); // --- use image icon you want to be as heading image.
    headingLabel.setOpaque(false);
    frame.add(headingLabel, constraints);
    constraints.gridx++;
    constraints.weightx = 0f;
    constraints.weighty = 0f;
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.NORTH;
    // JButton cloesButton = new JButton("X");
    
    JButton cloesButton = new JButton(new AbstractAction("x") {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(final ActionEvent e) {
        frame.dispose();
      }
    });
    cloesButton.setMargin(new Insets(1, 4, 1, 4));
    cloesButton.setFocusable(false);
    frame.add(cloesButton, constraints);
    constraints.gridx = 0;
    constraints.gridy++;
    constraints.weightx = 1.0f;
    constraints.weighty = 1.0f;
    constraints.insets = new Insets(5, 5, 5, 5);
    constraints.fill = GridBagConstraints.BOTH;
    JLabel messageLabel = new JLabel("<HtMl>" + message);
    frame.add(messageLabel, constraints);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);

    new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(5000); // time after which pop up will be disappeared.
          frame.dispose();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      };
    }.start();
  }
}
