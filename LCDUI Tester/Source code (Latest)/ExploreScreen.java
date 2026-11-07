
//LCDUI Tester
//Explore Screen
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ExploreScreen implements CommandListener {

private LCDUI midlet;
private Command cmdNext, cmdNext1, cmdNext2, cmdNext3, cmdClose, cmdLink1, cmdLink2;
private Form Portal;
private StringItem MiniFileStore, nnproject, link1, link2;


public ExploreScreen(LCDUI midlet) {
this.midlet=midlet;
cmdNext=new Command("Next",Command.OK,1);
cmdNext1=new Command("Next",Command.OK,1);
cmdNext2=new Command("Next",Command.OK,1);
cmdNext3=new Command("Next",Command.OK,1);
cmdClose=new Command("Back",Command.BACK,2);
cmdLink1=new Command("Goto",Command.ITEM,1);
cmdLink2=new Command("Goto",Command.ITEM,1);

MiniFileStore=new StringItem("Mini File Store\n","");
nnproject=new StringItem("nnproject\n","");
link1=new StringItem("","https://david2me.free.nf/",Item.HYPERLINK);
link2=new StringItem("","https://nnproject.cc/",Item.HYPERLINK);

Portal=new Form("");
Portal.append("To get unoffical but small great community made java applications, please visit this website -\n");
Portal.append(MiniFileStore);
Portal.append(link1);
link1.setDefaultCommand(cmdLink1);
Portal.append("I also recommend to use community made java applications by great mad wizards -\n");
Portal.append(nnproject);
Portal.append(link2);
link2.setDefaultCommand(cmdLink2);
Portal.addCommand(cmdNext3);
Portal.addCommand(cmdClose);
Portal.setCommandListener(this);
}

public void loadExploreScreen() {
screenExploreGifMaker();
}

private void screenExploreGifMaker() {
Form GifMaker=new Form("");
try {
Image GifMakerimg = Image.createImage("/Resources/Explore/GifMaker.png");
ImageItem GifMakerItem = new ImageItem("Gif Maker",GifMakerimg,ImageItem.LAYOUT_CENTER,"ImageItem failed to work");
GifMaker.append(GifMakerItem);
GifMaker.append("\nDASH ANIMATION V2\n");
GifMaker.append("Create GIF animations easily with tools and transitions, now possible on your java phone!");
} catch (Exception e) {}
GifMaker.addCommand(cmdNext);
GifMaker.addCommand(cmdClose);
GifMaker.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(GifMaker);
}

private void screenExploreOneTimeTextEditor() {
Form OTTE=new Form("");
try {
Image OTTEimg = Image.createImage("/Resources/Explore/OneTimeTextEditor.png");
ImageItem OTTEItem = new ImageItem("OneTime Text Editor",OTTEimg,ImageItem.LAYOUT_CENTER,"ImageItem failed to work");
OTTE.append(OTTEItem);
OTTE.append("\nTanvir Islam (Windows2000MC)\n");
OTTE.append("'Too simple, yet way too complex way to save the text in RMS. EVEN HAS THE PASSWORD FEATURE!'");
} catch (Exception e) {}
OTTE.addCommand(cmdNext1);
OTTE.addCommand(cmdClose);
OTTE.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(OTTE);
}

private void screenExploreDiscordJ2ME() {
Form DiscordJ2ME=new Form("");
try {
Image DiscordJ2MEimg = Image.createImage("/Resources/Explore/DiscordJ2ME.png");
ImageItem DiscordJ2MEItem = new ImageItem("Discord J2ME",DiscordJ2MEimg,ImageItem.LAYOUT_CENTER,"ImageItem failed to work");
DiscordJ2ME.append(DiscordJ2MEItem);
DiscordJ2ME.append("\ngtrxAC\n");
DiscordJ2ME.append("Start your journey with Direct Message! Have fun with your friends and people in servers, now possible over 2G Network!");
} catch (Exception e) {}
DiscordJ2ME.addCommand(cmdNext2);
DiscordJ2ME.addCommand(cmdClose);
DiscordJ2ME.setCommandListener(this);
Display.getDisplay(midlet).setCurrent(DiscordJ2ME);
}    

private void screenExplorePortal() {
Display.getDisplay(midlet).setCurrent(Portal);
}

public void commandAction(Command c, Displayable dis) {
if (c==cmdNext) {
screenExploreOneTimeTextEditor();
}
if (c==cmdNext1) {
screenExploreDiscordJ2ME();
}
if (c==cmdNext2) {
screenExplorePortal();
}
if (c==cmdNext3) {
screenExploreGifMaker();
}
if (c==cmdClose) {
midlet.loadPublicOptions();
}
}
}

























