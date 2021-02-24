package com.example.moneywellspent.wallet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneywellspent.data.database.ExpenseDatabase
import com.example.moneywellspent.databinding.WalletFragmentBinding
import com.example.moneywellspent.expenses.ExpensesViewModelFactory

class WalletFragment : Fragment() {

    private lateinit var viewModel: WalletViewModel
    private lateinit var adapter: WalletsAdapter
    private lateinit var binding: WalletFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WalletFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        setupViewModel()
        setupAdapter()
        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        viewModel.wallets.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun setupViewModel() {
        val factory = WalletViewModelFactory(ExpenseDatabase.getInstance(requireContext()).dao)
        viewModel = ViewModelProvider(this, factory).get(WalletViewModel::class.java)

    }

    private fun setupAdapter() {
        adapter = WalletsAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.walletsList.layoutManager = layoutManager
        binding.walletsList.adapter = adapter
    }


}