import dao_impl.PodcastImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PodcastImplTest {
    PodcastImpl podcast;

    @Before
    public void setup() {
        podcast = new PodcastImpl();
    }

    @After
    public void tearDown() {
        podcast = null;
    }

    @Test
    public void displayAllDetailsOfPodcast() {
        assertEquals("know myself", podcast.displayAllPodcast().get(0).getPodcast_name());
    }

    @Test
    public void searchPodcastDetails() {
        assertEquals("English", podcast.searchPodcast("know myself").getPodcast_lang());
    }

    @Test
    public void sortPodcastDetails() {
        assertEquals("know myself", podcast.sortPodcast().get(0).getPodcast_name());
    }

}
