package com.example.moneywellspent.addexpense

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.afollestad.materialdialogs.datetime.timePicker
import com.example.moneywellspent.R
import com.example.moneywellspent.data.database.ExpenseDatabase
import com.example.moneywellspent.data.model.CategoryData
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.data.model.ExpenseCategory
import com.example.moneywellspent.data.model.categories
import com.example.moneywellspent.databinding.AddExpenseFragmentBinding
import timber.log.Timber
import java.util.*

const val CATEGORY_KEY = "category-key"

class AddExpenseFragment : Fragment() {
    private lateinit var viewModel: AddExpenseViewModel
    private lateinit var binding: AddExpenseFragmentBinding
    private lateinit var category: ExpenseCategory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = ExpenseCategory.OTHER;
        setFragmentResultListener(CATEGORY_KEY) { key, bundle ->
            if (bundle.getString(CATEGORY_KEY) != null)
                category =
                    ExpenseCategory.valueOf(bundle.getString(CATEGORY_KEY)!!)
            Timber.d("$category")
            viewModel.changeCategory(category)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_expense_fragment, container, false)
        binding.lifecycleOwner = this
        setupViewModel()
        setupViews()
        return binding.root
    }

    private fun setupViewModel() {
        val factory = AddExpenseViewModelFactory(ExpenseDatabase.getInstance(requireContext()).dao)
        viewModel = ViewModelProvider(this, factory).get(AddExpenseViewModel::class.java)
        viewModel.changeCategory(category)
    }

    private fun setupViews() {
        binding.viewModel = viewModel
        setupDatePicker()
        setupTimePicker()
        setupCategory()
        setupAddButton()
    }

    private fun setupAddButton() {
        binding.addExpense.setOnClickListener {
            val expense = Expense(
                null,
                binding.expenseAmount.text.toString().toDouble(),
                category,
                Date(viewModel.time.value ?: System.currentTimeMillis()),
                binding.expenseNote.text.toString(),
                0
            )
            viewModel.addExpense(expense)
            requireActivity().onBackPressed()
        }
    }


    private fun setupCategory() {
        binding.categorySelect.setOnClickListener {
            findNavController().navigate(R.id.action_addExpenseFragment_to_chooseCategoryFragment)

        }
    }

    private fun setupTimePicker() {
        binding.timeCard.setOnClickListener {
            MaterialDialog(requireContext()).show {
                timePicker { dialog, datetime ->
                    viewModel.changeTime(datetime.timeInMillis)
                }
            }
        }
    }

    private fun setupDatePicker() {
        binding.dateCard.setOnClickListener {
            MaterialDialog(requireContext()).show {
                datePicker { dialog, datetime ->
                    viewModel.changeDate(datetime.timeInMillis)
                }
            }
        }
    }


}