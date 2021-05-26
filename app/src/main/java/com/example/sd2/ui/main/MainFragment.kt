package com.example.sd2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.network.viewmodel.RetroViewModel
import com.example.sd2.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private lateinit var viewModel: RetroViewModel
    private lateinit var pageListAdapter: PageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return _binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        setAdapter()
        fetchRetroInfo()
    }

    private fun setAdapter() {
        _binding?.postList?.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            pageListAdapter  = PageListAdapter ()
            _binding?.postList?.adapter = pageListAdapter

        }

    }
    fun fetchRetroInfo(){
        viewModel.userList.observe(viewLifecycleOwner, Observer {
            pageListAdapter.submitList(it)
        })
    }

    fun  initViewModel(){
        viewModel = ViewModelProvider(this).get(RetroViewModel::class.java)

    }

}