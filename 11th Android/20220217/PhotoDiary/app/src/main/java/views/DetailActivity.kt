package views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hwangduil.photodiary.MainActivity
import com.hwangduil.photodiary.R
import com.hwangduil.photodiary.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail)

        binding.detailImageView
        binding.detailTitle
        binding.detailContent
        binding.detailDate
        binding.detailLocation
        binding.mapArea
        binding.goToPreviewBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun getImage(imagePath:String?) {}
}