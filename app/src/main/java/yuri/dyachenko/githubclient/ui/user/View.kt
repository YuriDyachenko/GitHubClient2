package yuri.dyachenko.githubclient.ui.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import yuri.dyachenko.githubclient.model.User

interface View : MvpView {

    @SingleState
    fun showUser(user: User)
}