package dao_interfaces;

import model_class.Podcast;

import java.util.List;

public interface PodcastInterface {
    List<Podcast> displayAllPodcast();

    List<Podcast> sortPodcast();

    Podcast searchPodcast(String podcast_name);
}