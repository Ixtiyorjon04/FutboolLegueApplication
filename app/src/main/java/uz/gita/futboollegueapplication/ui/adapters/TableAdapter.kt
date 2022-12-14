package uz.gita.futboollegueapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.futboollegueapplication.R
import uz.gita.futboollegueapplication.data.model.TableDataWrapper
import uz.gita.futboollegueapplication.data.model.tableview.*
import uz.gita.futboollegueapplication.databinding.TableViewCellLayoutBinding
import uz.gita.futboollegueapplication.databinding.TableViewColumnHeaderLayoutBinding
import uz.gita.futboollegueapplication.databinding.TableViewImageCellLayoutBinding
import uz.gita.futboollegueapplication.databinding.TableViewRowHeaderLayoutBinding
import uz.gita.futboollegueapplication.ui.holders.ColumnHeaderViewHolder
import uz.gita.futboollegueapplication.ui.holders.ImageCellViewHolder
import uz.gita.futboollegueapplication.ui.holders.RowHeaderViewHolder
import uz.gita.futboollegueapplication.ui.holders.TextCellViewHolder


class TableAdapter(private val tableData: TableDataWrapper) :
    AbstractTableAdapter<ColumnHeader, RowHeader, Cell>() {

    private val TEXT_CELL_TYPE = 1
    private val IMG_CELL_TYPE = 2
    private var listener: ((ArrayList<String>) -> Unit)? = null
    fun setListener(block: ((ArrayList<String>) -> Unit)) {
        listener = block
    }

    override fun onCreateCellViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        return if (viewType == TEXT_CELL_TYPE) {
            TextCellViewHolder(
                TableViewCellLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else ImageCellViewHolder(
            TableViewImageCellLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindCellViewHolder(
        holder: AbstractViewHolder,
        cellItemModel: Cell?,
        columnPosition: Int,
        rowPosition: Int
    ) {
        if (holder.itemViewType == TEXT_CELL_TYPE) {
            val textCellViewHolder = holder as TextCellViewHolder
            textCellViewHolder.bind(cellItemModel as TextCell)
            holder.itemView.setOnClickListener {
                listener!!.invoke(
                    arrayListOf(
                        tableData.id[rowPosition].data,
                        tableData.cells[rowPosition][1].data
                    )
                )
            }
        } else {
            val imageCellViewHolder = holder as ImageCellViewHolder
            imageCellViewHolder.bind(cellItemModel as ImageCell)
        }
    }

    override fun onCreateColumnHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder =
        ColumnHeaderViewHolder(
            TableViewColumnHeaderLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder,
        columnHeaderItemModel: ColumnHeader?,
        columnPosition: Int
    ) {
        val columnHeaderViewHolder = holder as ColumnHeaderViewHolder
        columnHeaderViewHolder.bind(columnHeaderItemModel!!)
    }

    override fun onCreateRowHeaderViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder =
        RowHeaderViewHolder(
            TableViewRowHeaderLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder,
        rowHeaderItemModel: RowHeader?,
        rowPosition: Int
    ) {
        val rowHeaderViewHolder = holder as RowHeaderViewHolder
        rowHeaderViewHolder.bind(rowHeaderItemModel!!)
    }

    override fun onCreateCornerView(parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.table_view_corner_layout, parent, false
        )


    override fun getCellItemViewType(column: Int): Int {
        return if (column == TableDataWrapper.IMG_COLUMN_INDEX) IMG_CELL_TYPE
        else TEXT_CELL_TYPE
    }

}