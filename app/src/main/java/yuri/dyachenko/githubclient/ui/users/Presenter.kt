package yuri.dyachenko.githubclient.ui.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import yuri.dyachenko.githubclient.model.User
import yuri.dyachenko.githubclient.model.UsersRepo
import yuri.dyachenko.githubclient.ui.Screens

class Presenter(
    private val usersRepo: UsersRepo,
    private val router: Router
) : MvpPresenter<View>() {

    val usersListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        usersListPresenter.itemClickListener = {
            val user = usersListPresenter.users[it.pos]
            displayUser(user)
        }
        usersRepo
            .getUsers()
            .let(viewState::showUsers)
    }

    private fun displayUser(user: User) =
        router.navigateTo(Screens.user(user.login))
}