package pl.edu.pjatk.s25819.digitaldiary.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.adapters.DiaryAdapter
import pl.edu.pjatk.s25819.digitaldiary.databinding.FragmentDiaryRecordsListBinding

class DiaryRecordsListFragment : Fragment() {

    private var _binding: FragmentDiaryRecordsListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DiaryRecordsListViewModel by viewModels()
    private lateinit var adapter: DiaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiaryRecordsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.diaryRecordsListRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = DiaryAdapter()
        recyclerView.adapter = adapter

        viewModel.diaryRecords.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = DiaryRecordsListFragment()
    }
}