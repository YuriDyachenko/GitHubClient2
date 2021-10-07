package yuri.dyachenko.githubclient.ui.users

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import yuri.dyachenko.githubclient.App
import yuri.dyachenko.githubclient.databinding.FragmentUsersBinding
import yuri.dyachenko.githubclient.impl.UsersListRepoImpl
import yuri.dyachenko.githubclient.model.User

class UsersFragment : MvpAppCompatFragment(), View {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        Presenter(UsersListRepoImpl(), App.router)
    }

    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false)
        .also {
            _binding = it
            adapter = Adapter(presenter.usersListPresenter)
            binding.usersRecyclerView.adapter = adapter
        }
        .root

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun showUsers(users: List<User>) {
        presenter.usersListPresenter.setUsers(users)
        adapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = UsersFragment()
    }
}