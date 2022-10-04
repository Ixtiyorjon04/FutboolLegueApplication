package uz.gita.futboollegueapplication.ui.holders

import android.util.Log
import com.bumptech.glide.Glide
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.squareup.picasso.Picasso
import uz.gita.futboollegueapplication.R
import uz.gita.futboollegueapplication.data.model.tableview.ImageCell
import uz.gita.futboollegueapplication.databinding.TableViewImageCellLayoutBinding

class ImageCellViewHolder(private val viewBinding: TableViewImageCellLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(url: ImageCell) {
        Picasso.get()
            .load(url.data)
            .placeholder(R.drawable.ic_baseline_sync_24)
            .centerCrop()
            .resize(100,100)
            .into(viewBinding.cellImage)
    }

}