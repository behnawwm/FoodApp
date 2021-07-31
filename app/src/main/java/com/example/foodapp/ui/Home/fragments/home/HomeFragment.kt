package com.example.foodapp.ui.Home.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.databinding.ItemCustomFixedSizeLayout1Binding
import com.example.foodapp.databinding.ItemCustomFixedSizeLayout2Binding
import com.google.android.material.bottomappbar.BottomAppBar
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import kotlin.random.Random
import com.example.foodapp.data.TestDataSet
import com.example.foodapp.data.models.OfferItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage


class HomeFragment : Fragment(R.layout.fragment_home), RecentItemsAdapter.OnItemPressListener {
    lateinit var binding: FragmentHomeBinding
    private val MAP_BUTTON_REQUEST_CODE = 123

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        requireActivity().findViewById<BottomAppBar>(R.id.bottom_appbar).performShow()


        ////////  Carousel 1
        binding.imageCarousel1.registerLifecycle(lifecycle)
        binding.imageCarousel1.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return ItemCustomFixedSizeLayout1Binding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            }

            override fun onBindViewHolder(
                binding: ViewBinding,
                item: CarouselItem,
                position: Int
            ) {
                val currentBinding = binding as ItemCustomFixedSizeLayout1Binding

                currentBinding.tvTitle.text = item.caption ?: ""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
            }
        }
        val listCarousel1 = mutableListOf<CarouselItem>()
        val carousel1DataSet = listOf(
            R.drawable.photo_hamburger to "Smokin' Burger",
            R.drawable.photo_cappuccino to "Beef Masala Curry",
            R.drawable.photo_donuts to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_pizza to "Cheese Sandwich",
            R.drawable.photo_pancakes to "Ice Cream",
        )
        for (item in carousel1DataSet) {
            listCarousel1.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel1.setData(listCarousel1)


        ////////  Carousel 2
        binding.imageCarousel2.registerLifecycle(lifecycle)
        binding.imageCarousel2.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return ItemCustomFixedSizeLayout2Binding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            }

            override fun onBindViewHolder(
                binding: ViewBinding,
                item: CarouselItem,
                position: Int
            ) {
                val currentBinding = binding as ItemCustomFixedSizeLayout2Binding

                currentBinding.tvTitle.text = item.caption ?: ""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
                currentBinding.tvRating.text =
                    "%.1f".format(Random.nextDouble(2.0, 5.0))
            }
        }
        val listCarousel2 = mutableListOf<CarouselItem>()
        val carousel2DataSet = listOf(
            R.drawable.photo_hamburger to "Smokin' Burger",
            R.drawable.photo_cappuccino to "Beef Masala Curry",
            R.drawable.photo_donuts to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_pizza to "Cheese Sandwich",
            R.drawable.photo_pancakes to "Ice Cream",
        )
        for (item in carousel2DataSet) {
            listCarousel2.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel2.setData(listCarousel2)


        //////  Image Carousel 3
        binding.imageCarousel3.registerLifecycle(lifecycle)
        binding.imageCarousel3.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return ItemCustomFixedSizeLayout2Binding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            }

            override fun onBindViewHolder(
                binding: ViewBinding,
                item: CarouselItem,
                position: Int
            ) {
                val currentBinding = binding as ItemCustomFixedSizeLayout2Binding

                currentBinding.tvTitle.text = item.caption ?: ""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
                currentBinding.tvRating.text =
                    "%.1f".format(Random.nextDouble(2.0, 5.0))
            }
        }
        val listCarousel3 = mutableListOf<CarouselItem>()
        val carousel3DataSet = listOf(
            R.drawable.photo_mozzarella_sticks to "Smokin' Burger",
            R.drawable.photo_nachos to "Beef Masala Curry",
            R.drawable.photo_soda to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_waffles to "Cheese Sandwich",
            R.drawable.photo_pizza to "Ice Cream",
        )
        for (item in carousel3DataSet) {
            listCarousel3.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel3.setData(listCarousel3)


        ////// Recycler view Recent

        val recentAdapter = RecentItemsAdapter(this).apply {
            submitList(TestDataSet.provideOffersTestDataSet().take(3))
        }
        binding.apply {
            rvRecentHome.setHasFixedSize(true)
            rvRecentHome.adapter = recentAdapter
            rvRecentHome.addItemDecoration(initRecyclerDivider())

            rvRecentHome.setOnClickListener {
                recentAdapter.submitList(
                    TestDataSet.provideOffersTestDataSet()
                )
                binding.rvRecentHome.adapter = recentAdapter
            }
        }

        ////// location picker
//        binding.rlLocationSelectHome.setOnClickListener {
//            val locationPickerIntent = LocationPickerActivity.Builder()
//                .withLocation(41.4036299, 2.1743558)
//                .withGeolocApiKey("<PUT API KEY HERE>")
//                .withSearchZone("es_ES")
//                .withSearchZone(
//                    SearchZoneRect(
//                        LatLng(26.525467, -18.910366),
//                        LatLng(43.906271, 5.394197)
//                    )
//                )
//                .withDefaultLocaleSearchZone()
//                .shouldReturnOkOnBackPressed()
//                .withStreetHidden()
//                .withCityHidden()
//                .withZipCodeHidden()
//                .withSatelliteViewHidden()
////                .withGooglePlacesApiKey("<PUT API KEY HERE>")
////                .withGooglePlacesEnabled()
//                .withGoogleTimeZoneEnabled()
//                .withVoiceSearchHidden()
//                .withUnnamedRoadHidden()
//                .build(requireContext())
//
//            startActivityForResult(locationPickerIntent, MAP_BUTTON_REQUEST_CODE)
//        }


        ///


        return binding.root
    }

    override fun OnItemClick(item: OfferItem) {
        TODO("Not yet implemented")
    }

    private fun initRecyclerDivider(): RecyclerView.ItemDecoration {
        val divider = DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        )
        divider.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.shape_divider_10dp
            )!!
        )
        return divider
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (resultCode == Activity.RESULT_OK && data != null) {
//            Log.d("RESULT****", "OK")
//            if (requestCode == 1) {
//                val latitude = data.getDoubleExtra(LATITUDE, 0.0)
//                Log.d("LATITUDE****", latitude.toString())
//                val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
//                Log.d("LONGITUDE****", longitude.toString())
//                val address = data.getStringExtra(LOCATION_ADDRESS)
//                Log.d("ADDRESS****", address.toString())
//                val postalcode = data.getStringExtra(ZIPCODE)
//                Log.d("POSTALCODE****", postalcode.toString())
//                val bundle = data.getBundleExtra(TRANSITION_BUNDLE)
//                Log.d("BUNDLE TEXT****", bundle?.getString("test").toString())
//                val fullAddress = data.getParcelableExtra<Address>(ADDRESS)
//                if (fullAddress != null) {
//                    Log.d("FULL ADDRESS****", fullAddress.toString())
//                }
//                val timeZoneId = data.getStringExtra(TIME_ZONE_ID)
//                Log.d("TIME ZONE ID****", timeZoneId.toString())
//                val timeZoneDisplayName = data.getStringExtra(TIME_ZONE_DISPLAY_NAME)
//                Log.d("TIME ZONE NAME****", timeZoneDisplayName.toString())
//            } else if (requestCode == 2) {
//                val latitude = data.getDoubleExtra(LATITUDE, 0.0)
//                Log.d("LATITUDE****", latitude.toString())
//                val longitude = data.getDoubleExtra(LONGITUDE, 0.0)
//                Log.d("LONGITUDE****", longitude.toString())
//                val address = data.getStringExtra(LOCATION_ADDRESS)
//                Log.d("ADDRESS****", address.toString())
//                val lekuPoi = data.getParcelableExtra<LekuPoi>(LEKU_POI)
//                Log.d("LekuPoi****", lekuPoi.toString())
//            }
//        }
//        if (resultCode == Activity.RESULT_CANCELED) {
//            Log.d("RESULT****", "CANCELLED")
//        }
//    }
}