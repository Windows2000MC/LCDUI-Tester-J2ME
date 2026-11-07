
//LCDUI Tester
//Test StringItem and Item (merged)
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestStringItem implements CommandListener {

private LCDUI midlet;
private Form TestString, TestItem;
private Command cmdClose, cmdButton, cmdLink;
private StringItem Normal, Button, Link;

public TestStringItem(LCDUI midlet) {
this.midlet=midlet;

cmdClose=new Command("Back",Command.BACK,2);
cmdLink=new Command("Link",Command.ITEM,2);
cmdButton=new Command("Button",Command.ITEM,2);

Normal=new StringItem("HTTP Code :","302");
Button=new StringItem("","Click to get free Robux!",Item.BUTTON);
Link=new StringItem("","http://www.dedomil.net/",Item.HYPERLINK);

Link.setDefaultCommand(cmdLink);
Button.setDefaultCommand(cmdButton);

TestString=new Form("Test StringItem");
TestItem=new Form("Test Item");

TestString.append(Normal);
TestString.append("\nBold text -> Result Header\nPlain text -> Result output\n\nTo change the output, use setText(java.lang.String)");
TestString.addCommand(cmdClose);
TestString.setCommandListener(this);

TestItem.append("Item.BUTTON\nShows clickable buttons on Form\n");
TestItem.append(Button);
TestItem.append("\nItem.HYPERLINK\nShows clickable web links in Form, if supported");
TestItem.append(Link);
TestItem.addCommand(cmdClose);
TestItem.setCommandListener(this);
}

public void loadStringItem() {
screenStringItem();
}

public void loadItem() {
screenItem();
}

private void screenStringItem() {
Display.getDisplay(midlet).setCurrent(TestString);
}

private void screenItem() {
Display.getDisplay(midlet).setCurrent(TestItem);
}

public void commandAction(Command c, Displayable d) {
midlet.launchApp();
}
}




