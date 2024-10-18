package playlist;

import playlist.classic.*;

public class Application
{
    public static void main(String[] args)
    {
        Artist art1 = new Artist("kakavoz");
        Artist art2 = new Artist("gazmanov");
        Artist art3 = new Artist("lazerdim400");
        Artist art4 = new Artist("anton");
        Artist art5 = new Artist("john pork");

        Song song1 = new Song("крутая песня", art1, 60);
        Song song2 = new Song("гамно песня", art1, 70);

        Song song3 = new Song("великолепная песня", art2, 85);
        Song song4 = new Song("превосходная песня", art2, 65);

        Song song5 = new Song("великолепная песня", art3, 85);
        Song song6 = new Song("сногсшибательная песня", art3, 955);

        Song song7 = new Song("бомбезная песня", art4, 82);
        Song song8 = new Song("песня", art4, 88);

        Song song9 = new Song("поганая песня", art5, 90);
        Song song10 = new Song("говнище песня", art5, 91);

        Playlist playlist = new Playlist(10);

        playlist.addSong(song1);
        playlist.addSong(song2);

        playlist.displayPlaylist();

    }
}
