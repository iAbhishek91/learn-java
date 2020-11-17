package challenges.musicplayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    // music system implementation
    // play
    // next song
    // previous song
    // add song to album
    // delete song to album
    // add song to playlist
    // remove song from playlist
    public static void main(String[] args) {
        // initialize data
        ArrayList<Song> albumOldSongs = new ArrayList<>();
        ArrayList<Song> albumLatestSongs = new ArrayList<>();
        LinkedList<Song> playlistSongs = new LinkedList<>();
        Album old = new Album("Old Songs", "Relax", albumOldSongs);
        Album latest = new Album("Latest Songs", "Party", albumLatestSongs);
        PlayList myPlaylist = new PlayList("Study time", "Abhishek", playlistSongs);

        System.out.println("============Add/remove songs to playlist=============");
        old.addSong("old-01");
        old.addSong("old-02");
        old.addSong("old-03");
        old.addSong("old-04");
        old.addSong("old-04"); // already exists

        old.removeSong("old-04");
        old.removeSong("old-04"); // not available
        old.removeSong("old-05"); // not available

        latest.addSong("latest-01");
        latest.addSong("latest-02");

        System.out.println("=============Create playlist==================");
        myPlaylist.addSongToPlaylist("old-01", old);
        myPlaylist.addSongToPlaylist("old-03", old);
        myPlaylist.addSongToPlaylist("latest-01", latest);
        myPlaylist.addSongToPlaylist("latest-02", latest);
        myPlaylist.addSongToPlaylist("old-02", old);
        myPlaylist.addSongToPlaylist("old-06", old);
        myPlaylist.addSongToPlaylist("latest-03", latest);
        myPlaylist.removeSongFromPlaylist("old-03", old);
        myPlaylist.listSongs();
        myPlaylist.getCurrentSong();

        System.out.println("================Use Playlist===================");
        myPlaylist.printPlayListDetails();
        myPlaylist.listSongs();
        myPlaylist.quitPlaylist();
        myPlaylist.getCurrentSong();
        myPlaylist.nextSong();
        myPlaylist.nextSong();
        myPlaylist.getCurrentSong();
        myPlaylist.previousSong();
        myPlaylist.getCurrentSong();
    }
}
