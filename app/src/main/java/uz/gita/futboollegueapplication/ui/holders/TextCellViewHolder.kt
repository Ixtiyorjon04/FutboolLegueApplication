package uz.gita.futboollegueapplication.ui.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.futboollegueapplication.data.model.tableview.Cell
import uz.gita.futboollegueapplication.data.model.tableview.TextCell
import uz.gita.futboollegueapplication.databinding.TableViewCellLayoutBinding

class TextCellViewHolder(private val viewBinding: TableViewCellLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: TextCell) {
        viewBinding.cxellData.text = data.data
    }

}