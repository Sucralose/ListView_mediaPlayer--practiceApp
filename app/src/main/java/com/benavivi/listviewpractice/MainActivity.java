package com.benavivi.listviewpractice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.benavivi.listviewpractice.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
	private ActivityMainBinding binding;
	private MusicHandler musicHandler;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		createMusicHandler();
		createListViewAdapter();

		setListeners();

	}

	private void createMusicHandler () {
		musicHandler = new MusicHandler(getBaseContext(),getApplicationContext());
	}

	private void setListeners () {
		binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick (AdapterView<?> adapterView, View view, int itemIndex, long l) {
				musicHandler.playSound(itemIndex);
				showShortToast("Currently Playing: " +musicHandler.getSongNameFromId(itemIndex));
			}
		});
	}




	private void createListViewAdapter () {
		customListViewAdapter customListViewAdapter = new customListViewAdapter(getApplicationContext(),  musicHandler.getSongsNameArray());
		//ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,songsNameArray);
		binding.listView.setAdapter(customListViewAdapter);
	}


	private void showShortToast(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}

}