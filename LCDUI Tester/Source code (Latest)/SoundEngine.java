
//LCDUI Tester
//Public Sound Engine (MIDI)
//Tanvir Islam
//Windows2000MC

import javax.microedition.media.*;
import java.io.*;

public class SoundEngine {

private LCDUI midlet;
private Player midiPlayer;

public SoundEngine(LCDUI midlet) {
this.midlet=midlet;
}

public void playPublicMIDI(String PublicLocator, int Loop) {
String locate=PublicLocator;
int setloop=Loop;
playMidi(locate, setloop);
}

public void stopPublicMIDI() {
stopMidi();
cleanUpPlayer();
}

private void playMidi(String locator, int setMainLoop) {
try {
stopMidi();
InputStream is = getClass().getResourceAsStream(locator);
if (is == null) {
stopMidi();
}
midiPlayer = Manager.createPlayer(is, "audio/midi");
midiPlayer.realize();
midiPlayer.prefetch();
midiPlayer.setLoopCount(setMainLoop);
midiPlayer.start();
} catch (Exception e) {}
}

private void stopMidi() {
try {
if (midiPlayer != null) {
if (midiPlayer.getState() == Player.STARTED) {
midiPlayer.stop();
}
midiPlayer.deallocate();
midiPlayer.close();
midiPlayer = null;
}
} catch (Exception e) {}
}

private void cleanUpPlayer() {
if (midiPlayer != null) {
midiPlayer.close();
midiPlayer = null;
}
}
}











