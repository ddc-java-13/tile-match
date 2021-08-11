package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.tilematch.databinding.FragmentHomeBinding;

/**
 * HomeFragment extends fragment.
 */
public class HomeFragment extends Fragment {

  private FragmentHomeBinding binding;

  /**
   * Inflates layout to viewGroup container. Defines navigation controller for the HomeFragment.
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
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
        //(v) -> navController.navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment()));
        (v) -> navController.navigate(
            HomeFragmentDirections.actionHomeFragmentToPreferencesFragment()));
    binding.highScores.setOnClickListener(
        (v) -> navController.navigate(
            HomeFragmentDirections.actionHomeFragmentToHighScoresFragment()));
    return binding.getRoot();
  }
}