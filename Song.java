/**
 * Model class for Song
 * Mapped to JSON nested object 'song' for each song in JSON file
 */
public class Song {

    private double key;
    private double mode_confidence;
    private double artist_mbtags_count;
    private double key_confidence;
    private double tatums_start;
    private int year;
    private double duration;
    private double hotttnesss;
    private double beats_start;
    private double time_signature_confidence;
    private String title;
    private double bars_confidence;
    private String id;
    private double bars_start;
    private String artist_mbtags;
    private double start_of_fade_out;
    private double tempo;
    private double end_of_fade_in;
    private double beats_confidence;
    private double tatums_confidence;
    private int mode;
    private double time_signature;
    private double loudness;

    /**
     * Constructor for Song class
     * Parameters for each entry in JSON file under nested object 'song'
     * @param key
     * @param mode_confidence
     * @param artist_mbtags_count
     * @param key_confidence
     * @param tatums_start
     * @param year
     * @param duration
     * @param hotttnesss
     * @param beats_start
     * @param time_signature_confidence
     * @param title
     * @param bars_confidence
     * @param id
     * @param bars_start
     * @param artist_mbtags
     * @param start_of_fade_out
     * @param tempo
     * @param end_of_fade_in
     * @param beats_confidence
     * @param tatums_confidence
     * @param mode
     * @param time_signature
     * @param loudness
     */
    public Song(double key, double mode_confidence, double artist_mbtags_count, double key_confidence, double tatums_start, int year, double duration, double hotttnesss, double beats_start, double time_signature_confidence, String title, double bars_confidence, String id, double bars_start, String artist_mbtags, double start_of_fade_out, double tempo, double end_of_fade_in, double beats_confidence, double tatums_confidence, int mode, double time_signature, double loudness) {
        this.key = key;
        this.mode_confidence = mode_confidence;
        this.artist_mbtags_count = artist_mbtags_count;
        this.key_confidence = key_confidence;
        this.tatums_start = tatums_start;
        this.year = year;
        this.duration = duration;
        this.hotttnesss = hotttnesss;
        this.beats_start = beats_start;
        this.time_signature_confidence = time_signature_confidence;
        this.title = title;
        this.bars_confidence = bars_confidence;
        this.id = id;
        this.bars_start = bars_start;
        this.artist_mbtags = artist_mbtags;
        this.start_of_fade_out = start_of_fade_out;
        this.tempo = tempo;
        this.end_of_fade_in = end_of_fade_in;
        this.beats_confidence = beats_confidence;
        this.tatums_confidence = tatums_confidence;
        this.mode = mode;
        this.time_signature = time_signature;
        this.loudness = loudness;
    }


    public double getKey() {
        return key;
    }

    public double getMode_confidence() {
        return mode_confidence;
    }

    public double getArtist_mbtags_count() {
        return artist_mbtags_count;
    }

    public double getKey_confidence() {
        return key_confidence;
    }

    public double getTatums_start() {
        return tatums_start;
    }

    public int getYear() {
        return year;
    }

    public double getDuration() {
        return duration;
    }

    public double getHotttnesss() {
        return hotttnesss;
    }

    public double getBeats_start() {
        return beats_start;
    }

    public double getTime_signature_confidence() {
        return time_signature_confidence;
    }

    public String getTitle() {
        return title;
    }

    public double getBars_confidence() {
        return bars_confidence;
    }

    public String getId() {
        return id;
    }

    public double getBars_start() {
        return bars_start;
    }

    public String getArtist_mbtags() {
        return artist_mbtags;
    }

    public double getStart_of_fade_out() {
        return start_of_fade_out;
    }

    public double getTempo() {
        return tempo;
    }

    public double getEnd_of_fade_in() {
        return end_of_fade_in;
    }

    public double getBeats_confidence() {
        return beats_confidence;
    }

    public double getTatums_confidence() {
        return tatums_confidence;
    }

    public int getMode() {
        return mode;
    }

    public double getTime_signature() {
        return time_signature;
    }

    public double getLoudness() {
        return loudness;
    }
}
