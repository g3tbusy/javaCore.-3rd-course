package playlist.classic;

public class Song
{
    String name;
    Artist artist;
    int songLength;

    public Song(String name, Artist artist, int songLength)
    {
        this.name = name;
        this.artist = artist;
        this.songLength = songLength;
    }

    public void setSongLength(int second)
    {
        if (second < 60)
        {
            throw new IllegalArgumentException("Song is < 60 sec");
        }

        songLength = second;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist=" + artist +
                ", songLength=" + songLength +
                '}';
    }
}