import dao_impl.PlaylistImpl;
import model_class.Playlist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaylistImplTest {
    PlaylistImpl playlist;

    @Before
    public void setup() {
        playlist = new PlaylistImpl();
    }

    @After
    public void tearDown() {
        playlist = null;
    }

    @Test
    public void displayAllDetailsOfPlaylist() {
        List<Playlist> result = playlist.displayAllPlaylist();
        assertEquals("bollywood", result.get(0).getPlaylist_name());
    }

    @Test
    public void sortPlaylistDetails() {
        List<Playlist> result6 = playlist.sortPlaylist();
        assertEquals("bollywood", result6.get(0).getPlaylist_name());
    }
}