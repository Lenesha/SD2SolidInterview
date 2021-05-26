package com.example.sd2.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.network.viewmodel.CustomViewModel
import com.example.sd2.R
import com.example.sd2.databinding.UserFragmentBinding
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class UserFragment : Fragment() {
    private var _binding: UserFragmentBinding? = null
    private val viewModel: CustomViewModel by activityViewModels()
    private lateinit var pageListAdapter: GridListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserFragmentBinding.inflate(inflater, container, false)
        return _binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()

        val downloader = OkHttp3Downloader(context)
        val picasso = Picasso.Builder(context).downloader(downloader).build()

        viewModel.selectedItem.observe(viewLifecycleOwner, Observer { item ->


            _binding?.userTitle?.text = item.name
            picasso.load(item.image).into(_binding?.userImage)

            val layoutManagerlocal = GridLayoutManager(context, 2)

            Log.i("EXM", "count us" + item.items.size)

            if (item.items.size % 2 != 0) {
                val lookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (position) {
                            0 -> 2
                            else -> 1
                        }
                    }
                }
                layoutManagerlocal.spanSizeLookup = lookup
                _binding?.postList?.apply {
                    layoutManager = layoutManagerlocal
                }

            }
            pageListAdapter.setAdapterList(item.items)

        })

    }

    private fun setAdapter() {
        pageListAdapter = GridListAdapter(requireContext())

        _binding?.postList?.apply {
            addItemDecoration(
                GridItemOffsetDecoration(
                    2,
                    resources.getDimensionPixelSize(R.dimen.tendp)
                )
            )
            adapter = pageListAdapter

        }

    }

}
