package com.tispunshahryar960103.onlineshop.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.onlineshop.R
import com.tispunshahryar960103.onlineshop.databinding.FragmentDetailsBinding
import com.tispunshahryar960103.onlineshop.model.Post
import com.tispunshahryar960103.onlineshop.viewModel.ViewModel_fragment_Details
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(requireActivity()),
            R.layout.fragment_details,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Log.e("TAG", "onViewCreated: "+ (arguments?.get("idPost") ?: "myMessage"))

        val viewModel =
            ViewModelProvider(requireActivity()).get(ViewModel_fragment_Details::class.java)

        viewModel.listPost(arguments?.getString("idPost")!!)

        viewModel.mutableLiveData.observe(requireActivity(), Observer {

            val post = Post(
                it.post[0].date,
                it.post[0].des,
                it.post[0].id,
                it.post[0].imageurl,
                it.post[0].price,
                it.post[0].title,
                it.post[0].view
            )

            binding.postDetails = post

            btn_addCart.text = "افزودن به سبد خرید  " + post.price + "  تومان "
            btn_addCart.setOnClickListener{




            }



        })


    }


}