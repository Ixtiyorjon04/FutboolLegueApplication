package uz.gita.futboollegueapplication.data.model

import uz.gita.futboollegueapplication.data.model.tableview.Cell
import uz.gita.futboollegueapplication.data.model.tableview.ColumnHeader
import uz.gita.futboollegueapplication.data.model.tableview.RowHeader

data class TableDataWrapper(
    val rowHeaders: List<RowHeader>,
    val columnHeaders: List<ColumnHeader>,
    val cells: List<List<Cell>>,
    val id:List<Cell>
) {
    companion object {
        const val IMG_COLUMN_INDEX = 0
        const val NAME_COLUMN_INDEX = 1
        const val SLUG_COLUMN_INDEX = 2
        const val ABBR_COLUMN_INDEX = 3
    }
}