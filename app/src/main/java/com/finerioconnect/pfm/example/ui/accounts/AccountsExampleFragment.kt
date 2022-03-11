package com.finerioconnect.pfm.example.ui.accounts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.example.databinding.FragmentAccountsExampleBinding
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.GetAccountsListener
import com.finerioconnect.sdk.models.FCAccountBalance
import com.finerioconnect.sdk.models.FCCredential
import com.finerioconnect.sdk.shared.enums.FCCredentialStatus

class AccountsExampleFragment : Fragment() {

    private lateinit var mBinding: FragmentAccountsExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAccountsExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAccounts()
    }

    private fun getAccounts() {
        FinerioApi().accounts().getAll(371720, 0, object : GetAccountsListener {
            override fun accounts(accounts: List<FCAccount>, nextCursor: Int) {
                showAccounts(accounts)
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

    private fun showAccounts(accounts: List<FCAccount>) {
        mBinding.accountBalanceView.visibility = View.VISIBLE

        val credentials = mutableListOf<FCCredential>()
        val accountsParse = mutableListOf<com.finerioconnect.sdk.models.FCAccount>()
        for (account in accounts) {
            accountsParse.add(account.toFCAccountUI())
            val credential = FCCredential(
                id = account.id.toString(),
                name = account.name,
                balance = account.balance,
                user = "Usuario",
                status = FCCredentialStatus.ACTIVE,
                institutionCode = account.name,
                image = null,
                accounts = accountsParse
            )
            credentials.add(credential)
        }

        val balance = FCAccountBalance(
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            credentials
        )

        mBinding.accountBalanceView.setAccountBalance(balance)
    }

    private fun FCAccount.toFCAccountUI() = com.finerioconnect.sdk.models.FCAccount(
        id = id.toString(),
        type = nature,
        name = name,
        bank = null,
        balance = balance,
    )
}