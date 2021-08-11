package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.tilematch.databinding.FragmentSettingsBinding;
import edu.cnm.deepdive.tilematch.model.entity.Game.Difficulty;
import edu.cnm.deepdive.tilematch.viewmodel.MainViewModel;

/**
 * SettingsFragment extends fragment.
 */
public class SettingsFragment extends Fragment {

  private FragmentSettingsBinding binding;
  private MainViewModel mainViewModel;

  /**
   * Inflates layout to viewGroup container. Defines navigation controller for the
   * SettingsFragment.
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    binding = FragmentSettingsBinding.inflate(inflater, container, false);
    //todo attach listeners to ui controls
    NavController navController = Navigation.findNavController(container);
    binding.backButton.setOnClickListener(
        (v) -> navController.navigate(
            SettingsFragmentDirections.actionSettingsFragmentToHomeFragment()));
    binding.difficulty.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Difficulty difficulty = (Difficulty) parent.getItemAtPosition(position);
        mainViewModel.getDifficulty().observe(getViewLifecycleOwner(), (gameDifficulty) -> {
          //TODO needs to update difficulty in order to pass current difficulty to constructor startGame(difficulty)
        });
        mainViewModel.startGame();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {
      }
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.difficulty.setAdapter(
        new ArrayAdapter<Difficulty>(getContext(), android.R.layout.simple_spinner_item,
            Difficulty.values()));
  }
}
