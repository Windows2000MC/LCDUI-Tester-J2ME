
//LCDUI Tester
//Test Ticker
//Tanvir Islam
//Windows2000MC

import javax.microedition.lcdui.*;

public class TestTicker implements CommandListener {

private LCDUI midlet;
private Form TickerTest;
private Ticker ticker;
private Command cmdClose;

public TestTicker(LCDUI midlet) {
this.midlet=midlet;

ticker=new Ticker("This is a Ticker running on LCDUI Tester");

TickerTest=new Form("Test Ticker");

TickerTest.append("Ticker always scrolls right to left and show on top on Form's header. The scrolling speed handled by the system\nIn J2ME Loader, Ticker won't scroll and show as a bold text");
TickerTest.setTicker(ticker);
cmdClose=new Command("Back",Command.BACK,2);
TickerTest.addCommand(cmdClose);
TickerTest.setCommandListener(this);
}

public void loadTestTicker() {
screenTestTicker();
}

private void screenTestTicker() {
Display.getDisplay(midlet).setCurrent(TickerTest);
}

public void commandAction(Command c, Displayable d) {
TickerTest.setTicker(null);
midlet.launchApp();
}
}







