package com.finerioconnect.pfm.example.ui.budgets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.requests.FCCreateBudgetRequest
import com.finerioconnect.pfm.example.databinding.FragmentBudgetsExampleBinding
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.CreateBudgetListener
import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK.Companion.shared
import com.finerioconnect.sdk.budget.core.Palette
import com.finerioconnect.sdk.models.FCBudget
import com.finerioconnect.sdk.models.FCCategory

private const val CATEGORY_KEY = "categoryKey"

class BudgetsExampleFragment : Fragment() {
    private lateinit var mBinding: FragmentBudgetsExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentBudgetsExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        val category = arguments?.getParcelable<FCCategory>(CATEGORY_KEY)

        val finerioBudgetSDK = shared

        val palette = Palette()
        finerioBudgetSDK.palette = palette

        mBinding.budgetInputView.setBudgets(category, null)
        mBinding.addBudgetButton.setOnClickListener {
            val budget: FCBudget? = mBinding.budgetInputView.getBudgetEdited()
            createBudget(budget)
        }
    }

    private fun createBudget(budget: FCBudget?) {
        if (budget != null) {
            val budgetParse = budget.toFCCoreBudget()

            if (budgetParse != null) {
                FinerioApi().budgets().create(
                    budgetParse,
                    object : CreateBudgetListener {
                        override fun budgetCreated(budget: com.finerioconnect.core.sdk.models.FCBudget) {
                            val budgetText = budget.name + ": " + budget.id
                            Toast.makeText(
                                requireActivity(),
                                budgetText,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        override fun error(errors: List<FCError>) {
                            if (!errors.isEmpty()) {
                                val (title, code, detail) = errors[0]
                                Toast.makeText(
                                    requireActivity(),
                                    title,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun severError(serverError: Throwable) {
                            Toast.makeText(
                                requireActivity(),
                                "Error de servidor!: " + serverError.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            }
        }
    }

    private fun FCBudget.toFCCoreBudget() = amount?.let {
        FCCreateBudgetRequest(
            userId = 371720,
            name = name,
            categoryId = 1,
            amount = it.toDouble(),
            warningPercentage = 0.7
        )
    }
}