package Service;

import Model.RecommendedSong;
import Model.Song;
import Model.SongsPlayList;
import Model.User;
import Repository.PlayListRepository;
import Repository.SongRepository;
import Repository.UserRepository;
import Response.UserCreationResponse;
import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;
import Exception.InvalidUserException;
import Exception.*;
import Response.*;

public class MusicRecommendationService {

    //method1
    public UserCreationResponse addUser(String userId, String name, String email, Long phone) {
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        UserRepository.save(user);
        return new UserCreationResponse("User Added Successfully");
    }

    //method2
    public AddSongResponse addSong(String songId, String name, String genre, String singer, int tempo) {
        Song song = new Song();
        song.setSongId(songId);
        ;
        song.setGenre(genre);
        song.setTempo(tempo);
        song.setSinger(singer);
        song.setName(name);
        SongRepository.addSong(song);
        return new AddSongResponse("Song Added Successfully");
    }

    //method3
    public CreatePlayListResponse createPlayList(String userId, String playListId, List<String> songsId) throws InvalidUserException{
        if(UserRepository.isExist(userId)) {
            SongsPlayList songsPlayList = new SongsPlayList();
            songsPlayList.setSongPlayListId(playListId);
            songsPlayList.setSongsPlayList(songsId);
            PlayListRepository.save(songsPlayList);

            User user = UserRepository.getUser(userId);
            List<String> userPlayLists = user.getUser_playList();
            userPlayLists.add(playListId);
            UserRepository.save(user);

            return new CreatePlayListResponse(playListId +" created successfully");
        }
        else
        {
            System.out.println("Invalid UserId ");
            throw new InvalidUserException("Invalid User Id");
        }
    }

    // method4

    public AddSongToPlayListResponse addSongsToPlayList(String songsPlayListId, String songsId)throws InvalidPlayListException,InvalidSongException {
        if (PlayListRepository.isExist(songsPlayListId)) {
            SongsPlayList songPlayList = PlayListRepository.findSongPlayList(songsPlayListId);
            List<String> songList = songPlayList.getSongsPlayList();
            if (SongRepository.isExist(songsId)) {
                songList.add(songsId);
                songPlayList.setSongsPlayList(songList);
                PlayListRepository.save(songPlayList);
                return new AddSongToPlayListResponse(songsId+" added to playList "+songsPlayListId);
            } else {

                throw new InvalidSongException("Invalid Songs");
            }


        } else {

            throw new InvalidPlayListException("Invalid Play List");
        }
    }

    // Method5
    public void showPlayList(String userId, String playListId)throws InvalidSongException,InvalidPlayListException,InvalidUserException {
        if (UserRepository.isExist(userId) && PlayListRepository.isExist(playListId)) {
            if(isUserPlayList(userId,playListId)||iSFriendPlayList(userId, playListId) || iSFollowPlayList(userId, playListId))
            {
                SongsPlayList songsPlayList = PlayListRepository.findSongPlayList(playListId);
                List<String> songIds = songsPlayList.getSongsPlayList();
                System.out.println("Songs Play List");
                for (String songId : songIds) {
                    System.out.println(songId);
                }

            }
            else
            {
                System.out.println("Invalid UserId or PlayListId");
                throw new InvalidUserException("Invalid User or PlayListId");
            }

        }
        else
        {
            System.out.println("Invalid UserId or PlayListId");
            throw new InvalidUserException("Invalid User or PlayListId");
        }
    }

    public boolean isUserPlayList(String userId, String playListId)
    {
        for(String pId: UserRepository.getUser(userId).getUser_playList())
        {
            if(pId.equalsIgnoreCase(playListId))
                return true;
        }
        return false;
    }

    public boolean iSFriendPlayList(String userId,String playListId)
    {
        List<String>friendIds=UserRepository.getUser(userId).getFriends();
        for(String fId: friendIds)
        {
           for(String pId:UserRepository.getUser(fId).getFriends())
           {
               if(pId.equalsIgnoreCase(playListId))
                   return true;
           }
        }
        return false;
    }

    public boolean iSFollowPlayList(String userId,String playListId)
    {
        List<String>followIds=UserRepository.getUser(userId).getFollow();
        for(String fId: followIds)
        {
            for(String pId:UserRepository.getUser(fId).getFollow())
            {
                if(pId.equalsIgnoreCase(playListId))
                    return true;
            }
        }
        return false;
    }

