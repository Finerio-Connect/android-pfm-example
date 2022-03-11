package com.finerioconnect.pfm.example.ui.budgets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.example.R
import com.finerioconnect.pfm.example.databinding.FragmentBudgetsCategoriesExampleBinding
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK.Companion.shared
import com.finerioconnect.sdk.budget.core.Palette
import com.finerioconnect.sdk.models.FCCategory
import com.finerioconnect.sdk.shared.enums.FCCategoryType
import com.finerioconnect.sdk.ui.listeners.OnFCCategoryListener

private const val CATEGORY_KEY = "categoryKey"

class BudgetsCategoriesExampleFragment : Fragment() {
    private lateinit var mBinding: FragmentBudgetsCategoriesExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentBudgetsCategoriesExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val finerioBudgetSDK = shared

        val palette = Palette()
        finerioBudgetSDK.palette = palette

        FinerioApi().categories().getAll(371720, 0, object : GetCategoriesListener {
            override fun categories(
                categories: List<com.finerioconnect.core.sdk.models.FCCategory>,
                nextCursor: Int
            ) {
                showCategories(categories)
            }

            override fun error(errors: List<FCError>) {
                if (!errors.isEmpty()) {
                    val (_, _, detail) = errors[0]
                    Log.e("ERROR", detail)
                }
            }

            override fun severError(serverError: Throwable) {
                Log.e("ERROR", serverError.message.toString())
            }
        })
    }

    private fun showCategories(categories: List<com.finerioconnect.core.sdk.models.FCCategory>) {
        val categoriesParse = mutableListOf<FCCategory>()

        for (category in categories) {
            val categoryParse = category.toFCCategoryUI()
            if (categoryParse != null) {
                categoriesParse.add(categoryParse)
            }
        }

        mBinding.categoryView.setUpView(
            categoriesParse,
            FCCategoryType.SHOW_ALL_ONLY_ONE_CATEGORY,
            null
        )
        mBinding.categoryView.setListener(object : OnFCCategoryListener {
            override fun didSelectedCategory(category: FCCategory?) {
                val bundle = Bundle()
                bundle.putParcelable(CATEGORY_KEY, category)

                val fragment = BudgetsExampleFragment()
                fragment.arguments = bundle
                val fragmentTransaction =
                    requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragmentContainer, fragment)
                    .commitAllowingStateLoss()
            }
        })
    }

    private fun com.finerioconnect.core.sdk.models.FCCategory.toFCCategoryUI() = color?.let {
        FCCategory(
            id = id.toString(),
            name = name,
            backgroundColor = it,
            textColor = "#111111",
            image = null,
            parentCategory = null,
            subCategories = mutableListOf<FCCategory>(),
            parentId = parentCategoryId.toString()
        )
    }
}