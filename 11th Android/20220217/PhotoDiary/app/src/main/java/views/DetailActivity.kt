package views

import android.content.Intent
import android.graphics.BitmapFactory
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hwangduil.photodiary.MainActivity
import com.hwangduil.photodiary.MapsFragment
import com.hwangduil.photodiary.R
import com.hwangduil.photodiary.databinding.ActivityDetailBinding
import dto.DataDto
import vo.DataVo

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<DataVo>("data")

        // 이미지 처리
        val bitmap = BitmapFactory.decodeFile(data?.filePath)
        binding.detailImageView.setImageBitmap(bitmap)

        // 텍스트뷰 처리
        binding.detailTitle.text = data?.title
        binding.detailContent.text = data?.content
        binding.detailDate.text = data?.reg

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val mapsFragment = MapsFragment(this)
        fragmentTransaction.add(R.id.mapArea, mapsFragment)

        val geocoder = Geocoder(this)

        val list:List<Address>? = geocoder.getFromLocationName(data?.location, 10)

        mapsFragment.setLocation(list!![0].latitude, list[0].longitude)

        binding.goToPreviewBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


}