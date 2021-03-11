package challenges.musicplayerjdbc;

import challenges.musicplayerjdbc.model.Albums;
import challenges.musicplayerjdbc.model.Artists;
import challenges.musicplayerjdbc.model.DataSource;
import challenges.musicplayerjdbc.model.SongArtistVw;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // singleton instance
        DataSource dataSource = DataSource.getInstance();

        if (!dataSource.open()) {
            System.out.println("Database can't be opened!");
            return;
        }

        List<Artists> artists = dataSource.queryArtist(DataSource.ORDER_BY_ASC);
        artists.forEach(artist -> System.out.println(artist.getName()));
        System.out.println("-----------------------");

        List<Albums> albums  = dataSource.queryAlbumByArtist("Pink Floyd", DataSource.ORDER_BY_ASC);
        albums.forEach(album -> System.out.println(album.getName()));
        System.out.println("-----------------------");

        List<SongArtistVw> songArtists = dataSource.queryArtistForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);
        songArtists.forEach(songArtist -> System.out.println(songArtist.getAlbumName() + " | " + songArtist.getArtistName() + " | " + songArtist.getTrack()));
        System.out.println("-----------------------");

        dataSource.insertSong("Bhula do", "Reath", "Wajhi Farooki", 1);
        List<SongArtistVw> songArtists1 = dataSource.queryArtistForSong("Bhula do", DataSource.ORDER_BY_ASC);
        songArtists1.forEach(songArtist -> System.out.println(songArtist.getAlbumName() + " | " + songArtist.getArtistName() + " | " + songArtist.getTrack()));
        System.out.println("-----------------------");

        dataSource.close();
    }
}
