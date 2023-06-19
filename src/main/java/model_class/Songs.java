/*
 * Author Name: Shivansh Bohra
 * Date: 04-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package model_class;

public class Songs {
    private int song_id;
    private String song_name;
    private String song_duration;
    private String artist_name;
    private String genre;
    private String song_file_path;
    private int p_id;

    public Songs() {
    }

    public Songs(int song_id, String song_name, String song_duration, String artist_name, String genre, String song_file_path, int p_id) {
        this.song_id = song_id;
        this.song_name = song_name;
        this.song_duration = song_duration;
        this.artist_name = artist_name;
        this.genre = genre;
        this.song_file_path = song_file_path;
        this.p_id = p_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(String song_duration) {
        this.song_duration = song_duration;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSong_file_path() {
        return song_file_path;
    }

    public void setSong_file_path(String song_file_path) {
        this.song_file_path = song_file_path;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return "Songs{" + "song_id=" + song_id + ", song_name='" + song_name + '\'' + ", song_duration='" + song_duration + '\'' + ", artist_name='" + artist_name + '\'' + ", genre='" + genre + '\'' + ", song_file_path='" + song_file_path + '\'' + ", p_id=" + p_id + '}';
    }
}