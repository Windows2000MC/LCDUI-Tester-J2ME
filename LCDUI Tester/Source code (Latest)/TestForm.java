
//LCDUI Tester
//Test Form UI (separate)
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestForm implements CommandListener {

private LCDUI midlet;
private Command cmdClose;

public TestForm(LCDUI midlet) {
this.midlet=midlet;
}

public void loadTestForm() {
screenTestForm();
}

private void screenTestForm() {
Form TestForm=new Form("Test Form");
TestForm.append("This is a Form, you can add an ImageItem, TextField, ChoiceGroup and many more!");
cmdClose=new Command("Back",Command.BACK,2);
TestForm.addCommand(cmdClose);
TestForm.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(TestForm);
}

public void commandAction(Command c, Displayable dis) {
midlet.launchApp();
}
}







