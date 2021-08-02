package edu.cnm.deepdive.tilematch.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tilematch.R;
import edu.cnm.deepdive.tilematch.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.loadHits();
    setContentView(R.layout.activity_main);

  }
}