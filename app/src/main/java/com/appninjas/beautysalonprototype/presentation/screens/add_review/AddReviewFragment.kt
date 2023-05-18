package com.appninjas.beautysalonprototype.presentation.screens.add_review

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.appninjas.beautysalonprototype.R
import com.appninjas.beautysalonprototype.databinding.FragmentAddReviewBinding
import com.appninjas.beautysalonprototype.presentation.utils.Toast
import com.appninjas.domain.model.Review
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class AddReviewFragment : Fragment() {

    private lateinit var binding: FragmentAddReviewBinding
    private val viewModel by viewModels<AddReviewViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        binding.navigateBackButton.setOnClickListener {
            findNavController().navigate(R.id.reviewFragment)
        }

        binding.addReviewTextEditText.setOnKeyListener { _, _, _ ->
            Log.d("KEY", "Key pressed")
            val symbolsLeft = 450 - binding.addReviewTextEditText.text.toString().length
            binding.symbolsRemain.text = "Осталось символов: $symbolsLeft"
            true
        }

        binding.addReviewTextEditText.addTextChangedListener(textWatcher)

        binding.addReviewButton.setOnClickListener {
            if (validateFields()) {
                val calendarInstance = Calendar.getInstance().time
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(calendarInstance)
                viewModel.addReview(Review(
                    reviewerName = binding.nameAddReview.text.toString(),
                    reviewRate = binding.addReviewRatingBar.rating,
                    reviewDate = formattedDate,
                    reviewText = binding.addReviewTextEditText.text.toString()
                ))
                Toast.showToast(requireContext(), "Отзыв добавлен!")
                findNavController().navigate(R.id.reviewFragment)
            }
        }
    }

    private val textWatcher = object : TextWatcher {

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Log.d("KEY", "Key pressed $start, $before, $count")
            val symbolsLeft = 300 - binding.addReviewTextEditText.text.toString().length
            binding.symbolsRemain.text = "Осталось символов: $symbolsLeft"
            true
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            Log.d("KEY", "Before text changed caught")
        }

        override fun afterTextChanged(p0: Editable?) {
            Log.d("KEY", "After text changed caught")
        }

    }

    private fun validateFields(): Boolean = if (binding.addReviewTextEditText.text.toString().isEmpty() || binding.nameAddReview.text.toString().isEmpty()) {
        Toast.showToast(requireContext(), "Заполните все поля")
        false
    } else if (binding.addReviewRatingBar.rating == 0.0f) {
        Toast.showToast(requireContext(), "Поставьте оценку салону")
        false
    } else {
        true
    }

}