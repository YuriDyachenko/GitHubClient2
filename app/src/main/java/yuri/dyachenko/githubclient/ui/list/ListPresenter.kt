package yuri.dyachenko.githubclient.ui.list

interface ListPresenter<V : ItemView> {

    var itemClickListener: ((V) -> Unit)?

    fun bindView(view: V)
    fun getCount(): Int
}