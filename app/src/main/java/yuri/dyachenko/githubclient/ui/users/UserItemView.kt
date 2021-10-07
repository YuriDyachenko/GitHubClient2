package yuri.dyachenko.githubclient.ui.users

import yuri.dyachenko.githubclient.ui.list.ItemView

interface UserItemView : ItemView {

    fun setLogin(text: String)
}