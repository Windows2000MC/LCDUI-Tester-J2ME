
//LCDUI Tester
//MIDlet (includes small build-in tests and Thread Managment)
//Tanvir Islam
//Windows2000MC

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class LCDUI extends MIDlet implements CommandListener, ItemCommandListener {

private Display d;
private SplashCanvas gSplash;
private TestMenu testmenu;
private TestForm testform;
private TestChoiceGroup testcg;
private TestTextField showTextField;
private SoundEngine Midi;
private TestImageItem showImgItem;
private ExploreScreen scrExplore;
private TestCanvas gCanvas;
private Cube3DCanvas gCube3D;
private TestAlert showAlert;
private GraphicsDemo gDemo;
private TestTicker  loadticker;
private TestStringItem showTestString;
private Form Exit, About, TestDate, TextForm, TextFieldForm, TickerForm, GaugeForm;
private List MainMenu, Options;
private Gauge EditableGauge, NonEditableGauge;
private DateField TestDateField;
private TextBox testTextBox;
private StringItem AppName, YouTubeLink;
private Command cmdExit, cmdOK, cmdExitAPP, cmdBack, cmdOp, cmdOpOK, cmdOpBack, cmdAboutBack, cmdLink;
private Command cmdClose, cmdClose1, cmdClose2;

private final String Link="https://m.youtube.com/@windows2000_mc";
private final String link1add="https://david2me.free.nf/";
private final String link2add="https://nnproject.cc/";

public LCDUI() {
cmdExit=new Command("Exit",Command.BACK,2);
cmdOK=new Command("Ok",Command.OK,1);
cmdOpOK=new Command("Ok",Command.OK,1);
cmdOp=new Command("Options",Command.OK,2);
cmdBack=new Command("Back",Command.BACK,2);
cmdClose=new Command("Back",Command.BACK,2);
cmdClose1=new Command("Back",Command.BACK,2);
cmdClose2=new Command("Back",Command.BACK,2);
cmdOpBack=new Command("Back",Command.BACK,2);
cmdAboutBack=new Command("Back",Command.BACK,2);
cmdExitAPP=new Command("Exit",Command.EXIT,1);
cmdLink=new Command("Go", Command.ITEM, 1);

Midi=new SoundEngine(this);

AppName=new StringItem("LCDUI Tester","");
YouTubeLink=new StringItem("","https://m.youtube.com/@windows2000_mc",Item.HYPERLINK);

EditableGauge=new Gauge("Editable Gauge :",true,100,0);
EditableGauge.setValue(75);
NonEditableGauge=new Gauge("Progress Gauge :",false,100,0);
NonEditableGauge.setValue(75);

TestDateField=new DateField("Input date and time :",DateField.DATE_TIME);

Exit=new Form("");
About=new Form("About");
GaugeForm=new Form("Test Gauge");
TestDate=new Form("Test DateField");

String[] MainMenuList={"Alert","Canvas","ChoiceGroup","DateField","Form","Gauge","Graphics","ImageItem","Item","List","StringItem","TextBox","TextField","Ticker"};
MainMenu=new List("LCDUI Tester",List.IMPLICIT,MainMenuList,null);
MainMenu.addCommand(cmdOK);
MainMenu.addCommand(cmdOp);
MainMenu.setCommandListener(this);

String[] Option={"Explore more...","About","Exit"};
Options=new List("Options",List.IMPLICIT,Option,null);
Options.addCommand(cmdOpOK);
Options.addCommand(cmdOpBack);
Options.setCommandListener(this);

GaugeForm.append(EditableGauge);
GaugeForm.append(NonEditableGauge);
GaugeForm.append("\nYou can make a Gauge can be editable or not by using 'true' and 'false' bool. editable ones has these tiny point out arrows on side to change values and non-editable ones are cannot be changed by human action. it can be changed by using setValue() function. this type gauge is useful for making progress bar!");
GaugeForm.addCommand(cmdClose);
GaugeForm.setCommandListener(this);

TestDate.append(TestDateField);
TestDate.append("\nDateField.DATE -> Only inputs date\nDateField.TIME -> Only inputs time\nDateField.DATE_TIME -> Both inputs date and time");
TestDate.addCommand(cmdClose1);
TestDate.setCommandListener(this);

testTextBox=new TextBox("Test TextBox","TextBox show a gist text in entire screen, ideal for making text editors",250,TextField.ANY);
testTextBox.addCommand(cmdClose2);
testTextBox.setCommandListener(this);

Exit.append("Do you want to exit this application?");
Exit.addCommand(cmdExitAPP);
Exit.addCommand(cmdBack);
Exit.setCommandListener(this);
}

protected void startApp() throws MIDletStateChangeException {
d=Display.getDisplay(this);
gSplash=new SplashCanvas(this);
d.setCurrent(gSplash);
}

protected void pauseApp() {}
protected void destroyApp(boolean unconditional) {}

public void launchApp() {
gSplash=null;
testmenu=null;
testform=null;
testcg=null;
showImgItem=null;
gCanvas=null;
gCube3D=null;
showAlert=null;
gDemo=null;
showTextField=null;
showTestString=null;
scrExplore=null;
loadticker=null;
screenMainMenu();
}

public void loadPublicOptions() {
screenOptions();
}

private void screenMainMenu() {
d.setCurrent(MainMenu);
}

private void screenOptions() {
d.setCurrent(Options);
}

private void exitCom() {
d.setCurrent(Exit);
}

private void screenGauge() {
d.setCurrent(GaugeForm);
}

private void screenDateField() {
d.setCurrent(TestDate);
}

private void showTestAlert() {
showAlert=new TestAlert(this);
showAlert.loadAlert();
}

private void showTestMenu() {
testmenu=new TestMenu(this);
testmenu.loadTestMenu();
}

private void showTestForm() {
testform=new TestForm(this);
testform.loadTestForm();
}

private void showGraphicsDemoList() {
gDemo=new GraphicsDemo(this);
gDemo.loadGraphicsDemos();
}

private void showTestTextField() {
showTextField=new TestTextField(this);
showTextField.loadTextField();
}

private void loadCanvas() {
gCanvas=new TestCanvas(this);
d.setCurrent(gCanvas);
}

public void loadCube3D() {
gCube3D=new Cube3DCanvas(this);
d.setCurrent(gCube3D);
}

public void loadPublicDemoList() {
showGraphicsDemoList();
}

private void showTextBox() {
d.setCurrent(testTextBox);
}

private void showTestChoiceGroup() {
testcg=new TestChoiceGroup(this);
testcg.loadTestChoiceGroup();
}

private void showTestTicker() {
loadticker=new TestTicker(this);
loadticker.loadTestTicker();
}

private void showTestStringItem() {
showTestString=new TestStringItem(this);
showTestString.loadStringItem();
}

private void showTestItem() {
showTestString=new TestStringItem(this);
showTestString.loadItem();
}

private void showImageItem() {
showImgItem=new TestImageItem(this);
showImgItem.loadImgItem();
}

private void loadScreenExplore() {
scrExplore=new ExploreScreen(this);
scrExplore.loadExploreScreen();
}

public void playSample() {
Midi.playPublicMIDI("/Resources/Sound/Canvas.mid",-1);
}

public void stopSample() {
Midi.stopPublicMIDI();
}

private void functionalOptions(int index) {
switch (index) {
case 0:
loadScreenExplore();
break;
case 1:
screenAbout();
break;
case 2:
exitCom();
break;
default:
break;
}
}

private void functionalMenu(int index) {
switch (index) {
case 0:
showTestAlert();
break;
case 1:
loadCanvas();
break;
case 2:
showTestChoiceGroup();
break;
case 3:
screenDateField();
break;
case 4:
showTestForm();
break;
case 5:
screenGauge();
break;
case 6:
showGraphicsDemoList();
break;
case 7:
showImageItem();
break;
case 8:
showTestItem();
break;
case 9:
showTestMenu();
break;
case 10:
showTestStringItem();
break;
case 11:
showTextBox();
break;
case 12:
showTestTextField();
break;
case 13:
showTestTicker();
break;
default:
break;
}
}

private void screenAbout() {
try {
Image MIDletimg=Image.createImage("/Resources/MIDlet/MIDleticon.png");
ImageItem MIDletItem=new ImageItem("LCDUI Tester",MIDletimg,ImageItem.LAYOUT_CENTER,"ImageItem failed to work");
About.append(MIDletItem);
About.append("\nVersion - 1.0\nBy Tanvir Islam\n");
About.append("Written and Compiled on J2ME SDK Mobile on Symphony D54+\nMade in Bangladesh\n");
About.append("\nWindows2000MC\n\n");
About.append(YouTubeLink);
About.append("\n3D Renderer (software)\n\nGenerated by Google Gemini\n\nMenu themed soundtrack - Piano Hero J2ME\n\nBy InLogic Software");
About.append("\n\nMIT Licence\n\nThis program is freeware. You can modify it and/or redisturbute it as long as you keep the original author's name and program itself under the terms of MIT Licence."); 
} catch (Exception e) {}
YouTubeLink.setDefaultCommand(cmdLink);
YouTubeLink.setItemCommandListener(this);
About.addCommand(cmdAboutBack);
About.setCommandListener(this);
d.setCurrent(About);
}

private void exitApp() {
destroyApp(false);
notifyDestroyed();
}

public void commandAction(Command c, Displayable dis) {
if (c==cmdExitAPP) {
exitApp();
}
if (c==cmdOK) {
int selectedIndex = MainMenu.getSelectedIndex();
functionalMenu(selectedIndex);
}
if (c==cmdBack) {
screenOptions();
}
if (c==cmdOp) {
screenOptions();
}
if (c==cmdOpOK) {
int selectedIndex1 = Options.getSelectedIndex();
functionalOptions(selectedIndex1); 
}
if (c==cmdOpBack) {
screenMainMenu();
}
if (c==cmdClose) {
screenMainMenu(); 
}
if (c==cmdClose1) {
screenMainMenu(); 
}
if (c==cmdClose2) {
screenMainMenu(); 
}
if (c==cmdAboutBack) {
screenOptions();
}
}

public void commandAction(Command c, Item item) {
if (item == YouTubeLink && c == cmdLink) {
try {
platformRequest(Link);
} catch (Exception e) {
Alert a=new Alert("","Your device's built-in browser does not support HTTPS! Details : "+e.getMessage(),null,AlertType.INFO);
a.setTimeout(2500);
d.setCurrent(a,About);
}
}
}
}







































































