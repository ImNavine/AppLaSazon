package pe.edu.idat.applasazon.ui.gallery

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.applasazon.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnGM.setOnClickListener{
            val googlemapito = Intent(Intent.ACTION_VIEW)
            googlemapito.data = Uri.parse("https://www.google.com/maps/place/Mall+del+Sur/@-12.156078,-76.9820325,3a,75y,52.69h,90t/data=!3m6!1e1!3m4!1sQ316ANymSsgeWniwmbiS7w!2e0!7i16384!8i8192!4m14!1m7!3m6!1s0x9105b84113003ee7:0x1fd71e1502ba8da6!2sMall+del+Sur!8m2!3d-12.1550691!4d-76.9822496!16s%2Fg%2F11bz09rstr!3m5!1s0x9105b84113003ee7:0x1fd71e1502ba8da6!8m2!3d-12.1550691!4d-76.9822496!16s%2Fg%2F11bz09rstr?entry=ttu")
            startActivity(googlemapito)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}