import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

public class SplashApp extends MIDlet {
    private Display display;
    private SplashScreen splashScreen;
    private Form mainForm;

    public SplashApp() {
        display = Display.getDisplay(this);
    }

    protected void startApp() {
        // Initialize the splash screen and pass a reference of this MIDlet
        splashScreen = new SplashScreen(this);
        display.setCurrent(splashScreen);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }

    // Method called by the splash screen once the timer expires
    public void showMainScreen() {
        mainForm = new Form("Main Application");
        mainForm.append(new StringItem("Welcome!", "The main application is now running."));
        display.setCurrent(mainForm);
        
        // Free up memory by clearing the splash screen reference
        splashScreen = null;
    }
}





import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class SplashScreen extends Canvas implements Runnable {
    private SplashApp midlet;
    private Image splashImage;
    private static final int SPLASH_DELAY = 3000; // 3 seconds in milliseconds

    public SplashScreen(SplashApp midlet) {
        this.midlet = midlet;
        
        // Fullscreen mode removes the operator header and softkey bar
        setFullScreenMode(true); 

        // Attempt to load the application icon/splash image
        try {
            splashImage = Image.createImage("/icon.png");
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        // Start the background thread for the timer delay
        Thread t = new Thread(this);
        t.start();
    }

    protected void paint(Graphics g) {
        // Clear screen with a white background
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (splashImage != null) {
            // Draw the icon exactly in the center of the screen
            int x = getWidth() / 2;
            int y = getHeight() / 2;
            g.drawImage(splashImage, x, y, Graphics.HCENTER | Graphics.VCENTER);
        } else {
            // Fallback text if the image fails to load
            g.setColor(0x000000);
            g.drawString("Loading Application...", getWidth() / 2, getHeight() / 2, Graphics.HCENTER | Graphics.BASELINE);
        }
    }

    public void run() {
        try {
            // Wait for the specified duration
            Thread.sleep(SPLASH_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Switch to the main application screen
        midlet.showMainScreen();
    }

    // Optional: Allow users to skip the splash screen by pressing any key
    protected void keyPressed(int keyCode) {
        midlet.showMainScreen();
    }
}