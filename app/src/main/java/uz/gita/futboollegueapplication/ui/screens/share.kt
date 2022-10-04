package uz.gita.futboollegueapplication.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.futboollegueapplication.data.TableDataWrapperSeason

class share : ViewModel() {
    var share = MutableLiveData<TableDataWrapperSeason>()
    fun setvalue(value: TableDataWrapperSeason) {
        share.value = value
    }
}