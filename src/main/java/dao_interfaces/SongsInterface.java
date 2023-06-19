package dao_interfaces;


import model_class.Songs;

import java.util.List;

public interface SongsInterface {
    List<Songs> displayAll();

    List<Songs> sortSong();

    Songs searchSong(int song_id);

    List<Songs> getByGenre(String genre);


}