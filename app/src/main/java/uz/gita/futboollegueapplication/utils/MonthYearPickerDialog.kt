package uz.gita.futboollegueapplication.utils


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.futboollegueapplication.R
import uz.gita.futboollegueapplication.databinding.DialogBinding
import java.util.*

class MonthYearPickerDialog : DialogFragment(R.layout.dialog) {
    private val binding: DialogBinding by viewBinding(DialogBinding::bind)
    private var listener: ((Int) -> Unit)? = null

    fun setListener(listener: ((Int) -> Unit)) {
        this.listener = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = true
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cal: Calendar = Calendar.getInstance()
        val year: Int = cal.get(Calendar.YEAR)
        binding.pickerYear.minValue = 2001
        binding.pickerYear.maxValue = 2023
        binding.pickerYear.value = year
        binding.btnConfirm.setOnClickListener {
            listener!!.invoke(binding.pickerYear.value)
            dismiss()
        }
    }

    companion object {
        private const val MAX_YEAR = 2099
    }
}


//class MonthYearPickerDialog : DialogFragment() {
//    private var listener: ((Int) -> Unit)? = null
//    fun setListener(listener: ((Int) -> Unit)) {
//        this.listener = listener
//    }
//
//    @SuppressLint("ResourceAsColor")
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val builder: AlertDialog.Builder =
//            AlertDialog.Builder(activity, R.style.Theme_FutboolLegueApplication)
//        val cal: Calendar = Calendar.getInstance()
//        val dialog: View = LayoutInflater.from(requireContext())
//            .inflate(R.layout.dialog, null)
//        val yearPicker = dialog.findViewById(R.id.picker_year) as NumberPicker
//        val year: Int = cal.get(Calendar.YEAR)
//        yearPicker.minValue = 2001
//        yearPicker.maxValue = 2023
//        yearPicker.value = year
//        builder.setView(dialog)
//            .setPositiveButton(
//                Html.fromHtml("<font color='#FF4081'>Ok</font>")
//            ) { dialog, _ ->
//                 listener!!.invoke(yearPicker.value
//                 )
//            }.setNegativeButton(
//                Html.fromHtml("<font color='#FF4081'>Cancel</font>")
//            ) { dialog, _ ->
//                this@MonthYearPickerDialog.dialog!!.cancel()
//            }
//        return builder.create()
//    }
//
//    companion object {
//        private const val MAX_YEAR = 2099
//    }
//}