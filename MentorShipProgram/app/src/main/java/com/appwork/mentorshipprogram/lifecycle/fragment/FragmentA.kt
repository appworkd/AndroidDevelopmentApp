package com.appwork.mentorshipprogram.lifecycle.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appwork.mentorshipprogram.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var fragmentABinding: FragmentABinding

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    companion object {
        const val ARG_PARAM1 = "param1"
        const val ARG_PARAM2 = "param2"
        const val TAG = "A Fragment"
    }


    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    public fun FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public fun newInstance(param1: String?, param2: String?): FragmentA? {
        val fragment = com.appwork.mentorshipprogram.lifecycle.fragment.FragmentA()
        val args = Bundle()
        args.putString(ARG_PARAM1, param1)
        args.putString(ARG_PARAM2, param2)
        fragment.arguments = args
        return fragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
        Log.e(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentABinding = FragmentABinding.inflate(inflater, container, false)
        Log.e(TAG, "onCreateView: ")
        return fragmentABinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentABinding.tvA.text = mParam1 + " " + mParam2
        Log.e(TAG, "onViewCreated: ")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG, "onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "onDetach: ")
    }
}