package yuri.dyachenko.githubclient.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import yuri.dyachenko.githubclient.arguments
import yuri.dyachenko.githubclient.databinding.FragmentUserBinding
import yuri.dyachenko.githubclient.impl.UsersListRepoImpl
import yuri.dyachenko.githubclient.model.User

class UserFragment : MvpAppCompatFragment(), View {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter by moxyPresenter {
        Presenter(UsersListRepoImpl(), userLogin)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun showUser(user: User) {
        binding.loginTextView.text = user.login
    }

    companion object {
        private const val ARG_USER_LOGIN = "ARG_USER_LOGIN"

        fun newInstance(login: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to login)
    }
}