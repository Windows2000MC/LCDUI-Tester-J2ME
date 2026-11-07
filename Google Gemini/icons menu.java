package com.example.menuicons;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MenuIconMidlet extends MIDlet implements CommandListener, ItemStateListener {
    private Display display;
    private List menuList;
    private Command exitCommand;
    private Command selectCommand;

    public MenuIconMidlet() {
        display = Display.getH(this); // Wait, use Display.getDisplay(this)
    }

    public void startApp() {
        display = Display.getDisplay(this);

        try {
            // Load small PNG icons from the /images package or root directory
            Image icon1 = Image.createImage("/icon_home.png");
            Image icon2 = Image.createImage("/icon_settings.png");
            Image icon3 = Image.createImage("/icon_exit.png");

            // Create a List with IMPLICIT selection mode and icons
            String[] menuTitles = { "Home", "Settings", "Exit" };
            Image[] menuIcons = { icon1, icon2, icon3 };

            menuList = new List("Main Menu", List.IMPLICIT, menuTitles, menuIcons);

            exitCommand = new Command("Exit", Command.EXIT, 1);
            selectCommand = new Command("Select", Command.ITEM, 1);

            menuList.addCommand(exitCommand);
            menuList.setCommandListener(this);

        } catch (Exception e) {
            // Fallback if images fail to load
            String[] menuTitles = { "Home", "Settings", "Exit" };
            menuList = new List("Main Menu", List.IMPLICIT, menuTitles, null);
            menuList.setCommandListener(this);
        }

        display.setCurrent(menuList);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == List.SELECT_COMMAND || c == selectCommand) {
            int selectedIndex = menuList.getSelectedIndex();
            String choice = menuList.getString(selectedIndex);

            if (choice.equals("Exit")) {
                destroyApp(false);
            } else {
                Alert alert = new Alert("Selection", "You selected: " + choice, null, AlertType.INFO);
                alert.setTimeout(Alert.DEFAULT_FOREVER);
                display.setCurrent(alert, menuList);
            }
        } else if (c == exitCommand) {
            destroyApp(false);
        }
    }
}