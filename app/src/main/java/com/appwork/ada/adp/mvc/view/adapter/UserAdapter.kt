package com.appwork.ada.adp.mvc.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.appwork.ada.adp.mvc.model.UserModel
import com.appwork.ada.databinding.IvUserBinding

/**
 * Created by Vivek Kumar belongs to APP WORK  on 25-09-2021.
 */
class UserAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserModel>() {

        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return UserVH(
            IvUserBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserVH -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    fun notifyAdapter() {
        notifyItemChanged(differ.currentList.size)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<UserModel>) {
        differ.submitList(list)
    }

    class UserVH(
        private val itemBinding: IvUserBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: UserModel) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            itemBinding.tvUser.text = item.name
            itemBinding.tvNum.text = item.number

        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: UserModel)
    }
}