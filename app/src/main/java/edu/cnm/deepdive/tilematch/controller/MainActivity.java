package edu.cnm.deepdive.tilematch.controller;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tilematch.R;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import edu.cnm.deepdive.tilematch.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  private ImageView image;
  private ArrayAdapter<Gallery> adapter;
  private Button imageSelector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.loadHits();
    setContentView(R.layout.activity_main);

     Button[] buttons= new Button[] {};

  }
}