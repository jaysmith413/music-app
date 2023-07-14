public class MusicApp {

    public static int INSTRUMENT_PIANO = 0;
    public static int INSTRUMENT_DRUM = 9;

    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 127;

    public static void main(String[] args) {

        /*
         * Play piano tones
         */
        int volume = (MIN_VOLUME + MAX_VOLUME) / 2;
        MusicPlayer player = new MusicPlayer(INSTRUMENT_PIANO, volume);
//        player.run();

        /*
         * Play drum tones
         */
        volume = MAX_VOLUME;
        player = new MusicPlayer(INSTRUMENT_DRUM, volume);
        player.run();

    }
}
