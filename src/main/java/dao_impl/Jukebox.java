package dao_impl;


import model_class.Playlist;
import model_class.Podcast;
import model_class.Songs;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Jukebox {
    public static void main(String[] args) throws SQLException {
        UserImpl userImplObj = new UserImpl();
        SongsImpl songsImplObj = new SongsImpl();
        PodcastImpl podcastImplObj = new PodcastImpl();
        PlaylistImpl playlistObj = new PlaylistImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 For New User");
        System.out.println("Enter 2 For Existing User");

        int ch = sc.nextInt();
        if (ch == 1) {
            if (userImplObj.createAccount()) {
                System.out.println("Account Created");
                System.exit(0);
            }
        }
        if (ch == 2) {
            if (userImplObj.login()) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("        >>>>>>>>>   Welcome To Jukebox Music Player   <<<<<<<<<<    ");
                System.out.println("---------------------------------------------------------------------");

                while (true) {
                    System.out.println("Enter 1 for Songs \n Enter 2 for Podcast \n Enter 3 for Playlist");
                    int ch1 = sc.nextInt();
                    switch (ch1) {
                        case 1:
                            System.out.println("Enter 1 for display all song  \n Enter 2 for sort song by song name\n Enter 3 for search song\n Enter 4 for get song by genre");
                            int ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1:
                                    List<Songs> result = songsImplObj.displayAll();
                                    for (Songs s1 : result) {
                                        System.out.println(s1);
                                    }

                                    break;
                                case 2:
                                    List<Songs> result2 = songsImplObj.sortSong();
                                    for (Songs s2 : result2) {
                                        System.out.println(s2);
                                    }
                                    break;
                                case 3:
                                    System.out.println("enter the song id for search the song");
                                    int id = sc.nextInt();
                                    songsImplObj.searchSong(id);
                                    System.out.println(songsImplObj.searchSong(id));
                                    break;
                                case 4:
                                    System.out.println("Enter songs genre  to be searched");
                                    Scanner scanner = new Scanner(System.in);
                                    String s5 = scanner.next();
                                    List<Songs> result3 = songsImplObj.getByGenre(s5);
                                    for (Songs s : result3)
                                        System.out.println(s);
                            }
                            break;
                        case 2:
                            System.out.println("Enter 1 for display all podcast \n Enter 2 for sort podcast by podcast name \n Enter 3 for search  podcast by podcast name ");
                            int ch3 = sc.nextInt();
                            switch (ch3) {
                                case 1:
                                    List<Podcast> resulr3 = podcastImplObj.displayAllPodcast();
                                    for (Podcast strr : resulr3) {
                                        System.out.println(strr);
                                    }
                                    break;
                                case 3:
                                    List<Podcast> result4 = podcastImplObj.sortPodcast();
                                    for (Podcast sre : result4) {
                                        System.out.println(sre);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Enter the podcast name");
                                    String podcastName = sc.next();
                                    System.out.println(podcastImplObj.searchPodcast(podcastName));

                                    break;
                            }
                            break;
                        case 3:
                            System.out.println(" Enter 1 display all playlist \n Enter 2 for sort the playlist \n Enter 3 play song \n Enter 4 for add song to playlist");
                            int ch4 = sc.nextInt();
                            switch (ch4) {

                                case 1:
                                    List<Playlist> result5 = playlistObj.displayAllPlaylist();
                                    for (Playlist prr : result5) {
                                        System.out.println(prr);
                                    }
                                    break;

                                case 2:
                                    List<Playlist> result6 = playlistObj.sortPlaylist();
                                    for (Playlist ptr : result6) {
                                        System.out.println(result6);
                                    }
                                    break;
                                case 3:
                                    System.out.println("which playlist u want listen");
                                    int id = sc.nextInt();
                                    playlistObj.playSongInPlaylist(id);
                                }
                            break;
                        case 4:
                            playlistObj.addSongTOPlaylist();
                            break;
                        }
                    }
                }
            }
        }
    }