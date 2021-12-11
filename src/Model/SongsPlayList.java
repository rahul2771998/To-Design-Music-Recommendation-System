package Model;

import java.util.ArrayList;
import java.util.List;

public class SongsPlayList {
    private String songPlayListId;
    private String playListName;
    List<String> songIds =new ArrayList<>();

    public SongsPlayList()
    {
        super();
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public SongsPlayList(String songPlayListId, String playListName) {
        this.songPlayListId = songPlayListId;
        this.playListName=playListName;
    }



    public String getSongPlayListId() {
        return songPlayListId;
    }

    public void setSongPlayListId(String songPlayListId) {
        this.songPlayListId = songPlayListId;
    }

    public List<String> getSongsPlayList() {
        return this.songIds;
    }

    public void setSongsPlayList(List<String> songsPlayList) {
        this.songIds= songsPlayList;
    }
}
