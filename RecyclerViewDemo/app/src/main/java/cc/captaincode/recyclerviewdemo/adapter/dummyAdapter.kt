package cc.captaincode.recyclerviewdemo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cc.captaincode.recyclerviewdemo.data.Building

class DummyAdapter:RecyclerView.Adapter<DummyAdapter.DummyViewHolder>{

    private val context:Context
    private var buildings = mutableListOf<Building>()

    constructor(context: Context) :super() {
        this.context = context
    }

    inner class DummyViewHolder(dummyRow: View):RecyclerView.ViewHolder(dummyRow){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return buildings.size
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}