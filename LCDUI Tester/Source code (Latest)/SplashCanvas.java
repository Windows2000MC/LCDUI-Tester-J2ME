
//LCDUI Tester
//Splash
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class SplashCanvas extends Canvas implements Runnable {

private LCDUI midlet;
private Image splashImage;
private static final int SPLASH_DELAY = 3000;

public SplashCanvas(LCDUI midlet) {
this.midlet=midlet;
setFullScreenMode(true);
try {
splashImage = Image.createImage("/Resources/Splash/Windows2000MC_Small.png");
} catch (Exception e) {}
new Thread(this).start();
}

protected void paint(Graphics g) {
g.setColor(0xFFFFFF);
g.fillRect(0, 0, getWidth(), getHeight());
if (splashImage != null) {
int x = getWidth() / 2;
int y = getHeight() / 2;
g.drawImage(splashImage, 49, y-10, Graphics.HCENTER | Graphics.VCENTER);
g.setColor(0x000000);
g.drawString("Windows2000MC", 140, getHeight()/2, Graphics.HCENTER | Graphics.BASELINE);
g.drawString("Java 2 Micro Edition", getWidth() / 2, 300, Graphics.HCENTER | Graphics.BASELINE);
} else {
g.setColor(0x000000);
g.drawString("Windows2000MC", getWidth()/2, getHeight() / 2, Graphics.HCENTER | Graphics.BASELINE);
g.drawString("Java 2 Micro Edition", getWidth()/2, 300, Graphics.HCENTER | Graphics.BASELINE);
}
}

public void run() {
try {
Thread.sleep(SPLASH_DELAY);
} catch (InterruptedException e) {}
midlet.launchApp();
}
}











