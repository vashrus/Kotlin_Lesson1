package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapters.FirstAdapter
import com.example.myapplication.Net.MyInterface
import com.example.myapplication.Net.MyRetrofit
import com.example.myapplication.Net.feeling
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.feel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        val data = listOf(
//            feel("Реклама_1",R.drawable.reklama),
//            feel("Реклама_2",R.drawable.reklama),
//            feel("Реклама_3",R.drawable.reklama),
//            feel("Реклама_4",R.drawable.reklama),
//            feel("Реклама_5",R.drawable.reklama),
//            feel("Реклама_6",R.drawable.reklama),
//            feel("Реклама_7",R.drawable.reklama),
//            feel("Реклама_8",R.drawable.reklama),
//            feel("Реклама_9",R.drawable.reklama),
//            feel("Реклама_10",R.drawable.reklama),
//        )
        val ret = MyRetrofit().getRetrofit()
        val recyclerView:RecyclerView = root.findViewById(R.id.first_recycle)
        val inter = ret.create(MyInterface::class.java)
        val call = inter.getFeelings().enqueue(object :retrofit2.Callback<feeling>{
            override fun onResponse(call: Call<feeling>, response: Response<feeling>) {
                recyclerView.adapter = FirstAdapter(requireContext(),response.body()!!)
            }

            override fun onFailure(call: Call<feeling>, t: Throwable) {
                Toast.makeText(requireContext(),t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
//        recyclerView.adapter = FirstAdapter(requireContext(),data)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}