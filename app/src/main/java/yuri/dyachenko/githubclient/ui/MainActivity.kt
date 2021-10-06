package yuri.dyachenko.githubclient.ui

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import yuri.dyachenko.githubclient.App.Navigation.navigatorHolder
import yuri.dyachenko.githubclient.App.Navigation.router

class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(Screens.users())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}