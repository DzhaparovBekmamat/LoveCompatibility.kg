package com.template.lovecompatibilitykg.sharedPreferences.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.template.lovecompatibilitykg.R
import com.template.lovecompatibilitykg.databinding.ItemBoardBinding
import com.template.lovecompatibilitykg.sharedPreferences.model.BoardModel

class BoardAdapter(val click: () -> Unit) :
    RecyclerView.Adapter<BoardAdapter.OnBoardingViewHolder>() {

    private val list = listOf(
        BoardModel(
            "Love: A Dance of Hearts",
            "Love is a beautiful dance of hearts,\n a rhythm of emotions that connects souls.",
            R.raw.life
        ),
        BoardModel(
            "Love's Endless Embrace",
            "Love's embrace knows no bounds,\n forever holding us close" +
                    "you to cherish love",
            R.raw.man
        ),
        BoardModel(
            "Love's Healing Power",
            "Love has the power to heal \nwounds and mend broken spirits.",
            R.raw.yoga
        ),
        BoardModel(
            "Love's Spark: Igniting Souls",
            "Love's spark ignites souls,\n setting them ablaze with passion and purpose.",
            R.raw.love
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OnBoardingViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(boardModel: BoardModel) {
            with(binding) {
                titleItemBoard.text = boardModel.title
                descriptionItemBoard.text = boardModel.description
                lottieAnimation.setAnimation(boardModel.image)
                buttonItemBoard.isVisible = adapterPosition == list.lastIndex
                buttonItemBoard.setOnClickListener {
                    click()
                }
            }
        }
    }
}
