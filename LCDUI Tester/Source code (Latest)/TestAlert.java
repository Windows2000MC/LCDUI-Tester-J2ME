
//LCDUI Tester
//List of Alerts
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestAlert implements CommandListener {

private LCDUI midlet;
private List AlertList;
private Command cmdClose;

public TestAlert(LCDUI midlet) {
this.midlet=midlet;

cmdClose=new Command("Back",Command.BACK,2);

String[] AlertType={"INFO","WARNING","ERROR","ALARM","CONFIRMATION"};
AlertList=new List("Test Alert",List.IMPLICIT,AlertType,null);
AlertList.addCommand(cmdClose);
AlertList.setCommandListener(this);
}

public void loadAlert() {
screenAlert();
}

private void screenAlert() {
Display.getDisplay(midlet).setCurrent(AlertList);
}

private void AlertINFO() {
Alert a=new Alert("INFO Alert","This is an info alert!",null,AlertType.INFO);
a.setTimeout(2500);
Display.getDisplay(midlet).setCurrent(a,AlertList);
}

private void AlertWARNING() {
Alert a=new Alert("WARNING Alert","This is a warning alert!",null,AlertType.WARNING);
a.setTimeout(2500);
Display.getDisplay(midlet).setCurrent(a,AlertList);
}

private void AlertERROR() {
Alert a=new Alert("ERROR Alert","This is an error alert!",null,AlertType.ERROR);
a.setTimeout(2500);
Display.getDisplay(midlet).setCurrent(a,AlertList);
}

private void AlertALARM() {
Alert a=new Alert("ALARM Alert","This is an alarm alert!",null,AlertType.ALARM);
a.setTimeout(2500);
Display.getDisplay(midlet).setCurrent(a,AlertList);
}

private void AlertCONFIRMATION() {
Alert a=new Alert("CONFIRMATION Alert","This is a confirmation alert!",null,AlertType.CONFIRMATION);
a.setTimeout(2500);
Display.getDisplay(midlet).setCurrent(a,AlertList);
}

private void functionalAlertList(int index) {
switch (index) {
case 0:
AlertINFO();
break;
case 1:
AlertWARNING();
break;
case 2:
AlertERROR();
break;
case 3:
AlertALARM();
break;
case 4:
AlertCONFIRMATION();
break;
default:
break;
}
}

public void commandAction(Command c, Displayable d) {
if (c==cmdClose) {
midlet.launchApp(); 
} else {
int selectedIndex3 = AlertList.getSelectedIndex();
functionalAlertList(selectedIndex3); 
}
}
}









