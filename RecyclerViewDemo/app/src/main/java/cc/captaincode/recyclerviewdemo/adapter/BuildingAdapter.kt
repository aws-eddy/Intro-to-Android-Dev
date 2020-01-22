package cc.captaincode.recyclerviewdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import cc.captaincode.recyclerviewdemo.R
import cc.captaincode.recyclerviewdemo.data.Building
import kotlinx.android.synthetic.main.building_row.view.*

class BuildingAdapter : RecyclerView.Adapter<BuildingAdapter.ViewHolder>{

    private var buildings = mutableListOf<Building>()

    private val context:Context

    constructor(context: Context) :super() {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val buildingView = LayoutInflater.from(context).inflate(
            R.layout.building_row, parent, false
        )
        return ViewHolder(buildingView)
    }

    override fun getItemCount(): Int {
        return buildings.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val building = buildings[position]

        holder.buildingName.text = building.name
        holder.yearBuilt.append(building.yearBuilt.toString())
        holder.capacity.append(building.capacity.toString() + " rooms")
        holder.btnDelete.setOnClickListener {
            deleteBuilding(position)
        }
    }


    private fun deleteBuilding(position: Int){
        buildings.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addBuilding(newBuilding:Building){
        buildings.add(newBuilding)
        notifyItemInserted(buildings.lastIndex)
    }

    inner class ViewHolder (buildingRow: View):RecyclerView.ViewHolder(buildingRow){
        val buildingName = itemView.tvBuildingName
        val yearBuilt = itemView.tvYearBuilt
        val capacity = itemView.tvCapacity
        val btnDelete = itemView.btnDelete

    }

}