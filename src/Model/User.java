package Model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String userId;
    private String name;
    private String email;
    private Long phone;




    List<String> user_playList=new ArrayList<>();
    List<String> friends=new ArrayList<>();
    List<String>follow =new ArrayList<>();

    public User(String userId, String name, String email, Long phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User()
    {
        super();
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<String> getFollow() {
        return follow;
    }

    public void setFollow(List<String> follow) {
        this.follow = follow;
    }



    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }


    public List<String> getUser_playList() {
        return user_playList;
    }

    public void setUser_playList(List<String> user_playList) {
        this.user_playList = user_playList;
    }


}
