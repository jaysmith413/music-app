import javax.sound.midi.*;
import java.sql.SQLOutput;
import java.util.Scanner;

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

            String yesOrNo = "Y";
            while(yesOrNo.equals("Y")) {
                System.out.println("Select a tune (1-4): ");
                System.out.println("1. Twinkle Twinkle Little Star");
                System.out.println("2. Happy Birthday");
                System.out.println("3. William Tell");
                System.out.println("4. Sweet Child of Mine");
                Scanner input = new Scanner(System.in);
                String response = input.nextLine();

                if (response.equals("1")) {
                    twinkle();
                } else if (response.equals("2")) {
                    happyBirthday();
                } else if (response.equals("3")) {
                    williamTell();
                } else if (response.equals("4")) {
                    sweetChildOfMine();
                }

                System.out.println("Do you want to hear another one? (Y/N) ");
                Scanner userInput = new Scanner(System.in);
                yesOrNo = userInput.nextLine();
            }

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
        rest(1000);
        twinkle1();
        rest(500);
        twinkle2();
        rest(500);
        for(int i = 1; i <= 2; i++){
            twinkle3();
            rest(500);
        }
        twinkle1();
        rest(500);
        twinkle2();
        rest(500);
    }
    public void twinkle1() throws InterruptedException {
        playNote("G4");
        playNote("G4");
        playNote("D5");
        playNote("D5");
        playNote("E5");
        playNote("E5");
        playNote("D5");
        System.out.println();
    }
    public void twinkle2() throws InterruptedException {
        playNote("C5");
        playNote("C5");
        playNote("B4");
        playNote("B4");
        playNote("A4");
        playNote("A4");
        playNote("G4");
        System.out.println();
    }
    public void twinkle3() throws InterruptedException {
        playNote("D5");
        playNote("D5");
        playNote("C5");
        playNote("C5");
        playNote("B4");
        playNote("B4");
        playNote("A4");
        System.out.println();
    }

    public void happyBirthday() throws InterruptedException {
        rest(1000);
        playNote("C4", 600);
        playNote("C4", 300);
        playNote("D4", 900);
        playNote("C4", 900);
        playNote("F4", 900);
        playNote("E4", 900);
        rest(900);
        playNote("C4", 600);
        playNote("C4", 300);
        playNote("D4", 900);
        playNote("C4", 900);
        playNote("G4", 900);
        playNote("F4", 900);
        rest(900);
        playNote("C4", 600);
        playNote("C4", 300);
        playNote("C5", 900);
        playNote("A4", 900);
        playNote("F4", 900);
        playNote("E4", 900);
        playNote("D4", 900);
        playNote("A#4", 600);
        playNote("A#4", 300);
        playNote("A4", 900);
        playNote("F4", 900);
        playNote("G4", 900);
        playNote("F4", 900);
        rest(450);
        playNote("C4", 450);
        playNote("D4", 450);
        playNote("C4", 450);
        playNote("D#4", 1800);
        rest(900);
        System.out.println();
    }

    public void williamTell() throws InterruptedException {
        rest(1000);
        williamTell1();
        williamTell2();
        williamTell1();
        williamTell3();
        williamTell1();
        williamTell2();
        williamTell1();
        williamTell3();
        williamTell4();
        williamTell5();
        williamTell4();
        williamTell5();
        williamTell6();
        williamTell7();
        williamTell1();
        williamTell2();
        williamTell1();
        williamTell3();


    }
    public void williamTell1() throws InterruptedException {
        playNote("C4", 125);
        playNote("C4", 125);
        playNote("C4", 250);
        playNote("C4", 125);
        playNote("C4", 125);
        playNote("C4", 250);
        playNote("C4", 125);
        playNote("C4", 125);
        playNote("F4", 250);
        playNote("G4", 250);
        playNote("A4", 250);

        System.out.println();
    }

    public void williamTell2() throws InterruptedException {
        playNote("C4", 125);
        playNote("C4", 125);
        playNote("C4", 250);
        playNote("C4", 125);
        playNote("C4", 125);
        playNote("F4", 250);
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("G4", 250);
        playNote("E4", 250);
        playNote("C4", 250);

        System.out.println();
    }

    public void williamTell3() throws InterruptedException {
        playNote("F4", 125);
        playNote("A4", 125);
        playNote("C5", 625);
        playNote("A#4", 125);
        playNote("A4", 125);
        playNote("G4", 125);
        playNote("F4", 250);
        playNote("A4", 250);
        playNote("F4", 250);

        System.out.println();
    }
    public void williamTell4() throws InterruptedException {
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("A4", 250);
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("A4", 250);
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("A4", 250);
        playNote("D5", 250);
        playNote("A4", 250);
        playNote("D5", 250);
        playNote("A4", 250);
        playNote("D5", 250);
        playNote("A4", 250);
        playNote("G4", 250);
        playNote("F4", 250);
        playNote("E4", 250);
        playNote("D4", 250);

        System.out.println();
    }

    public void williamTell5() throws InterruptedException {
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("A4", 250);
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("A4", 250);
        playNote("A4", 125);
        playNote("A4", 125);
        playNote("A4", 250);
        playNote("D5", 250);
        playNote("A4", 250);
        playNote("D5", 250);
        playNote("A4", 250);
        playNote("D5", 250);
        playNote("C5", 250);
        playNote("B4", 250);
        playNote("C5", 750);

        System.out.println();
    }

    public void williamTell6() throws InterruptedException {
        playNote("G4", 125);
        playNote("G4", 125);
        playNote("G4", 250);
        playNote("G4", 125);
        playNote("G4", 125);
        playNote("G4", 250);
        playNote("A4", 250);
        playNote("A#4", 250);
        playNote("G4", 500);
        playNote("A#4", 250);
        playNote("A4", 250);
        playNote("F4", 500);
        playNote("A4", 250);
        playNote("G4", 250);
        playNote("C4", 500);

        System.out.println();
    }

    public void williamTell7() throws InterruptedException {
        playNote("G4", 125);
        playNote("G4", 125);
        playNote("G4", 250);
        playNote("G4", 125);
        playNote("G4", 125);
        playNote("G4", 250);
        playNote("A4", 250);
        playNote("A#4", 250);
        playNote("G4", 500);
        playNote("A#4", 250);
        playNote("A4", 250);
        playNote("F4", 500);
        playNote("A4", 250);
        playNote("G4", 750);

        System.out.println();
    }

    public void sweetChildOfMine() throws InterruptedException {
        rest(1000);
        sweetChildOfMine1();
        sweetChildOfMine1();
        sweetChildOfMine2();
        sweetChildOfMine2();
        sweetChildOfMine3();
        sweetChildOfMine3();
        sweetChildOfMine4();

    }

    public void sweetChildOfMine1() throws InterruptedException {
        playNote("C4", 250);
        playNote("C5", 250);
        playNote("G4", 250);
        playNote("F4", 250);
        playNote("F5", 250);
        playNote("G4", 250);
        playNote("E5", 250);
        playNote("G4", 250);


        System.out.println();
    }

    public void sweetChildOfMine2() throws InterruptedException {
        playNote("D4", 250);
        playNote("C5", 250);
        playNote("G4", 250);
        playNote("F4", 250);
        playNote("F5", 250);
        playNote("G4", 250);
        playNote("E5", 250);
        playNote("G4", 250);


        System.out.println();
    }

    public void sweetChildOfMine3() throws InterruptedException {
        playNote("F4", 250);
        playNote("C5", 250);
        playNote("G4", 250);
        playNote("F4", 250);
        playNote("F5", 250);
        playNote("G4", 250);
        playNote("E5", 250);
        playNote("G4", 250);


        System.out.println();
    }

    public void sweetChildOfMine4() throws InterruptedException {
        playNote("D5", 250);
        playNote("G4", 250);
        playNote("C5", 250);
        playNote("G4", 250);
        playNote("D5", 250);
        playNote("G4", 250);
        playNote("E5", 250);
        playNote("G4", 250);
        playNote("F5", 250);
        playNote("G4", 250);
        playNote("E5", 250);
        playNote("G4", 250);
        playNote("D5", 500);
        playNote("C5", 2500);


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

        playNote(note, 500);
    }

    private void playNote(String note, int durationMs) throws InterruptedException {
        System.out.print(note + " " );
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
