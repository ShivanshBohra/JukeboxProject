package dao_interfaces;

import model_class.Playlist;

import java.sql.SQLException;
import java.util.List;

public interface PlaylistInterface {
    List<Playlist> displayAllPlaylist();

    List<Playlist> sortPlaylist();

    void playSongInPlaylist(int playlist_id) throws SQLException;

    void addSongTOPlaylist() throws SQLException;

}