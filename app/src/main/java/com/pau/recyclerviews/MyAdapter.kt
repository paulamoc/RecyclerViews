package com.pau.recyclerviews


import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private var oldPersonList = emptyList<Person>()

    class MyViewHolder(val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.binding.nameTextView.text = oldPersonList[position].name
        holder.binding.ageTextView.text = oldPersonList[position].age.toString()
    }

    override fun getItemCount(): Int {
      return oldPersonList.size
    }

    fun setData(newPersonList: List<Person>){
        val diffUtil = MyDiffUtil(oldPersonList, newPersonList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldPersonList = newPersonList
        diffResult.dispatchUpdatesTo(this)
    }
}




}
