package uz.gita.futboollegueapplication.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.futboollegueapplication.R
import uz.gita.futboollegueapplication.databinding.ScreenMainBinding
import uz.gita.futboollegueapplication.presenter.MainViewModel
import uz.gita.futboollegueapplication.presenter.MainViewModelImpl
import uz.gita.futboollegueapplication.ui.adapters.TableAdapter
import uz.gita.futboollegueapplication.ui.adapters.TableAdapterSeason
import uz.gita.futboollegueapplication.utils.MonthYearPickerDialog

class MainScreen : Fragment(R.layout.screen_main) {
    private val viewBinding: ScreenMainBinding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val viewModel2: share by activityViewModels<share>()
    private val navController: NavController by lazy { findNavController() }
    private var tableAdapter: TableAdapter? = null
    private var tableAdapterSeason: TableAdapterSeason? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.messageLiveData.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
//        tableAdapter?.setListener { its ->
//            val newFragment = MonthYearPickerDialog()
//            newFragment.setListener {
//                viewModel.season(its[0], it, its[1])
//            }
//            newFragment.show(childFragmentManager, "DatePicker")
//
//        }

        viewModel.seasonListLiveData.observe(this) {
//            tableAdapterSeason = TableAdapterSeason(it)
//            viewBinding.tableview.setAdapter(tableAdapterSeason)
//            tableAdapterSeason?.setAllItems(it.columnHeaders, it.rowHeaders, it.cells)
            navController.navigate(MainScreenDirections.actionMainScreenToScreen2())
            viewModel2.setvalue(it)

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.leagueListLiveData.observe(viewLifecycleOwner) {
            tableAdapter = TableAdapter(it)
            viewBinding.tableview.setAdapter(tableAdapter)
            tableAdapter?.setAllItems(it.columnHeaders, it.rowHeaders, it.cells)
            tableAdapter!!.setListener { its ->
                val newFragment = MonthYearPickerDialog()
                newFragment.setListener {
                    viewModel.season(its[0], it, its[1])
                }
//                newFragment.show(childFragmentManager, "DatePicker")

            }
        }


        viewBinding.btnSync.setOnClickListener {
            viewModel.getAll()
        }
    }

}