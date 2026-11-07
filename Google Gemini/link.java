import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDletStateChangeException;

public class LinkMIDlet extends MIDlet implements CommandListener, ItemCommandListener {

    private Display display;
    private Form mainForm;
    private StringItem clickLink;
    private Command exitCommand;
    private Command linkCommand;
    
    // The target URL to open
    private final String targetUrl = "https://google.com";

    public LinkMIDlet() {
        // Initialize the display and the main container form
        display = Display.getDisplay(this);
        mainForm = new Form("J2ME Clickable Link Example");

        // Create an Exit command for the application
        exitCommand = new Command("Exit", Command.EXIT, 1);
        mainForm.addCommand(exitCommand);
        mainForm.setCommandListener(this);

        // 1. Create a StringItem with HYPERLINK appearance
        clickLink = new StringItem("", "Click here to visit Google", Item.HYPERLINK);

        // 2. Create an invisible command to attach to the item
        linkCommand = new Command("Go", Command.ITEM, 1);
        clickLink.setDefaultCommand(linkCommand);

        // 3. Set the listener specifically for item events
        clickLink.setItemCommandListener(this);

        // Add the link item to the form
        mainForm.append(clickLink);
    }

    protected void startApp() throws MIDletStateChangeException {
        // Make the form visible on the screen
        display.setCurrent(mainForm);
    }

    protected void pauseApp() {
        // Handle pause logic if necessary
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        // Cleanup code
    }

    // Handles standard form commands (like Exit)
    public void commandAction(Command c, Displayable d) {
        if (c == exitCommand) {
            notifyDestroyed();
        }
    }

    // Handles item clicks (the clickable link)
    public void commandAction(Command c, Item item) {
        if (item == clickLink && c == linkCommand) {
            try {
                // Request the device browser to open the URL
                platformRequest(targetUrl);
            } catch (Exception e) {
                // Handle exceptions (e.g., if the device platform doesn't support the request)
                clickLink.setText("Error opening link: " + e.getMessage());
            }
        }
    }
}