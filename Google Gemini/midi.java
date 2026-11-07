import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import java.io.InputStream;

public class MidiPlayerMIDlet extends MIDlet implements CommandListener {

    private Display display;
    private Form mainForm;
    private Command playCommand;
    private Command stopCommand;
    private Command exitCommand;
    
    private Player midiPlayer;

    public MidiPlayerMIDlet() {
        // Initialize UI Elements
        display = Display.getDisplay(this);
        mainForm = new Form("J2ME MIDI Player");
        
        playCommand = new Command("Play", Command.SCREEN, 1);
        stopCommand = new Command("Stop", Command.SCREEN, 2);
        exitCommand = new Command("Exit", Command.EXIT, 1);
        
        mainForm.addCommand(playCommand);
        mainForm.addCommand(stopCommand);
        mainForm.addCommand(exitCommand);
        mainForm.setCommandListener(this);
    }

    protected void startApp() throws MIDletStateChangeException {
        mainForm.append("Press 'Play' to start the music.");
        display.setCurrent(mainForm);
    }

    protected void pauseApp() {
        // Pause the player if the MIDlet is paused
        try {
            if (midiPlayer != null && midiPlayer.getState() == Player.STARTED) {
                midiPlayer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        cleanUpPlayer();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == playCommand) {
            new Thread(new Runnable() {
                public void run() {
                    playMidi("/music.mid");
                }
            }).start();
        } else if (c == stopCommand) {
            stopMidi();
        } else if (c == exitCommand) {
            cleanUpPlayer();
            notifyDestroyed();
        }
    }

    private void playMidi(String locator) {
        try {
            // Ensure any previous instance is cleaned up
            stopMidi();
            
            // Load the MIDI file from the JAR resources
            InputStream is = getClass().getResourceAsStream(locator);
            if (is == null) {
                updateStatus("Error: MIDI file not found in JAR.");
                return;
            }

            // Create the player specifying the content type
            midiPlayer = Manager.createPlayer(is, "audio/midi");
            
            // Realize and pre-fetch resources
            midiPlayer.realize();
            midiPlayer.prefetch();
            
            // Loop the playback indefinitely (-1)
            midiPlayer.setLoopCount(-1);
            
            // Start playing
            midiPlayer.start();
            updateStatus("Playing: " + locator);
            
        } catch (Exception e) {
            updateStatus("Playback Error: " + e.getMessage());
            e.printStackTrace();
        }
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
                updateStatus("Stopped playback.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cleanUpPlayer() {
        if (midiPlayer != null) {
            midiPlayer.close();
            midiPlayer = null;
        }
    }

    private void updateStatus(final String message) {
        // UI operations should ideally be handled cleanly, we simply clear and re-add
        mainForm.deleteAll();
        mainForm.append(message);
    }
}