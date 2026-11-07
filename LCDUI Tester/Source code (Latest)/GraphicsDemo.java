
//LCDUI Tester
//List of Graphics Demos
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class GraphicsDemo implements CommandListener {

private LCDUI midlet;
private List gList;
private Command cmdClose;

public GraphicsDemo(LCDUI midlet) {
this.midlet=midlet;

String[] DemoList={"3D Cube [No M3G Support]"};
gList=new List("Graphics Demos",List.IMPLICIT,DemoList,null);

cmdClose=new Command("Back",Command.BACK,2);
gList.addCommand(cmdClose);
gList.setCommandListener(this);
}

public void loadGraphicsDemos() {
screenGraphicsList();
}

private void screenGraphicsList() {
Display.getDisplay(midlet).setCurrent(gList);
}

private void functionalGraphicsList(int index) {
switch (index) {
case 0:
midlet.loadCube3D();
break;
default:
break;
}
}

public void commandAction(Command c, Displayable d) {
if (c==cmdClose) {
midlet.launchApp();
} else {
int selectedIndex2 = gList.getSelectedIndex();
functionalGraphicsList(selectedIndex2);
}
}
}
















