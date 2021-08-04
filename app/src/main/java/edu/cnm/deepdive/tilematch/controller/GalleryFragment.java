package edu.cnm.deepdive.tilematch.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.tilematch.adapter.GalleryAdapter;
import edu.cnm.deepdive.tilematch.databinding.FragmentGameBinding;
import edu.cnm.deepdive.tilematch.viewmodel.GalleryViewModel;

public class GalleryFragment extends Fragment {

  private GalleryViewModel galleryViewModel;
  private GalleryAdapter adapter;
  private FragmentGameBinding binding;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentGameBinding
        .inflate(inflater, container, false);
    return binding.getRoot();
  }

}