    //Method6 Add Friends
    public AddFriendResponse addFriend(String userId1, String userId2)throws InvalidSongException,InvalidPlayListException,InvalidUserException {
        if (UserRepository.isExist(userId1) && UserRepository.isExist(userId2)) {
            User user1 = UserRepository.getUser(userId1);
            User user2 = UserRepository.getUser(userId2);
            List<String> friendIds = user1.getFriends();
            friendIds.add(userId2);
            user1.setFriends(friendIds);
            UserRepository.save(user1);

            List<String> friendIds2 = user2.getFriends();
            friendIds2.add(userId1);
            user2.setFriends(friendIds2);
            UserRepository.save(user2);

            return new AddFriendResponse(userId1+ " And "+userId2+" beacme friend");

        }
        else
        {
            System.out.println("Invalid UserIds");
            throw new InvalidUserException("Invalid userIds");
        }
    }

    public FollowFriendResponse follow(String userId1, String userId2) throws InvalidSongException,InvalidPlayListException,InvalidUserException {
        if (UserRepository.isExist(userId1) && UserRepository.isExist(userId2)) {
            User user1 = UserRepository.getUser(userId1);
            User user2 = UserRepository.getUser(userId2);
            List<String> followIds = user1.getFollow();
            followIds.add(userId2);
            user1.setFollow(followIds); //  user1:-->list of users follows --> userIds
            UserRepository.save(user1); //  user2:-->list of users follows --> userIds
            return new FollowFriendResponse(userId1+" started following " +userId2);


        }
        else
        {

            throw new InvalidUserException("Invalid userIds");
        }
    }

    public void recommendSongs(String userId)throws InvalidSongException,InvalidPlayListException,InvalidUserException {
        if(UserRepository.isExist(userId)) {

            List<RecommendedSong> recommendedSongs = new ArrayList<>();
            User user = UserRepository.getUser(userId);
            Map<String, Song> userSongsCollection = new HashMap<>();

            List<String> user_playList = user.getUser_playList();
            for (String id : user_playList) {
                SongsPlayList songsPlayList = PlayListRepository.findSongPlayList(id);
                List<String> songsIds = songsPlayList.getSongsPlayList();
                for (String songId : songsIds) {
                    Song song = SongRepository.findSong(songId);
                    userSongsCollection.put(songId, song);

                }
            }


            List<String> friends = user.getFriends();
            for (String uId : friends) {
                user = UserRepository.getUser(uId);
                user_playList = user.getUser_playList();
                for (String id : user_playList) {
                    SongsPlayList songsPlayList = PlayListRepository.findSongPlayList(id);
                    List<String> songsIds = songsPlayList.getSongsPlayList();
                    for (String songId : songsIds) {
                        Song song = SongRepository.findSong(songId);
                        userSongsCollection.put(songId, song);
                    }
                }
            }


            List<Song> songs = SongRepository.findAllSongs();//User1: genre: folk,rock    singer: AB, BC CD  tempos:60,70,80
            // for(String key: userSongsCollection.keySet())
            //    System.out.println(key);

            for (Song song : songs) {
                if (userSongsCollection.containsKey(song.getSongId()) == false) {

                    int priority = 0;
                    for (Song song1 : userSongsCollection.values()) {
                        //System.out.println(song.getSongId()+" "+song1.getSongId());

                        int g = 0;
                        int t = 0;
                        int s = 0;
                        if (song1.getGenre().equalsIgnoreCase(song.getGenre()))
                            g = 1;
                        if (song1.getSinger().equalsIgnoreCase(song.getSinger()))
                            s = 1;
                        if (song1.getTempo() == song.getTempo())
                            t = 1;
                        int temp = g * 3 + s * 2 + t * 1;
                        if (priority < temp)
                            priority = temp;

                    }

                    RecommendedSong rsong = new RecommendedSong();
                    rsong.setSong(song);
                    rsong.setPriority(priority);
                    recommendedSongs.add(rsong);
                }

            }


            Collections.sort(recommendedSongs, RecommendedSong.RecommedSong);
            System.out.println("Recommended Songs");
            for (RecommendedSong rsong : recommendedSongs) {
                System.out.println(rsong.getSong().getSongId());
            }
        }
        else
        {
           throw new InvalidUserException("Invalid UserId");
        }



    }
}

