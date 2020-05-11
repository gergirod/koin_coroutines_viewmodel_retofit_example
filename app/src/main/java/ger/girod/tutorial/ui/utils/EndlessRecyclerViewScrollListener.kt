package ger.girod.tutorial.ui.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewScrollListener(private val  linearLayoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {

    private var visibleThresholds : Int = 5
    private var currentPage : Int = 1
    private var previousTotalItemCount : Int = 0
    private var isLoading : Boolean = true
    private val startPageIndex : Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        var totalItemCount = linearLayoutManager.itemCount
        var lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition()

        if(totalItemCount < previousTotalItemCount) {
            currentPage = startPageIndex
            previousTotalItemCount = totalItemCount
            if(totalItemCount == 0) {
                isLoading = true
            }
        }

        if(isLoading && (totalItemCount> previousTotalItemCount)) {
            isLoading = false
            previousTotalItemCount = totalItemCount
        }

        if(!isLoading && (lastVisiblePosition + visibleThresholds ) > totalItemCount) {
            currentPage++
            onLoadMore(currentPage, totalItemCount, recyclerView)
            isLoading = true
        }
    }

    abstract fun onLoadMore(page : Int, totalItemsCount : Int, view : RecyclerView)

}