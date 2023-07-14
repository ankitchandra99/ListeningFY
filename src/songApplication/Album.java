package songApplication;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String AlbumName;

    private String artistName;

    private List<Song> songList;

    public Album(String albumName, String artistName) {
        AlbumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongByTitle(String title){

        for(Song song:songList){
            if(song.getTitle().equals(title)){
                return true;
            }
        }

        //unable to find out song

        return false;

    }

    public String addNewSongToAlbum(String title,double duration){

       if(findSongByTitle(title)){
           return "Song is already added" ;
       }

       Song song=new Song(title,duration);
       this.songList.add(song);
       return "Song has been added sucesssfully" ;
    }

    public String addSongToPlayList(int songNo, ArrayList<Song> playList){
        //Add this songNo (Album songlist -> songNo)

        //songNo:->1 2 3 4 5
        //index :->0 1 2 3 4

        int index= songNo -1;
        //Once you find out that song add it to the end of playlist
        if(index>=0  && index<songList.size()){
            Song song=songList.get(index);
            playList.add(song);
            return "Song added to playList successfully" ;
        }
        else{
            return "Song No. entered is out of range" ;
        }


    }

    public String  addSongToPlayList(String title, ArrayList<Song> playList){
        //Assume that song is present int that songList

        for(Song song :songList){
            if(song.getTitle().equals(title)){
                playList.add(song);
                return "song added to playList" ;
            }
        }

        return "No song found with given title";
    }
}
