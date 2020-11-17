package challenges.musicplayer;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {
    private final String playListName;
    private final String owner;
    private final ListIterator<Song> songListIterator;
    private final LinkedList<Song> songs;

    public PlayList(String playListName, String owner, LinkedList<Song> songs) {
        this.playListName = playListName;
        this.owner = owner;
        this.songs = songs;
        this.songListIterator = this.songs.listIterator();
    }

    public void quitPlaylist() {
        System.out.println("Quitting the playlist.");
        while(this.songListIterator.hasPrevious()) {
            this.songListIterator.previous();
        }
    }

    public void nextSong() {
        if(this.songListIterator.hasNext()) {
            //this.songListIterator.next(); // ConcurrentModificationException (need to fix)
            System.out.println(">>>");
        } else {
            this.quitPlaylist();
        }
    }

    public void previousSong() {
        if(this.songListIterator.hasPrevious()) {
            this.songListIterator.previous();
            System.out.println("<<<");
        }
    }

    public void printPlayListDetails() {
        System.out.println("Playlist: " + this.playListName + " | owner: " + this.owner );
    }

    public void listSongs() {
        System.out.println("===========List of songs===========");
        for(Song song:this.songs) {
            System.out.println("Title: " + song.getTitle());
        }
    }

    public void getCurrentSong() {
        System.out.println("Current song: " + this.songs.get(this.songListIterator.nextIndex()).getTitle());
    }

    public void addSongToPlaylist(String songName, Album album) {
        Song song = album.fetchSongIfExists(songName);
        if (song != null && !this.songs.contains(song)) {
            this.songs.add(song);
        }
    }

    public void removeSongFromPlaylist(String songName, Album album) {
        Song song = album.fetchSongIfExists(songName);
        if(!this.songs.contains(song)) {
            System.out.println("Song do not exists - " + song.getTitle());
        }
        this.songs.remove(song);
    }
}
