package kz.just_code.mvp_and_mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.mvp_and_mvvm.databinding.ItemFaqBinding
import kz.just_code.mvp_and_mvvm.mvp.FaqPresenter
import kz.just_code.mvp_and_mvvm.repository.Faq

class FaqAdapter : ListAdapter<Faq, FaqAdapter.FaqViewHolder>(FaqDiffUtils) {
    var click: ((Faq)->Unit)?=null

    object FaqDiffUtils : DiffUtil.ItemCallback<Faq>() {
        override fun areItemsTheSame(oldItem: Faq, newItem: Faq): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Faq, newItem: Faq): Boolean {
            return oldItem == newItem
        }

    }

   inner class FaqViewHolder(private val binding: ItemFaqBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Faq) {
            binding.title.text = itemView.context.getString(item.title)

            itemView.setOnClickListener {
                click?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
      return FaqViewHolder(
          ItemFaqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
       holder.bind(getItem(position))
    }
}