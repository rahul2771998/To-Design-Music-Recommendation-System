package Model;

import java.util.Comparator;

public  class RecommendedSong {
     private Song song;
    private Integer priority;

    public RecommendedSong() {
        super();
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public static Comparator<RecommendedSong> RecommedSong = new Comparator<RecommendedSong>() {

        public int compare(RecommendedSong s1, RecommendedSong s2)
        {
            return s2.getPriority()- s1.getPriority();

        }
    };
}
