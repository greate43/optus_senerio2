package com.greate43.sk.optussenerio2.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.greate43.sk.optussenerio2.R
import com.greate43.sk.optussenerio2.databinding.FragmentAlbumViewBinding
import com.greate43.sk.optussenerio2.services.model.Photos


private const val ARG_PHOTOS = "ARG_PHOTOS"


class AlbumViewFragment : Fragment() {
    private var photo: Photos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photo = it.getParcelable(ARG_PHOTOS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAlbumViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_album_view, container, false)
        requireActivity().title ="Album View"



        binding.photos = photo

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(photos: Photos) =
            AlbumViewFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PHOTOS, photos)
                }
            }
    }
}
