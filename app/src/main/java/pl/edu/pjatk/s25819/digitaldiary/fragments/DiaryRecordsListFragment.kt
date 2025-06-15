package pl.edu.pjatk.s25819.digitaldiary.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.adapters.DiaryAdapter
import pl.edu.pjatk.s25819.digitaldiary.databinding.FragmentDiaryRecordsListBinding
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord
import kotlin.io.resolve

class DiaryRecordsListFragment : Fragment() {

    private var _binding: FragmentDiaryRecordsListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DiaryRecordsListViewModel by viewModels()
    private lateinit var diaryAdapter: DiaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiaryRecordsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupListeners()
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.diaryRecords.observe(viewLifecycleOwner) { list ->
            diaryAdapter.submitList(list)
        }

        viewModel.navigation.observe(viewLifecycleOwner) {
            it.resolve(findNavController())
        }
    }

    private fun setupListeners() {
        binding.addNewDiaryRecordButton.setOnClickListener {
            viewModel.navigateToCreate()
        }
    }

    private fun setupRecyclerView() {
        diaryAdapter = DiaryAdapter(
            onCardClick = { handleCardClick(it) }
        )

        binding.diaryRecordsListRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = diaryAdapter
        }
    }

    private fun handleCardClick(diaryRecord: DiaryRecord) {
        viewModel.navigateToEdit(diaryRecord)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        findNavController().addOnDestinationChangedListener(viewModel::onDestinationChanged)
    }

    override fun onStop() {
        findNavController().removeOnDestinationChangedListener(viewModel::onDestinationChanged)
        super.onStop()
    }

    companion object {
        private const val TAG = "DiaryRecordsListFragment"
    }
}