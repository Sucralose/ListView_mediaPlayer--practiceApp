package com.benavivi.listviewpractice;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MusicHandler {
	private  MediaPlayer mediaPlayer;
	private  HashMap<String,Integer> songsId;
	private  ArrayList<String> songsNameArray;
	private Context currentContext;

	public MusicHandler (Context BaseContext, Context currentContext) {
		songsId = new HashMap<>();
		songsNameArray = new ArrayList<>();
		try {
			InputStream inputStream = BaseContext.getResources().openRawResource(R.raw.songs_list);
			BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while ((line = input.readLine()) != null) {
				//Before the colon are the songs name.
				String name,song_id_name;
				name = line.substring(0,line.indexOf(":"));
				song_id_name = line.substring(line.indexOf(":")+1);
				int song_id = BaseContext.getResources().getIdentifier(song_id_name,"raw",BaseContext.getPackageName());
				songsId.put(name,song_id);
				songsNameArray.add(name);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		this.currentContext = currentContext;
	}
	public ArrayList<String> getSongsNameArray (){
		return songsNameArray;
	}
	public String getSongNameFromId(int index){
		return songsNameArray.get(index);
	}

	public void playSound (int itemIndex){
		if(mediaPlayer != null && mediaPlayer.isPlaying()){
			mediaPlayer.stop();
		}
		mediaPlayer = MediaPlayer.create(currentContext,songsId.get(songsNameArray.get(itemIndex)));
		mediaPlayer.start();
	}

}
