package Repository;

import Model.Song;
import Model.SongsPlayList;
import Model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayListRepository {

    UserRepository userRepo=new UserRepository();
    static Map<String, SongsPlayList> playListRepo=new HashMap<>();

    public static void save(SongsPlayList songsPlayList)
    {
        playListRepo.put(songsPlayList.getSongPlayListId(),songsPlayList);
    }

    public static boolean isExist(String playListId)
    {
        if(playListRepo.containsKey(playListId))
            return true;
        return false;
    }

    public static SongsPlayList  findSongPlayList(String songsPlayListId)
    {
        if(playListRepo.containsKey(songsPlayListId))
        {
            return playListRepo.get(songsPlayListId);
        }
        else
        {

            System.out.println("Invalid Play List");
            return null;
        }
    }

    public List<String> showPlayList(String userId, String playlistId)
    {
        SongsPlayList p=PlayListRepository.playListRepo.get(playlistId);
        return p.getSongsPlayList();

    }
}
