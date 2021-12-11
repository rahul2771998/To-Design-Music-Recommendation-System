package Repository;

import Model.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongRepository {

    public static Map<String, Song> songRepo=new HashMap<>();

    public static void addSong(Song song)
    {
        songRepo.put(song.getSongId(),song);
    }
    public static boolean isExist(String songId)
    {
        if(songRepo.containsKey(songId))
            return true;
        return false;
    }
    public static  Song  findSong(String songId)
    {
        if(songRepo.containsKey(songId))
            return songRepo.get(songId);
        return null;
    }

    public static List<Song> findAllSongs()
    {
        List<Song> s=new ArrayList<>();
        for (Song song : songRepo.values())
        {
            s.add(song);
        }
        return s;

    }

}
