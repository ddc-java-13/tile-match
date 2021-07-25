package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.tilematch.R;
import edu.cnm.deepdive.tilematch.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

  private FragmentHomeBinding binding;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentHomeBinding.inflate(inflater, container, false);
    //TODO attach listeners to ui controls
    NavController navController = Navigation.findNavController(container);
    binding.startGame.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToGameFragment());
          }
        });
    binding.gameSettings.setOnClickListener(
        (v) -> navController.navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment()));
    binding.highScores.setOnClickListener(
        (v) -> navController.navigate(HomeFragmentDirections.actionHomeFragmentToHighScoresFragment()));
    return binding.getRoot();
  }
}