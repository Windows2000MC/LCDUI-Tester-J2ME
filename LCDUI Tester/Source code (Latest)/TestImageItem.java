
//LCDUI Tester
//Test ImageItem
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestImageItem implements CommandListener {

private LCDUI midlet;
private Image testImg;
private Command cmdClose;

public TestImageItem(LCDUI midlet) {
this.midlet=midlet;
}

public void loadImgItem() {
screenImageItem();
}

private void screenImageItem() {
Form TestImgForm=new Form("Test ImageItem");
try {
testImg=Image.createImage("/Resources/TestImageItem/J2MEIDE.png");
ImageItem testImgItem = new ImageItem("J2ME IDE",testImg,ImageItem.LAYOUT_CENTER,"ImageItem failed to work");
TestImgForm.append(testImgItem);
} catch (Exception e) {}
cmdClose=new Command("Back",Command.BACK,2);
TestImgForm.addCommand(cmdClose);
TestImgForm.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(TestImgForm);
}

public void commandAction(Command c, Displayable d) {
midlet.launchApp();
}
}






