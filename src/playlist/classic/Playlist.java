package playlist.classic;

import java.util.Arrays;

import static operationsWithArray.Main.numArray;

public class Playlist
{
    Song[] playlist;

    public Playlist(int playlistSize)
    {
        if (playlistSize <= 0)
        {
            throw new IllegalArgumentException("Введите корректное значение");
        }

        playlist = new Song[playlistSize];
    }

    public void addSong(Song song)
    {
        for(int i = 0; i <= playlist.length; i++)
        {
            if (playlist[i] == null)
            {
                playlist[i] = song;
                return;
            }
        }
    }

    public void displayPlaylist()
    {
        System.out.print(Arrays.toString(playlist));
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlist=" + Arrays.toString(playlist) +
                '}';
    }
}