package com.irem.yemekkitabi

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.irem.yemekkitabi.databinding.FragmentTarifBinding


class TarifFragment : Fragment() {
    private var _binding: FragmentTarifBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTarifBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView.setOnClickListener{gorselSec(it)}
        binding.kaydetButton.setOnClickListener { kaydet(it) }
        binding.silButton.setOnClickListener { sil(it) }

        arguments?.let {
            val bilgi = TarifFragmentArgs.fromBundle(it).bilgi

            if(bilgi =="yeni"){
                binding.silButton.isEnabled =false
                binding.kaydetButton.isEnabled=true
                binding.isimText.setText("")
                binding.malzemeText.setText("")
            }
            else{
                binding.silButton.isEnabled =true
                binding.kaydetButton.isEnabled=false
            }
        }
    }

    fun kaydet(view: View){

    }

    fun sil(view: View){

    }

    fun gorselSec(view: View){
        if (ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            //izin verilmemiş izin istenmesi gerek.
            if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
                //snackbar göstermemiz lazım, kullanıcıdan neden izin istediğimizi söylemeliyiz
                Snackbar.make(view,"Galeriye ulaşıp görsel seçilmeli.",Snackbar.LENGTH_INDEFINITE)
                    .setAction("İzin Ver",View.OnClickListener {
                        //izin istenecek

                    }).show()
            }
            else{
                //izin isteyeceğiz

            }
        }
        else{

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}