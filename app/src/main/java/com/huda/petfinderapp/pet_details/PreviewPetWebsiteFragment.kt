package com.huda.petfinderapp.pet_details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.huda.petfinderapp.R
import com.huda.petfinderapp.databinding.FragmentPreviewPetWebsiteBinding

class PreviewPetWebsiteFragment : Fragment() {
    private var _binding:FragmentPreviewPetWebsiteBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentPreviewPetWebsiteBinding.inflate(inflater, container, false)
        loadWebView()
        return binding.root
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView() {
        val bundle = arguments?:return
        val args = PreviewPetWebsiteFragmentArgs.fromBundle(bundle)
        binding.webview.settings.javaScriptEnabled = true

        binding.webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressbar.visibility = View.GONE
            }
        }
        binding.webview.loadUrl(args.url)
    }
}