package pl.edu.pjatk.s25819.digitaldiary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.databinding.DiaryRecordLayoutBinding
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord

class DiaryAdapter(
    private var items: List<DiaryRecord> = emptyList(),
    private val onCardClick: (DiaryRecord) -> Unit
) : RecyclerView.Adapter<DiaryAdapter.ViewHolder>() {

    fun submitList(newItems: List<DiaryRecord>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DiaryRecordLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], onCardClick)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: DiaryRecordLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: DiaryRecord,
            onCardClick: (DiaryRecord) -> Unit
        ): Unit = with(binding) {

            diaryRecordTitleLabel.text = item.title
            contentEditText.setText(item.content)
            locationEditText.setText(item.location)

            root.setOnClickListener {
                onCardClick(item)
            }
        }
    }
}