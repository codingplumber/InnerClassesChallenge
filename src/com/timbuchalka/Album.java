package com.timbuchalka;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    private SongList songList;
//    TODO: replace me!
//    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

//    TODO:
    public void addSong(String title, double duration) {
        this.songList.addToSongList(new Song(title, duration));
    }

//    TODO:
//    private Song findSong(String title) {
////        for(Song checkedSong: this.songs) {
////            if(checkedSong.getTitle().equals(title)) {
////                return checkedSong;
////            }
////        }
//        return null;
//    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = songList.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            System.out.println(checkedSong + " added to playlist");
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songList.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


    // Challenge:
    // Change Array list to inner class called SongList to hold tracks
        // ArrayList
        // addSong method
        // findSong method
    // Album will use these methods
    // Don't change song or main class

    private class SongList {
        private ArrayList<Song> tracks;

        public SongList() {
            this.tracks = new ArrayList<Song>();
        }

        public boolean addToSongList(Song track) {
            if (tracks.contains(track)) {
                return false;
            }
            tracks.add(track);
            return true;
        }

        public Song findSong(String title) {
            for(Song checkedTrack: tracks) {
                if(checkedTrack.getTitle().equals(title)) {
                    return checkedTrack;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index > 0 && index < tracks.size()) {
                return tracks.get(index);
            }
            return null;
        }
    }
















}
