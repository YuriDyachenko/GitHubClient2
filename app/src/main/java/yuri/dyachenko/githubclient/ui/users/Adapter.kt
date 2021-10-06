package yuri.dyachenko.githubclient.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yuri.dyachenko.githubclient.databinding.UserItemLayoutBinding
import yuri.dyachenko.githubclient.model.UserItemView
import yuri.dyachenko.githubclient.model.UserListPresenter

class Adapter(private val presenter: UserListPresenter) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            UserItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(private val binding: UserItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), UserItemView {

        override fun setLogin(text: String) = with(binding) {
            loginTextView.text = text
        }

        override var pos = -1
    }}