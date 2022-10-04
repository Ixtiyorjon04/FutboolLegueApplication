package uz.gita.futboollegueapplication.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.futboollegueapplication.R
import uz.gita.futboollegueapplication.databinding.Screen2Binding
import uz.gita.futboollegueapplication.ui.adapters.TableAdapterSeason

class Screen2 : Fragment(R.layout.screen_2) {
    private val viewBinding: Screen2Binding by viewBinding(Screen2Binding::bind)
    private var tableAdapterSeason: TableAdapterSeason? = null
    private val viewModel2: share by activityViewModels<share>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel2.share.observe(viewLifecycleOwner) {
            tableAdapterSeason = TableAdapterSeason(it)
            viewBinding.tableview.setAdapter(tableAdapterSeason)
            tableAdapterSeason?.setAllItems(it.columnHeaders, it.rowHeaders, it.cells)
        }
    }
}