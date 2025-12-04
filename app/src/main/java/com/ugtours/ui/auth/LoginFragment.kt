package com.ugtours.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ugtours.MainActivity
import com.ugtours.R
import com.ugtours.data.UserManager
import com.ugtours.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Check if user is already logged in
        if (UserManager.isLoggedIn(requireContext())) {
            navigateToHome()
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (UserManager.loginUser(requireContext(), email, password)) {
                navigateToHome()
            } else {
                Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.registerTextView.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }

    private fun navigateToHome() {
        // Since MainActivity hosts the nav graph, we are already in it. 
        // But if we want to "enter" the main app flow, we navigate to the home fragment.
        // However, if Login is the start destination, we just navigate to Home.
        // If we want to clear the back stack so user can't go back to login:
        findNavController().navigate(R.id.action_login_to_home)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
