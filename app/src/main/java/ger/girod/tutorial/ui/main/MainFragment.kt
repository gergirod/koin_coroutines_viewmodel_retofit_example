package ger.girod.tutorial.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ger.girod.tutorial.R
import ger.girod.tutorial.ui.utils.EndlessRecyclerViewScrollListener
import ger.girod.tutorial.ui.utils.ScreenState
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val mainViewModel : MainViewModel by viewModel()
    private val userListAdapter : UserListAdapter by lazy {
        UserListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initUserList()
        mainViewModel.getInitialUserList()
    }

    private fun observeViewModel() {

        mainViewModel.screenStateData.observe(viewLifecycleOwner, Observer {
            when(it) {
                ScreenState.LoadingFinsh -> progress_bar.visibility = View.GONE
                ScreenState.Loading -> progress_bar.visibility = View.VISIBLE
            }
        })

        mainViewModel.userListData.observe(viewLifecycleOwner, Observer {
            userListAdapter.setList(it.results)
        })

        mainViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            showErrorMessage(it)
        })

        mainViewModel.loadMoreData.observe(viewLifecycleOwner, Observer {
            userListAdapter.loadMore(it.results)
        })

    }

    private fun initUserList() {

        val linearLayoutManager = LinearLayoutManager(activity)
        val endlessRecyclerViewScrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                mainViewModel.loadMore(page)
            }
        }
        user_lit.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userListAdapter
            addOnScrollListener(endlessRecyclerViewScrollListener)
        }

    }

    private fun showErrorMessage(errorMessage : String) {

        Snackbar.make(main, errorMessage, Snackbar.LENGTH_LONG).apply {
            setAction("Dismiss") {
                dismiss()
            }
        }.show()

    }

}
