package pe.edu.idat.applasazon.ui.slideshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.applasazon.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnK.setOnClickListener{
            val wspKevin = Intent(Intent.ACTION_VIEW)
            wspKevin.data = Uri.parse("https://wa.me/51993424216?text=Te%20Hablo%20Desde%20Tu%20App")
            startActivity(wspKevin)
        }
        binding.btnD.setOnClickListener{
            val wspDominic = Intent(Intent.ACTION_VIEW)
            wspDominic.data = Uri.parse("https://wa.me/51972083816?text=Te%20Hablo%20Desde%20Tu%20App")
            startActivity(wspDominic)
        }
        binding.btnR.setOnClickListener{
            val wspRios= Intent(Intent.ACTION_VIEW)
            wspRios.data = Uri.parse("https://wa.me/51955550491?text=Te%20Hablo%20Desde%20Tu%20App")
            startActivity(wspRios)
        }
        binding.btnemail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:florireyes150@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hola te quiero contactar")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Te hablo desde el boton de tu aplicacion")
            startActivity(emailIntent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}