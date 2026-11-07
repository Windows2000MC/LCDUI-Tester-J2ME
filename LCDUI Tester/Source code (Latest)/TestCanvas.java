
//LCDUI Tester
//Test Canvas
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestCanvas extends Canvas {

private LCDUI midlet;
private static final int SPLASH_DELAY = 2500;

public TestCanvas(LCDUI midlet) {
this.midlet=midlet;
setFullScreenMode(true);
midlet.playSample();
}

protected void paint(Graphics g) {
g.setColor(0x000000);
g.fillRect(0, 0, getWidth(), getHeight());
try {
g.setColor(0xffffff);
g.drawString("Canvas is supported!",getWidth()/2,getHeight()/2,Graphics.HCENTER|Graphics.BASELINE);
g.drawString("Try to run Graphics demos",getWidth()/2,(getHeight())-40,Graphics.HCENTER|Graphics.BASELINE);
g.setColor(0xffffff);
g.fillRect(0,getHeight()-20,getWidth(),getHeight());
g.setColor(0x000000);
g.drawString("Press any key to return",getWidth()/2,getHeight()-2,Graphics.HCENTER|Graphics.BASELINE);
} catch (Exception e) {}
}

private void stop() {
try {
midlet.stopSample();
midlet.launchApp();
} catch (InterruptedException e) {}
}

protected  void keyPressed(int k) {
stop();
}
}















