package com.example.recyclerview;

public class Model {

    int image;
    String player_name,player_role;

    public Model(int image, String player_name, String player_role) {
        this.image = image;
        this.player_name = player_name;
        this.player_role = player_role;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_role() {
        return player_role;
    }

    public void setPlayer_role(String player_role) {
        this.player_role = player_role;
    }
}
