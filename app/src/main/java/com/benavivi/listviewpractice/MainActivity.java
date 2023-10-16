package com.benavivi.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.benavivi.listviewpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private ActivityMainBinding binding;
	private ArrayList<String> songsNameArray;

	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		songsNameArray = new ArrayList<>();
		createArrayListData();
		createListViewAdapter();

		setListeners();

	}

	private void setListeners () {
		binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick (AdapterView<?> adapterView, View view, int itemIndex, long l) {
				soundItemClickHandler(itemIndex);
				Toast.makeText(getApplicationContext(),"Currently Playing: " + songsNameArray.get(itemIndex),Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void soundItemClickHandler (int itemIndex) {
		switch (itemIndex) {
			case 0:
				playSound(R.raw.ehrling_adventure);
				break;
			case 1:
				playSound(R.raw.ehrling_nostalgic);
				break;
			case 2:
				playSound(R.raw.ehrling_fire);
				break;
			case 3:
				playSound(R.raw.ehrling_all_i_need);
				break;
			case 4:
				playSound(R.raw.ehrling_sun_kissed);
				break;
			case 5:
				playSound(R.raw.ehrling_tease);
				break;
			case 6:
				playSound(R.raw.ehrling_i_feel_good);
				break;

		}
	}
	private void playSound(int soundId){
		if(mediaPlayer != null && mediaPlayer.isPlaying()){
			mediaPlayer.stop();
		}
		mediaPlayer = MediaPlayer.create(getApplicationContext(), soundId);
		mediaPlayer.start();
	}

	private void createListViewAdapter () {
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,songsNameArray);
		binding.listView.setAdapter(adapter);
	}

	private void createArrayListData(){
		songsNameArray.add("Adventure");
		songsNameArray.add("Nostalgic");
		songsNameArray.add("Fire");
		songsNameArray.add("All I need");
		songsNameArray.add("Sun Kissed");
		songsNameArray.add("Tease");
		songsNameArray.add("I Feel Good");

	}
}