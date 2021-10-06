package yuri.dyachenko.githubclient.model

interface ListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}