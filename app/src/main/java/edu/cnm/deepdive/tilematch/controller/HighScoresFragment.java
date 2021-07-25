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
import edu.cnm.deepdive.tilematch.databinding.FragmentHighScoresBinding;

public class HighScoresFragment extends Fragment {

  private FragmentHighScoresBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentHighScoresBinding.inflate(inflater, container, false);
    //TODO attach listeners to ui contorls
    NavController navController = Navigation.findNavController(container);
    binding.backButton.setOnClickListener(
        (v) -> navController
            .navigate(HighScoresFragmentDirections.actionHighScoresFragmentToHomeFragment()));
    return binding.getRoot();
  }
}
