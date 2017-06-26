package com.capstar.apps.people_mvvm.viewmodel

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.capstar.apps.people_mvvm.model.People

class PeopleDetailViewModel(people: People) {

    val fullUserName: String = "%s.%s %s".format(people.name.title, people.name.first, people.name.last)

    val userName: String = people.userName.username

    val emailVisibility: Int = if (people.hasEmail) View.VISIBLE  else View.GONE

    val cell: String = people.cell

    val profilePicture: String = people.picture.large

    val address: String = "%s %s %s".format(people.location.street, people.location.city, people.location.state)

    val gender: String = people.gender

    companion object {

        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context).load(imageUrl).into(view)
        }
    }

}