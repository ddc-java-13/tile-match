package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.tilematch.databinding.FragmentGameBinding;

public class GameFragment extends Fragment {

  private FragmentGameBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentGameBinding.inflate(inflater, container, false);
    //TODO attach listeners to ui controllers
    NavController navController = Navigation.findNavController(container);
    binding.backButton.setOnClickListener(
        (v) -> navController.navigate(GameFragmentDirections.actionGameFragmentToHomeFragment()));
    return binding.getRoot();
  }
}
