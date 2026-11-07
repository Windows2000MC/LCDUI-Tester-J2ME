
//LCDUI Tester
//Test Menu List with icons (separate)
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;
import java.io.IOException;

public class TestMenu implements CommandListener {

private LCDUI midlet;
private Command cmdClose;
private List TestMenu;
private Image APK, Settings, Camera, File, Phone;

public TestMenu(LCDUI midlet) {
this.midlet=midlet;
}

public void loadTestMenu() {
screenTestMenu();
}

private void screenTestMenu() {
try {
APK=Image.createImage("/Resources/TestMenu/APK.png");
Settings=Image.createImage("/Resources/TestMenu/Settings.png");
Camera=Image.createImage("/Resources/TestMenu/Camera.png");
File=Image.createImage("/Resources/TestMenu/File.png");
Phone=Image.createImage("/Resources/TestMenu/Phone.png");
Image[] Appicons={APK,Settings,Camera,File,Phone};
String[] MenuItems={"APK Installer","Settings","Camera","File Manager Advance","Call History"};
TestMenu=new List("App Launcher",List.IMPLICIT,MenuItems,Appicons);
} catch (Exception exc) {
String[] MenuItems={"APK Installer","Settings","Camera","File Manager Advance","Call History"};
TestMenu=new List("App Launcher",List.IMPLICIT,MenuItems,null);
}
cmdClose=new Command("Back",Command.BACK,2);
TestMenu.addCommand(cmdClose);
TestMenu.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(TestMenu);
}

public void commandAction(Command c, Displayable dis) {
midlet.launchApp();
}
}





