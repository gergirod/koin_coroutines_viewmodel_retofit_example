package ger.girod.tutorial.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ger.girod.tutorial.R
import ger.girod.tutorial.domain.models.UserModel

class UserListAdapter : RecyclerView.Adapter<ViewHolder>() {

    var userList : ArrayList<UserModel> = ArrayList()

    fun setList(users : List<UserModel>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }

    fun loadMore(users: List<UserModel>) {
        userList.addAll(users)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val userModel : UserModel = userList[position]
        holder.populateRow(userModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }
}