
//LCDUI Tester
//Test ChoiceGroup inside Form UI (separate)
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;
import java.io.IOException;

public class TestChoiceGroup implements CommandListener {

private LCDUI midlet;
private ChoiceGroup Permission, Color;
private Command cmdClose;
private Image Red, Green, Blue;

public TestChoiceGroup(LCDUI midlet) {
this.midlet=midlet;
}

public void loadTestChoiceGroup() {
screenTestChoiceGroup();
}

private void screenTestChoiceGroup() {
Form TestChoiceGroup=new Form("Test ChoiceGroup");
try {
Red=Image.createImage("/Resources/TestChoiceGroup/Red.png");
Green=Image.createImage("/Resources/TestChoiceGroup/Green.png");
Blue=Image.createImage("/Resources/TestChoiceGroup/Blue.png");
String[] Choice={"Allow all","Allow while using this application","Deny all"};
String[] Multi={"Red","Green","Blue"};
Image[] RGB={Red,Green,Blue};
Permission=new ChoiceGroup("App permissions :",ChoiceGroup.EXCLUSIVE,Choice,null);
Color=new ChoiceGroup("Select RGB Colors :",ChoiceGroup.MULTIPLE,Multi,RGB);
TestChoiceGroup.append(Permission);
TestChoiceGroup.append(Color);
TestChoiceGroup.append("'EXCLUSIVE' type ChoiceGroup only takes 1 choice\n'MULTIPLE' type ChoiceGroup takes 2 or more choices");
} catch (Exception e) {
String[] Choice={"Allow all","Allow while using this application","Deny all"};
String[] Multi={"Red","Green","Blue"};
Permission=new ChoiceGroup("App permissions :",ChoiceGroup.EXCLUSIVE,Choice,null);
Color=new ChoiceGroup("Select RGB Colors :",ChoiceGroup.MULTIPLE,Multi,null);
TestChoiceGroup.append(Permission);
TestChoiceGroup.append(Color);
TestChoiceGroup.append("'EXCLUSIVE' type ChoiceGroup only takes 1 choice\n'MULTIPLE' type ChoiceGroup takes 2 or more choices");
}
cmdClose=new Command("Back",Command.BACK,2);
TestChoiceGroup.addCommand(cmdClose);
TestChoiceGroup.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(TestChoiceGroup);
}
    
public void commandAction(Command c, Displayable dis) {
midlet.launchApp();
}
}


















