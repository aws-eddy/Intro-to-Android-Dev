package cc.captaincode.recyclerviewdemo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import cc.captaincode.recyclerviewdemo.data.Building
import kotlinx.android.synthetic.main.building_dialog.view.*

class NewBuildingDialog : DialogFragment(){

    interface NewBuildingHandler{
        fun newBuilding(building:Building)
        fun removeBuilding(building:Building)
    }

    lateinit var  buildingHandler:NewBuildingHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is NewBuildingHandler) {
            buildingHandler = context
        }else{
            throw RuntimeException(
                "Activity does not implment the New Building Handler"
            )
        }
    }

    lateinit var etBuildingName: EditText
    lateinit var etBuildingCapacity: EditText
    lateinit var etBuildingYear:EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        val dialogView = requireActivity().layoutInflater.inflate(
            R.layout.building_dialog, null
        )
        etBuildingName = dialogView.etBuildingName
        etBuildingCapacity = dialogView.etRoomCapacity
        etBuildingYear = dialogView.etBuildingYear

        dialogBuilder.setView(dialogView)

        dialogBuilder.setNegativeButton("Cancel") {
                dialog, which ->
        }
        dialogBuilder.setPositiveButton("Add") {
                dialog, which ->

            var newBuilding = Building(
                etBuildingName.text.toString(),
                etBuildingCapacity.text.toString().toInt(),
                etBuildingYear.text.toString().toInt()
            )

            buildingHandler.newBuilding(newBuilding)
        }

        return dialogBuilder.create()
    }

}