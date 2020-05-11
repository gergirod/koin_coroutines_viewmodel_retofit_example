package ger.girod.tutorial.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import ger.girod.tutorial.domain.models.UserModel
import kotlinx.android.synthetic.main.row_layout.view.*

class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun populateRow(userModel: UserModel) {
        view.user_image.load(userModel.picture.thumbnail) {
            transformations(CircleCropTransformation())
        }
        view.user_name.text = userModel.name.getFullName()
        view.user_email.text = userModel.email
        view.user_phone.text = userModel.phone
    }
}