package com.example.moneywellspent.choosecategory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneywellspent.R
import com.example.moneywellspent.addexpense.CATEGORY_KEY
import com.example.moneywellspent.data.model.categories
import com.example.moneywellspent.databinding.FragmentChooseCategoryBinding


class ChooseCategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentChooseCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_choose_category, container, false)
        val adapter = CategoryAdapter(OnItemClickListener {
            setFragmentResult(CATEGORY_KEY, bundleOf(CATEGORY_KEY to it.category.name))
            findNavController().navigateUp()
        })
        adapter.submitList(categories.values.toList())
        val layoutManager = LinearLayoutManager(requireContext())
        binding.categoryList.layoutManager = layoutManager
        binding.categoryList.adapter = adapter
        return binding.root

    }


}