package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tilematch.adapter.GalleryAdapter;
import edu.cnm.deepdive.tilematch.databinding.FragmentGameBinding;
import edu.cnm.deepdive.tilematch.viewmodel.GalleryViewModel;
import edu.cnm.deepdive.tilematch.viewmodel.MainViewModel;

public class GalleryFragment extends Fragment {

  private MainViewModel mainViewModel;
  private FragmentGameBinding binding;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentGameBinding
        .inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    mainViewModel.getTiles().observe(getViewLifecycleOwner(), (tiles) -> {
      GalleryAdapter adapter = new GalleryAdapter(getContext(), tiles, (v, position) ->{});
      binding.tileScheme.setAdapter(adapter);
    });
  }
}
