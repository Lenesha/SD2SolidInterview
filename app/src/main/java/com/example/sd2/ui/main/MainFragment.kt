package com.example.sd2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.network.viewmodel.CustomViewModel
import com.example.sd2.R
import com.example.sd2.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private lateinit var pageListAdapter: PageListAdapter
    private val viewModel: CustomViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return _binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        fetchRetroInfo()
        navigate()
    }

    private fun navigate() {
        pageListAdapter.onItemClick = { it ->

            viewModel.selectItem(it)
            val ft = requireActivity().supportFragmentManager.beginTransaction()

            ft.replace(R.id.container, UserFragment(),
                "Detail")
                .addToBackStack(null)
                .commit()
        }

    }

    private fun setAdapter() {
        pageListAdapter = PageListAdapter()

        _binding?.postList?.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
           adapter = pageListAdapter

        }

    }

    fun fetchRetroInfo() {
        viewModel.userList.observe(viewLifecycleOwner, Observer {
            pageListAdapter.submitList(it)
        })
    }


}