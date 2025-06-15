package pl.edu.pjatk.s25819.digitaldiary.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import pl.edu.pjatk.s25819.digitaldiary.databinding.FragmentCreateDiaryRecordBinding

class CreateDiaryRecordFragment : Fragment() {
    private var _binding: FragmentCreateDiaryRecordBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CreateDiaryRecordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateDiaryRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obsługa kliknięcia przycisku zapisu
        binding.btnSave.setOnClickListener {
            val title = binding.titleEditText.text.toString().trim()
            val content = binding.contentEditText.text.toString().trim()
            val location = binding.locationEditText.text.toString().trim()
            if (title.isEmpty() || content.isEmpty() || location.isEmpty()) {
                Toast.makeText(requireContext(), "Wypełnij wszystkie pola", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.create(title, content, location)
            }
        }

        viewModel.created.observe(viewLifecycleOwner, Observer { success ->
            if (success) {
                Toast.makeText(requireContext(), "Dodano wpis", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Błąd. Nie dodano wpisu.", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}