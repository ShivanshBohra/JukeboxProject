import dao_impl.SongsImpl;
import model_class.Songs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SongsImplTest {
    SongsImpl songImpl;

    @Before
    public void setup() {
        songImpl = new SongsImpl();
    }

    @After
    public void tearDown() {
        songImpl = null;
    }

    @Test
    public void sortSongDetails() {
        List<Songs> list = songImpl.sortSong();
        assertEquals("bay", songImpl.sortSong().get(0).getSong_name());
    }

    @Test
    public void searchSongDetails() {
        Songs result = songImpl.searchSong(2);
        assertEquals("blank", result.getSong_name());
    }

    @Test
    public void getByGenre() {
        assertEquals("bay", songImpl.getByGenre("pop").get(0).getSong_name());
    }

}

