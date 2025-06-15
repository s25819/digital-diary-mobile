package pl.edu.pjatk.s25819.digitaldiary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord

class DiaryAdapter(
    private var items: List<DiaryRecord> = emptyList()
) : RecyclerView.Adapter<DiaryAdapter.ViewHolder>() {

    fun submitList(newItems: List<DiaryRecord>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.diary_record_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.diaryRecordTitleLabel)
        private val content: TextView = view.findViewById(R.id.contentEditText)
        private val location: TextView = view.findViewById(R.id.locationLabel)

        fun bind(item: DiaryRecord) {
            title.text = item.title
            content.text = item.content
            location.text = item.location
        }
    }
}