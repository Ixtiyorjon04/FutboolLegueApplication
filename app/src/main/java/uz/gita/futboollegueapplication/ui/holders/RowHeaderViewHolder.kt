package uz.gita.futboollegueapplication.ui.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.futboollegueapplication.data.model.tableview.RowHeader
import uz.gita.futboollegueapplication.databinding.TableViewRowHeaderLayoutBinding

class RowHeaderViewHolder(private val viewBinding: TableViewRowHeaderLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: RowHeader) {
        viewBinding.rowHeaderTextview.text = data.data
    }

}