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
import com.greate43.sk.optussenerio2.databinding.FragmentMainBinding
import com.greate43.sk.optussenerio2.view.adapters.MainAdapter
import com.greate43.sk.optussenerio2.viewmodel.MainViewModel


class MainFragment : Fragment() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.mainRecyclerView
            .setHasFixedSize(true)
        val llm = LinearLayoutManager(context)
        llm.orientation = RecyclerView.VERTICAL

        binding.mainRecyclerView
            .layoutManager = llm
        binding.mainRecyclerView
            .itemAnimator = DefaultItemAnimator()

        adapter = MainAdapter {
            val manager: FragmentManager = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(
                R.id.fragmentContainerView,
                AlbumFragment.newInstance(it.id)
            )
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.mainRecyclerView.adapter = adapter
        mainViewModel.listUser().observe(viewLifecycleOwner,
            Observer { users ->
                adapter.setData(users)
            })
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }
}
