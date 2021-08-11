package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.tilematch.databinding.ActivityMainBinding;

/**
 * MainActivity extends AppCompatActivity
 */
public class MainActivity extends AppCompatActivity {


  private ActivityMainBinding binding;

  /**
   * Inflates layout to viewGroup container. Puts app into fullscreen view.
   *
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