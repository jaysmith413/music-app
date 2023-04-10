# Music App

Play some music in Java 🎵🎵

## Getting Started

Run the main() method from the MusicApp class.
You should hear 3 tones from a piano, then from a drum.

The instrument playing the tones can be configured using the MusicPlayer constructor 

```
public MusicPlayer(int instrument, int volume) {
```

In the MusicPlayer class, the `run()` method will play the tones specific in order from top to bottom:

```
    public void run(){

        try {

            /*
             * Add notes in the form of the form <octave><note>,
             * e.g. "4C" for middle C
             *
             * The second input parameter to playNote() is the duration in milliseconds
             * The input parameter to rest() is also in milliseconds
             */
            playNote("4C", 1000);
            rest(500);
            playNote("4D", MusicApp.MAX_VOLUME, 1000);
            playNote("4D#", 500);
            rest(600);

        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        closeSynth();
    }
```

Test it out and be creative!