package com.charan.test;

import net.sf.jcarrierpigeon.WindowPosition;
import net.sf.jtelegraph.Telegraph;
import net.sf.jtelegraph.TelegraphQueue;
import net.sf.jtelegraph.TelegraphType;

public class Msgnotifitest {
  public static void main(String[] args) {
    Telegraph tele = new Telegraph("Health Care Notification", "Drink water 5 Litre's every day",
        TelegraphType.COFFEE, WindowPosition.BOTTOMRIGHT, 5000);
    TelegraphQueue q = new TelegraphQueue();
    q.add(tele);
  }
}
