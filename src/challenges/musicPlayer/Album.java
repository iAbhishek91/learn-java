package challenges.musicPlayer;

import java.util.ArrayList;

public class Album {
    private final String albumName;
    private final String mood;
    private final ArrayList<Song> songsList;

    public Album(String albumName, String mood, ArrayList<Song> songsList) {
        this.albumName = albumName;
        this.mood = mood;
        this.songsList = songsList;
    }

    public void printAlbumDetails(boolean showSongs) {
        System.out.println("Name: " + this.albumName + " | Mood: " + this.mood);

        if (showSongs) {
            this.printSongs();
        }
        System.out.println("========================================");
    }

    public void printSongs () {
        for(Song song: this.songsList) {
            System.out.println("Song name : " + song.getTitle() + " | duration: " + song.getDuration());
        }
    }

    public Song fetchSongIfExists(String songName) {
        for(Song song: songsList) {
            if(song.getTitle().equals(songName)) return song;
        }
        return null;
    }

    public void addSong(String songName) {
        Song song = this.fetchSongIfExists(songName);
        if(song != null) {
            System.out.println("Warn: Song already exists: " + song.getTitle());
            return;
        }
        Song newSong = new Song(songName, 5);
        this.songsList.add(newSong);
        System.out.println("Song added successfully: " + newSong.getTitle());
        System.out.println("========================================");
    }

    public void removeSong(String songName) {
        Song song = this.fetchSongIfExists(songName);
        if(song == null) {
            System.out.println("Warn: Song do not exists: " + songName);
            return;
        }

        this.songsList.remove(song);
        System.out.println("Song removed successfully: " + song.getTitle());
        System.out.println("========================================");
    }

    public Song addSongToPlaylist(String songName) {
        for(Song song:this.songsList) {
            if (song.getTitle().equals(songName)) {
                return song;
            }
        }
        System.out.println("Err: Song is not available");
        return null;
    }
}
