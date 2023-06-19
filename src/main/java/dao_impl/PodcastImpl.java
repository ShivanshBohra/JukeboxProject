package dao_impl;

import dao_interfaces.PodcastInterface;
import model_class.Podcast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PodcastImpl implements PodcastInterface {
    @Override
    public List<Podcast> displayAllPodcast() {
        Connection con = DBConnection.getCon();
        List<Podcast> list = new ArrayList<>();
        try {
            Statement s1 = con.createStatement();
            ResultSet r1 = s1.executeQuery("select * from podcast");
            while (r1.next()) {
                Podcast p1 = new Podcast();
                p1.setPodcast_name(r1.getString(1));
                p1.setPodcast_id(r1.getInt(2));
                p1.setPodcast_duration(r1.getString(3));
                p1.setPodcast_episode(r1.getString(4));
                p1.setPodcast_lang(r1.getString(5));
                p1.setPodcast_file_path(r1.getString(6));
                p1.setP_id(r1.getInt(7));
                list.add(p1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Podcast> sortPodcast() {
        Connection con = DBConnection.getCon();
        List<Podcast> list1 = new ArrayList<>();
        try {
            Statement s2 = con.createStatement();
            ResultSet r2 = s2.executeQuery("select * from podcast order by podcast_name ");
            while (r2.next()) {
                Podcast p2 = new Podcast();
                p2.setPodcast_name(r2.getString(1));
                p2.setPodcast_id(r2.getInt(2));
                p2.setPodcast_duration(r2.getString(3));
                p2.setPodcast_episode(r2.getString(4));
                p2.setPodcast_lang(r2.getString(5));
                p2.setPodcast_file_path(r2.getString(6));
                p2.setP_id(r2.getInt(7));
                list1.add(p2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list1;
    }

    @Override
    public Podcast searchPodcast(String podcast_name) {
        Connection con = DBConnection.getCon();
        Podcast podcast = null;
        try {
            PreparedStatement st1 = con.prepareStatement("select * from podcast where podcast_name =?");
            st1.setString(1, podcast_name);
            ResultSet rs1 = st1.executeQuery();
            while (rs1.next()) {
                podcast = new Podcast();
                podcast.setPodcast_name(rs1.getString(1));
                podcast.setPodcast_id(rs1.getInt(2));
                podcast.setPodcast_duration(rs1.getString(3));
                podcast.setPodcast_episode(rs1.getString(4));
                podcast.setPodcast_lang(rs1.getString(5));
                podcast.setPodcast_file_path(rs1.getString(6));
                podcast.setP_id(rs1.getInt(7));
            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return podcast;
    }


}