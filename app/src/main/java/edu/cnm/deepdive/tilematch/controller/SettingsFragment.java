package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.tilematch.databinding.FragmentSettingsBinding;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import edu.cnm.deepdive.tilematch.model.entity.Game.Difficulty;

/**
 * SettingsFragment extends fragment.
 */
public class SettingsFragment extends Fragment {

  private FragmentSettingsBinding binding;

  /**
   * Inflates layout to viewGroup container. Defines navigation controller for the SettingsFragment.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentSettingsBinding.inflate(inflater, container, false);
    //todo attach listeners to ui controls
    NavController navController = Navigation.findNavController(container);
    binding.backButton.setOnClickListener(
        (v) -> navController.navigate(
            SettingsFragmentDirections.actionSettingsFragmentToHomeFragment()));
    return binding.getRoot();

  }
}
