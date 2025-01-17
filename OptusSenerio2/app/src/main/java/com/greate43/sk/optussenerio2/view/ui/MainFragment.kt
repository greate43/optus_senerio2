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
     val mainViewModel: MainViewModel by viewModels()
    lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        requireActivity().title =getString(R.string.userInfoTitle)
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
        refresh(binding)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.mainRefresh.setOnRefreshListener {
            refresh(binding)
        }
        return binding.root
    }

    private fun refresh(binding: FragmentMainBinding) {
        binding.mainRefresh.isRefreshing = true
        mainViewModel.listUser().observe(viewLifecycleOwner,
            Observer { users ->
                adapter.setData(users)
                binding.mainRefresh.isRefreshing = false
            })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }
}
