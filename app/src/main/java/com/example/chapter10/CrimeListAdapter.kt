package com.example.chapter10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter10.databinding.ListItemCrimeBinding

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_NORMAL = 0
        private const val VIEW_TYPE_POLICE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) VIEW_TYPE_POLICE else VIEW_TYPE_NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_POLICE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_crime_police, parent, false)
            PoliceCrimeViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_crime_normal, parent, false)
            NormalCrimeViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]
        when (holder) {
            is NormalCrimeViewHolder -> {
                holder.titleTextView.text = crime.title
                holder.dateTextView.text = crime.date.toString()
            }
            is PoliceCrimeViewHolder -> {
                holder.titleTextView.text = crime.title
                holder.dateTextView.text = crime.date.toString()
                holder.contactPoliceButton.setOnClickListener {
                    // Handle contact police button action
                }
            }
        }
    }

    override fun getItemCount(): Int = crimes.size

    // Define your ViewHolder classes here if not already defined
    inner class NormalCrimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.crime_title)
        val dateTextView: TextView = view.findViewById(R.id.crime_date)
    }

    inner class PoliceCrimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.crime_title)
        val dateTextView: TextView = view.findViewById(R.id.crime_date)
        val contactPoliceButton: Button = view.findViewById(R.id.contact_police_button)
    }
}