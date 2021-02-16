package com.example.moneywellspent.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneywellspent.R
import com.example.moneywellspent.data.database.ExpenseDatabase
import com.example.moneywellspent.data.model.Expense
import com.example.moneywellspent.databinding.ExpensesFragmentBinding

class ExpensesFragment : Fragment() {

    private lateinit var adapter: ExpensesAdapter
    private lateinit var binding: ExpensesFragmentBinding
    private lateinit var viewModel: ExpensesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.expenses_fragment, container, false)
        binding.lifecycleOwner = this
        setupViewModel()
        setupAdapter()
        setupObservers()
        return binding.root
    }

    private fun setupViewModel() {
        val factory = ExpensesViewModelFactory(ExpenseDatabase.getInstance(requireContext()).dao)
        viewModel = ViewModelProvider(this, factory).get(ExpensesViewModel::class.java)

    }

    private fun setupAdapter() {
        adapter = ExpensesAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.expenseList.layoutManager = layoutManager
        binding.expenseList.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.expenses.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }


}