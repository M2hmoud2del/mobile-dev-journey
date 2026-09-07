package com.excercise.emergencyapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ExitDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setIcon(android.R.drawable.ic_menu_close_clear_cancel)?.setTitle("Exit?")
            ?.setMessage("Do You want to exit?")
            ?.setPositiveButton("Yes"){ _, _ -> activity?.finish() }
            ?.setNegativeButton("No"){ _, _ -> dialog?.dismiss()}
        return builder!!.create()
    }
}