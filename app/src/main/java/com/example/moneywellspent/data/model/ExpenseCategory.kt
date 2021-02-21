package com.example.moneywellspent.data.model

import com.example.moneywellspent.R

enum class ExpenseCategory {
    TRANSFER, TRANSPORTATION, FOOD, ENTERTAINMENT, BILLS, EDUCATION, HEALTH, OTHER
}


data class CategoryData(val category: ExpenseCategory, val name: Int, val image: Int)

val categories: HashMap<ExpenseCategory, CategoryData> = hashMapOf(
    ExpenseCategory.TRANSPORTATION to CategoryData(
        ExpenseCategory.TRANSFER,
        R.string.category_transfer,
        R.drawable.ic_transfer
    ),
    ExpenseCategory.TRANSPORTATION to CategoryData(
        ExpenseCategory.TRANSPORTATION,
        R.string.category_transportation,
        R.drawable.ic_transportation
    ),
    ExpenseCategory.FOOD to CategoryData(
        ExpenseCategory.FOOD,
        R.string.category_food,
        R.drawable.ic_food
    ),
    ExpenseCategory.ENTERTAINMENT to CategoryData(
        ExpenseCategory.ENTERTAINMENT,
        R.string.category_entertainment,
        R.drawable.ic_entertainment
    ),
    ExpenseCategory.BILLS to CategoryData(
        ExpenseCategory.BILLS,
        R.string.category_bills,
        R.drawable.ic_fees
    ),
    ExpenseCategory.EDUCATION to CategoryData(
        ExpenseCategory.EDUCATION,
        R.string.category_education,
        R.drawable.ic_education
    ),
    ExpenseCategory.HEALTH to CategoryData(
        ExpenseCategory.HEALTH,
        R.string.category_health,
        R.drawable.ic_health
    ),
    ExpenseCategory.OTHER to CategoryData(
        ExpenseCategory.OTHER,
        R.string.category_other,
        R.drawable.ic_other
    ),
)