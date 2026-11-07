
//LCDUI Tester
//Test TextField
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestTextField implements CommandListener {

private LCDUI midlet;
private Form TextFieldTest;
private TextField TextANY, TextDECIMAL, TextEMAILADD, TextNUMERIC, TextPASSWORD, TextPHONENUM,TextURL;
private Command cmdClose;

public TestTextField(LCDUI midlet) {
this.midlet=midlet;

TextANY=new TextField("ANY","You can write any text, symbols!",256,TextField.ANY); 
TextDECIMAL=new TextField("DECIMAL","3.1416",256,TextField.DECIMAL); 
TextEMAILADD=new TextField("EMAILADDR","minedeshbd@gmail.com",256,TextField.EMAILADDR); 
TextNUMERIC=new TextField("NUMERIC","1234567890",256,TextField.NUMERIC); 
TextPASSWORD=new TextField("PASSWORD","1234567890",256,TextField.PASSWORD); 
TextPHONENUM=new TextField("PHONENUMBER","+8801855839214",256,TextField.PHONENUMBER); 
TextURL=new TextField("URL","https://www.google.com/",256,TextField.URL); 

TextFieldTest=new Form("Test TextField");

TextFieldTest.append(TextANY);
TextFieldTest.append(TextDECIMAL);
TextFieldTest.append(TextEMAILADD);
TextFieldTest.append(TextNUMERIC);
TextFieldTest.append(TextPASSWORD);
TextFieldTest.append(TextPHONENUM);
TextFieldTest.append(TextURL);
cmdClose=new Command("Back",Command.BACK,2);
TextFieldTest.addCommand(cmdClose);
TextFieldTest.setCommandListener(this);
}

public void loadTextField() {
screenTextField();
}

private void screenTextField() {
Display.getDisplay(midlet).setCurrent(TextFieldTest);
}

public void commandAction(Command c, Displayable d) {
midlet.launchApp();
}
}








