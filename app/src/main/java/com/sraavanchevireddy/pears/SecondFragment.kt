package com.sraavanchevireddy.pears

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sraavanchevireddy.pears.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var poems: ArrayList<String> = ArrayList()
    lateinit var  recyclerView: RecyclerView
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            val intent = Intent(activity, VideoViewActivity::class.java)
            startActivity(intent)
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        recyclerView = view.findViewById(R.id.textview_second)
        addPoems()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addPoems() {
        poems.add("AntAndDove.mp4")
        val poems= PoemsAdapter(poems)
        recyclerView.adapter = poems
        poems.onItemClick = {
            val intent = Intent(activity, VideoViewActivity::class.java)
            startActivity(intent)
        }
    }

}