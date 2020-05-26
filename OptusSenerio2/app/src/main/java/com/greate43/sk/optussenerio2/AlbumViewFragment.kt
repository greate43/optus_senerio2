package com.greate43.sk.optussenerio2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_ID = "id"


class AlbumViewFragment : Fragment() {
    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_view, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            AlbumViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID, param1)
                }
            }
    }
}
