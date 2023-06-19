package dao_impl;

import dao_interfaces.SongsInterface;
import model_class.Songs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongsImpl implements SongsInterface {
    @Override
    // A method that displays all the songs in the database.
    // This method is used to display all the songs in the database.
    public List<Songs> displayAll() {
        List<Songs> l1 = new ArrayList<>();

        try (Connection con = DBConnection.getCon()) {
            String query = "SELECT * FROM songs";
            PreparedStatement myStmt = con.prepareStatement(query);
            ResultSet myRs = myStmt.executeQuery();
            while (myRs.next()) {
                String song_name = myRs.getString(1);
                int song_id = myRs.getInt(2);
                String song_duration = myRs.getString(3);
                String artist_name = myRs.getString(4);
                String genre = myRs.getString(5);
                String song_file_path = myRs.getString(6);
                int p_id = myRs.getInt(7);
                System.out.println(song_name + " " + song_id + " " + song_duration + " " + artist_name + " " + genre + " " + song_file_path + " " + p_id);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return l1;

    }

    @Override
    public List<Songs> sortSong() {
        Connection con = DBConnection.getCon();
        List<Songs> songlist = new ArrayList<>();

        try {
            Statement s1 = con.createStatement();
            ResultSet r1 = s1.executeQuery("select * from songs order by song_name");

            while (r1.next()) {
                Songs st = new Songs();
                st.setSong_name(r1.getString(1));
                st.setSong_id(r1.getInt(2));
                st.setSong_duration(r1.getString(3));
                st.setArtist_name(r1.getString(4));
                st.setGenre(r1.getString(5));
                st.setSong_file_path(r1.getString(6));
                st.setP_id(r1.getInt(7));
                songlist.add(st);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return songlist;
    }

    @Override
    public Songs searchSong(int song_id) {
        Connection con = DBConnection.getCon();
        Songs songs = null;
        try {
            PreparedStatement psmt = con.prepareStatement("select * from songs where song_id = ?");
            psmt.setInt(1, song_id);
            ResultSet s1 = psmt.executeQuery();
            while (s1.next()) {
                songs = new Songs();
                songs.setSong_name(s1.getString(1));
                songs.setSong_id(s1.getInt(2));
                songs.setSong_duration(s1.getString(3));
                songs.setArtist_name(s1.getString(4));
                songs.setGenre(s1.getString(5));
                songs.setSong_file_path(s1.getString(6));
                songs.setP_id(s1.getInt(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return songs;
    }

    @Override
    // This method is used to get the songs by genre.
    public List<Songs> getByGenre(String genre) {
        Connection con = DBConnection.getCon();
        List<Songs> list = new ArrayList<>();
        Songs songs = null;
        try {
            PreparedStatement psmt = con.prepareStatement("select * from songs where genre = ?");
            psmt.setString(1, genre);
            ResultSet s1 = psmt.executeQuery();
            while (s1.next()) {
                songs = new Songs();
                songs.setSong_name(s1.getString(1));
                songs.setSong_id(s1.getInt(2));
                songs.setSong_duration(s1.getString(3));
                songs.setArtist_name(s1.getString(4));
                songs.setGenre(s1.getString(5));
                songs.setSong_file_path(s1.getString(6));
                songs.setP_id(s1.getInt(7));
                list.add(songs);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;


    }

}