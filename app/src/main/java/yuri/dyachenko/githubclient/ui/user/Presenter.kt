package yuri.dyachenko.githubclient.ui.user

import moxy.MvpPresenter
import yuri.dyachenko.githubclient.model.UsersRepo

class Presenter(
    private val usersRepo: UsersRepo,
    private val login: String
) : MvpPresenter<View>() {

    override fun onFirstViewAttach() {
        usersRepo
            .getUserByLogin(login)
            ?.let(viewState::showUser)
    }
}