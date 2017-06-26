package com.capstar.apps.people_mvvm.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.capstar.apps.people_mvvm.model.People

class ItemPeopleViewModel(private var context: Context,private var people: People?): BaseObservable() {

    val fullName: String = "%s.%s %s".format(people!!.name.title, people!!.name.first, people!!.name.last)

    val cellPhone: String = people!!.cell

    val email: String = people!!.email

    val profilePicture: String = people!!.picture.medium

    fun setPeople(people: People) {
        this.people = people
        notifyChange()
    }

    fun onItemClick(view: View) {

    }

    companion object {
        @BindingAdapter("imageUrl") fun setImageUrl(imageView: ImageView, url: String) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}