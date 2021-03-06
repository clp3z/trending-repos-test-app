package com.clp3z.xapotestapp.base.generic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.clp3z.xapotestapp.base.interfaces.ViewMethods

/**
 * Created by Clelia López on 02/26/21
 */
abstract class GenericView<B: ViewDataBinding, VM: ViewModel> (
    protected val layoutInflater: LayoutInflater,
    protected val container: ViewGroup?,
    protected val viewModel: VM,
    protected val fragment: Fragment
):
    ViewMethods {

    protected lateinit var binding: B

    val root: View get() = binding.root

    init {
        this.initialize()
    }
}