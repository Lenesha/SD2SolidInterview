package com.example.sd2.ui.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class GridItemOffsetDecoration(private val spanCount: Int, private var mItemOffset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        outRect.left = mItemOffset;
        outRect.right = mItemOffset;
        outRect.bottom = mItemOffset;
        outRect.top = mItemOffset;

    }
}