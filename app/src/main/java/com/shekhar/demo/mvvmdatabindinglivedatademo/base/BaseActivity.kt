package com.shekhar.demo.mvvmdatabindinglivedatademo.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    var mViewDataBinding: T? = null
    protected lateinit var mViewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeViewBinding()
        init()
        mViewModel.getMessage().observe(this, messageObserver)
    }

    private fun initializeViewBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.mViewModel = if (!::mViewModel.isInitialized) getViewModel() else mViewModel
        mViewDataBinding!!.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding!!.executePendingBindings()
    }

    /**
     * To handle error
     */
    protected val messageObserver: Observer<String> = Observer<String> { t ->
        showToast(t.toString())
    }

    fun showToast(message: String?, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    abstract fun init()

    abstract fun getLayoutId(): Int

}