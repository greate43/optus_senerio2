package com.greate43.sk.optussenerio2.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greate43.sk.optussenerio2.R
import com.greate43.sk.optussenerio2.databinding.FragmentAlbumBinding
import com.greate43.sk.optussenerio2.view.adapters.AlbumAdapter
import com.greate43.sk.optussenerio2.viewmodel.MainViewModel


private const val ARG_ID = "ARG_ID"

class AlbumFragment : Fragment() {
    var id: String = ""
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: AlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_ID).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAlbumBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_album, container, false)
        requireActivity().title ="Album Info"

        binding.albumIdFB.text = id
        binding.recyclerViewAlbum
            .setHasFixedSize(true)
        val llm = LinearLayoutManager(context)
        llm.orientation = RecyclerView.VERTICAL

        binding.recyclerViewAlbum
            .layoutManager = llm
        binding.recyclerViewAlbum
            .itemAnimator = DefaultItemAnimator()

        adapter = AlbumAdapter {
            val manager: FragmentManager = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(
                R.id.fragmentContainerView,
                AlbumViewFragment.newInstance(photos = it)
            )
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.recyclerViewAlbum.adapter = adapter

        refresh(binding)
        binding.albumRefresh.setOnRefreshListener {
            refresh(binding)
        }
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    private fun refresh(binding: FragmentAlbumBinding) {
        binding.albumRefresh.isRefreshing = true
        id.let {
            mainViewModel.getPhotoById(it.toInt()).observe(viewLifecycleOwner,
                Observer { users ->
                    adapter.setData(users)
                    binding.albumRefresh.isRefreshing = false
                })
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(id: Int) =
            AlbumFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, id)
                }
            }
    }
}
