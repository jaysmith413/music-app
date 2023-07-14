import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/*
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html
 */
public class MusicPlayer {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public MusicPlayer(int instrument, int volume) {

        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }

    public void run(){

        /*
         * Try creating and playing some songs!
         */
        try {

            twinkle();

// Other examples:
//            playNote("C4", 1000);
//            rest(500);
//            playNote("D4", MusicApp.MAX_VOLUME, 1000);
//            playNote("D#4", 500);
//            rest(600);

        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        closeSynth();
    }

    public void twinkle() throws InterruptedException {
        rest(100);
        twinkle1();
        rest(500);
        twinkle2();
        rest(500);
        for(int i = 1; i < 2; i++){
            twinkle3();
            rest(500);
        }
        twinkle1();
        rest(500);
        twinkle2();
    }
    public void twinkle1() throws InterruptedException {
        playNote("G4");
        playNote("G4");
        playNote("D4");
        playNote("D4");
        playNote("E4");
        playNote("E4");
        playNote("D4");
        System.out.println();
    }
    public void twinkle2() throws InterruptedException {
        playNote("C4");
        playNote("C4");
        playNote("B4");
        playNote("B4");
        playNote("A4");
        playNote("A4");
        playNote("G4");
        System.out.println();
    }
    public void twinkle3() throws InterruptedException {
        playNote("D4");
        playNote("D4");
        playNote("C4");
        playNote("C4");
        playNote("B4");
        playNote("B4");
        playNote("A4");
        System.out.println();
    }

    /*
     * Delay program, i.e. rest
     */
    private static void rest(int duration) throws InterruptedException {
        Thread.sleep(duration);
    }

    /*
     * Play a note in the form <octave><note>, e.g. "C4" for middle C
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html#noteOn(int,int)
     */
    private void playNote(String note) throws InterruptedException {
        System.out.print(note + " " );
        playNote(note, 500);
    }

    private void playNote(String note, int durationMs) throws InterruptedException {
        playNote(note, this.volume, durationMs);
    }

    private void playNote(String note, int volume, int durationMs) throws InterruptedException {
        int octave = Integer.parseInt(note.substring(note.length() - 1));
        int tone = note.length() > 2 ? getToneIndex(note.substring(0, 2)) : getToneIndex(note.substring(0, 1));
        int midi_note = 12 + (12 * octave) + tone;

        /*
         * Play note for duration using Thread.sleep, then turn off note
         */
        channels[this.instrument].noteOn(midi_note, volume );
        Thread.sleep( durationMs );
        channels[this.instrument].noteOff(midi_note);
    }

    private Integer getToneIndex(String note){
        Integer toneIndex = null;

        for(int i = 0; i < notes.length; i++){
            if( notes[i].equals(note) ){
                toneIndex = i;
                break;
            }
        }

        return toneIndex;
    }

    private void openSynth(){
        try {

            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.channels = synth.getChannels();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void closeSynth(){
        if(synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}
