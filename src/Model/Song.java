package Model;

public class Song {
    private String songId;
    private String genre;
    private Integer tempo;
    private String singer;
    private String name;



    public Song(String songId, String name, String genre, Integer tempo, String singer) {
        this.songId = songId;
        this.genre = genre;
        this.tempo = tempo;
        this.singer = singer;
        this.name=name;

    }
    public Song()
    {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
