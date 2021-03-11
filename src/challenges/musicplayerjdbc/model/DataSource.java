package challenges.musicplayerjdbc.model;

import challenges.musicplayer.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/abhishekdas/Desktop/abhishek/learn-java/src/javaBasics/rdbms/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";
    public static final String COLUMN_ALBUMS_ARTIST = "artist";
    public static final int  INDEX_ALBUM_ID = 1; // indices always stats from 1 an not from 0.
    public static final int  INDEX_ALBUM_NAME = 2;
    public static final int  INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int  INDEX_ARTISTS_ID = 1;
    public static final int  INDEX_ARTISTS_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";
    public static final int INDEX_SONGS_ID = 1;
    public static final int INDEX_SONGS_TRACK = 2;
    public static final int INDEX_SONGS_TITLE = 3;
    public static final int INDEX_SONGS_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    // We are using placeholder statements to be safe from SQL injections.
    // Also do not mention the queries in the method, because of two reason:
    // - only use pre-compiled on
    // - and to process the query only once for performance
    private final String QUERY_SONG_ARTIST_VW_PREP = "SELECT ar." + COLUMN_ARTISTS_NAME + ", al." + COLUMN_ALBUMS_NAME + ",s." + COLUMN_SONGS_TRACK +
            " FROM " + TABLE_SONGS + " s " +
            " INNER JOIN " + TABLE_ALBUMS + " al ON s." + COLUMN_SONGS_ALBUM + "=al." + COLUMN_ALBUMS_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ar ON al." + COLUMN_ALBUMS_ARTIST + "= ar." + COLUMN_ARTISTS_ID +
            " WHERE s." + COLUMN_SONGS_TITLE +" = ? " +
            " ORDER BY ar." + COLUMN_ARTISTS_NAME + " COLLATE NOCASE = ?";

    private static final String INSERT_ARTIST_QUERY_PREP = "INSERT INTO " + TABLE_ARTISTS +
            " (" + COLUMN_ARTISTS_NAME + ") VALUES (?)";

    private static final String INSERT_ALBUM_QUERY_PREP = "INSERT INTO " + TABLE_ALBUMS +
            " (" + COLUMN_ALBUMS_NAME + ", " + COLUMN_ALBUMS_ARTIST + ") VALUES (?, ?)";

    private static final String INSERT_SONG_QUERY_PREP = "INSERT INTO " + TABLE_SONGS +
            " (" + COLUMN_SONGS_TRACK + ", " + COLUMN_SONGS_TITLE + ", " + COLUMN_SONGS_ALBUM + ") VALUES (?, ?, ?)";

    public static final String QUERY_ARTIST_PREP = "SELECT " + COLUMN_ARTISTS_ID +
            " FROM " + TABLE_ARTISTS + " WHERE " + COLUMN_ALBUMS_NAME + " = ?";

    public static final String QUERY_ALBUM_PREP = "SELECT " + COLUMN_ALBUMS_ID +
            " FROM " + TABLE_ALBUMS + " WHERE " + COLUMN_ALBUMS_NAME + " = ?";

    public static final String QUERY_SONG_PREP = "SELECT " + COLUMN_SONGS_ID +
            " FROM " + TABLE_SONGS + " WHERE " + COLUMN_SONGS_TITLE + " = ?";


    private PreparedStatement queryArtistForSongPrep;
    private PreparedStatement insertArtistQueryPrep;
    private PreparedStatement insertAlbumQueryPrep;
    private PreparedStatement insertSongQueryPrep;
    private PreparedStatement queryArtistPrep;
    private PreparedStatement queryAlbumPrep;
    private PreparedStatement querySongPrep;

    private Connection con;


    // make the class singleton - very common pattern for datasource
    public static DataSource instance = new DataSource();

    // this will block you from creating a class using the below syntax
    // DataSource dataSource = new DataSource();
    //
    private DataSource() {}

    public static DataSource getInstance() {
        return instance;
    }


    public boolean open() {
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);

            // Creating the prepare statements
            queryArtistForSongPrep = con.prepareStatement(QUERY_SONG_ARTIST_VW_PREP);
            insertArtistQueryPrep = con.prepareStatement(INSERT_ARTIST_QUERY_PREP, Statement.RETURN_GENERATED_KEYS);
            insertAlbumQueryPrep = con.prepareStatement(INSERT_ALBUM_QUERY_PREP, Statement.RETURN_GENERATED_KEYS);
            insertSongQueryPrep = con.prepareStatement(INSERT_SONG_QUERY_PREP);
            queryArtistPrep = con.prepareStatement(QUERY_ARTIST_PREP);
            queryAlbumPrep = con.prepareStatement(QUERY_ALBUM_PREP);
            querySongPrep = con.prepareStatement(QUERY_SONG_PREP);

            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }


    public void close() {
        try {
        if (queryArtistForSongPrep != null) { queryArtistForSongPrep.close(); }

        if (insertArtistQueryPrep != null) { insertArtistQueryPrep.close(); }

        if (insertAlbumQueryPrep != null) { insertAlbumQueryPrep.close(); }

        if (insertSongQueryPrep != null) {insertSongQueryPrep.close(); }

        if (queryArtistPrep != null) {queryArtistPrep.close(); }

        if (queryAlbumPrep != null) { queryAlbumPrep.close(); }

        if (querySongPrep != null) { querySongPrep.close(); }

        if (con != null) { con.close(); }
        } catch (SQLException sqlException) { System.out.println(sqlException.getMessage()); }
    }


    // we are querying everything from the table.
    // in real world, we just accommodate the queries based on the UI design
    public List<Artists> queryArtist(int sortOrder) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        query.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            query.append(" ORDER BY ");
            query.append(COLUMN_ARTISTS_NAME);
            query.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) { query.append("DESC"); }
            else  { query.append("ASC"); }
        }

        try (
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query.toString())
        ) {
            List<Artists> artists = new ArrayList<>();
            while(resultSet.next()) {
                Artists artist = new Artists();
                artist.setId(resultSet.getInt(INDEX_ARTISTS_ID));
                artist.setName(resultSet.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }
            return artists;
        } catch (SQLException sqlException) {
            System.out.println("Err while querying Artist: " + sqlException.getMessage());
            return null;
        }
    }


    public List<Albums> queryAlbumByArtist(String artistName, int sortOrder) {
        // These queries are not meant to be changed.
        // Write a new method for new query, or
        // delete the method if not used.
        final String baseQuery = "Select al." + COLUMN_ALBUMS_NAME +
                " FROM " + TABLE_ALBUMS + " al" +
                " INNER JOIN " + TABLE_ARTISTS + " ar" +
                " ON ar." + COLUMN_ARTISTS_ID + " = al." + COLUMN_ALBUMS_ARTIST +
                " WHERE ar." + COLUMN_ARTISTS_NAME + " = '" + artistName + "'";

        final StringBuilder query = new StringBuilder(baseQuery);
        if (sortOrder != ORDER_BY_NONE) {
            query.append(" ORDER BY al." + COLUMN_ARTISTS_NAME);
            query.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) { query.append("DESC"); }
            else  { query.append("ASC"); }
        }
        System.out.println("Query executed: " + query.toString());

        try (
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(query.toString())
        ) {
            List<Albums> albums = new ArrayList<>();
            while(resultSet.next()) {
                Albums album = new Albums();
                album.setId(0);
                album.setName(resultSet.getString(1));
                album.setArtist(0);
                albums.add(album);
            }
            return albums;
        } catch (SQLException sqlException) {
            System.out.println("Err while querying Artist: " + sqlException.getMessage());
            return null;
        }
    }


    public List<SongArtistVw> queryArtistForSong(String songTitle, int sortOrder) {
        try {
            String orderBy = sortOrder == ORDER_BY_ASC ? "ASC" : "DESC";

            queryArtistForSongPrep.setString(1, songTitle);
            queryArtistForSongPrep.setString(2, orderBy);
            ResultSet resultSet = queryArtistForSongPrep.executeQuery(); // while working with prepare statement its not required to close resultSet.

            List<SongArtistVw> songArtists = new ArrayList<>();

            while(resultSet.next()) {
                SongArtistVw songArtist = new SongArtistVw();
                // In this example, its ok to hardcode the indices, as the order
                // will never change for the view.
                songArtist.setAlbumName(resultSet.getString(1));
                songArtist.setArtistName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;
        } catch (SQLException sqlException) {
            System.out.println("Err while querying Artist: " + sqlException.getMessage());
            return null;
        }
    }


    private int insertArtist(String artistName) throws SQLException{
        // Check if artist already exists, before insert
        queryArtistPrep.setString(1, artistName);
        ResultSet getArtist = queryArtistPrep.executeQuery();

        if (getArtist.next()) { return getArtist.getInt(1); }

        // insert new artist
        insertArtistQueryPrep.setString(1, artistName);
        int affectedRows = insertArtistQueryPrep.executeUpdate(); // execute returns boolean; but executeUpdate returns the number of rows affected
        if (affectedRows != 1) { throw new SQLException("Couldn't insert artist!"); }

        ResultSet newArtistId = insertArtistQueryPrep.getGeneratedKeys();
        if (newArtistId.next()) {
            return newArtistId.getInt(1);
        } else {
            throw new SQLException("Couldn't get _id for the artist!");
        }
    }


    private int insertAlbum(String albumName, int artistId) throws SQLException{
        // Check if artist already exists, before insert
        queryAlbumPrep.setString(1, albumName);
        ResultSet getAlbum = queryAlbumPrep.executeQuery();

        if (getAlbum.next()) { return getAlbum.getInt(1); }

        // insert new album
        insertAlbumQueryPrep.setString(1, albumName);
        insertAlbumQueryPrep.setInt(2, artistId);
        int affectedRows = insertAlbumQueryPrep.executeUpdate(); // execute returns boolean; but executeUpdate returns the number of rows affected
        if (affectedRows != 1) { throw new SQLException("Couldn't insert album!"); }

        ResultSet newAlbumId = insertAlbumQueryPrep.getGeneratedKeys();
        if (newAlbumId.next()) {
            return newAlbumId.getInt(1);
        } else {
            throw new SQLException("Couldn't get _id for the album!");
        }
    }


    public void insertSong(String songTitle, String albumName, String artistName, int track) {
        // Check if artist already exists, before insert
        try {
            // this mock the transaction behaviour
            con.setAutoCommit(false);

            int artistId = insertArtist(artistName);
            int albumId = insertAlbum(albumName, artistId);
            insertSongQueryPrep.setInt(1, track);
            insertSongQueryPrep.setString(2, songTitle);
            insertSongQueryPrep.setInt(3, albumId);

            // assuming that song do not exists, hence not querying and checking the song table
            querySongPrep.setString(1, songTitle);
            ResultSet result = querySongPrep.executeQuery();
            if (result.next()) {
                System.out.println("Song " + songTitle + " already exists!");
                return;
            }

            // insert new song
            int affectedRows = insertSongQueryPrep.executeUpdate(); // execute returns boolean; but executeUpdate returns the number of rows affected
            if (affectedRows == 1) { con.commit(); }
            else { throw new SQLException("Couldn't insert song"); }
        } catch (SQLException se) {
            System.out.println("Couldn't insert song: " + se.getMessage());
            try { con.rollback();
            } catch (SQLException se1) {
                System.out.println("Couldn't rollback change: " + se1.getMessage());
            }
        } finally {
            try { con.setAutoCommit(true); }
            catch (SQLException se) {
                System.out.println("Not able to set default auto commit behaviour: " + se.getMessage());
            }
        }
    }
}
