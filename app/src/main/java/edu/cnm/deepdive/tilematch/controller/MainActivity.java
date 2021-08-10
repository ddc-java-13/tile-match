package edu.cnm.deepdive.tilematch.controller;

import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tilematch.R;
import edu.cnm.deepdive.tilematch.databinding.ActivityMainBinding;
import edu.cnm.deepdive.tilematch.model.dto.Image;
import edu.cnm.deepdive.tilematch.viewmodel.MainViewModel;

/**
 * MainActivity extends AppCompatActivity
 */
public class MainActivity extends AppCompatActivity {


private ActivityMainBinding binding;

  /**
   * Inflates layout to viewGroup container. Puts app into fullscreen view.
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

  }
}