/*
 * Author Name: Shivansh Bohra
 * Date: 04-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package model_class;

public class Playlist {
    private int playlist_id;
    private String playlist_name;
    private String user_id;

    public Playlist() {
    }

    public Playlist(int playlist_id, String playlist_name, String user_id) {
        this.playlist_id = playlist_id;
        this.playlist_name = playlist_name;
        this.user_id = user_id;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Playlist{" + "playlist_id=" + playlist_id + ", playlist_name='" + playlist_name + '\'' + ", user_id='" + user_id + '\'' + '}';
    }
}
