package yuri.dyachenko.githubclient.ui.users

import yuri.dyachenko.githubclient.model.User
import yuri.dyachenko.githubclient.ui.list.ListPresenter

class UserListPresenter : ListPresenter<UserItemView> {

    val users = mutableListOf<User>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }

    override fun getCount() = users.size

    fun setUsers(list: List<User>) {
        users.clear()
        users.addAll(list)
    }
}