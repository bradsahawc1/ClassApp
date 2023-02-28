package com.example.classapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classapp.UI.adapter.HoloAdapter
import com.example.classapp.model.Holomember
import com.example.classapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoloListFragment : Fragment() {

    //private var _binding FragmentHoloListBinding = null
    //        private var _binding get() =
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate layout for this fragment
        val view = inflater.inflate(R.layout.fragment_holo_list_fragment, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.holomember_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val holomembers = mutableListOf<Holomember>()

        val holoimages = mutableListOf(
            "https://yt3.ggpht.com/ytc/AL5GRJUjOyRvUrRPtu1nWZFJVco-L4-1Doz21LrA0Ph8CQ=s88-c-k-c0x00ffffff-no-rj-mo",
            "https://yt3.ggpht.com/ytc/AL5GRJUrjDs9nu_vln7jIkEZ-IFWh_Pdklfd7P9gZjZDcw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/I6f2LiL5tEL4ECQhPNJPvBkrf6WrKAS8nheCpTyyQSNKzCwBL2XJSGKxBMc6UNcUr1AR7hrjXw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJWJKhlVlvWMFGpXTnnYpHk4lGNzc3PX9hO_pkNwkw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/B2tq3IQAFxUe9W3MaMc0V62bmlTWCSoTuCk-Y-Ab8yXkZKdIswQhHABZhz2e4YM1-B_Kxen_7w=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJUM5Se9kgL1lTbGAbxSwZCqV59kMzFOcyauqGWU0w=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/wIqM7MWDN94PoibzPmeog7WOt8jFKTKZBOBFEbLBaiUAdKLwoqdLC_CN7B7Gby-FWH-076rN=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJWVMy6CP3-nntVNcOjS7kLQBED11gcbtmIDKB4iCg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/V3GVqD-sYadScSd8QYW4x1QTRfu2RyUNyKWVRb0IJxX0gj2PV6xH32d_BJHn3l0fouPLUw6Ref0=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/XDGhKwPZcT16Ppg2gQmLHEIYRhw9sY4rqG0HWbeCH68LHkhlVQrrFgxd5hWUuMb2nLfDOhu6=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJVfg7usJs6agMs5mUvsmTSF8yPUuIyXC0qNGbhUCg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJW-crxnS3jgptTNsrAkGFe6kzrTVueo-KwhQe1Cbw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/so69WMDlrSwil0013l7MLKIBLV--U_zjya2tG9_Sgij5NBm7raSvbZXUJiiAbQgrZosseqKDobM=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/Z78RNXxUqpOGYKFt-VrJV7nlehOHzl7Ta-l1cgPx5Ewucmr5kY64iGxmPSe7QqIdM1ZhvPlEOg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJXET2qFSQuuGI4d7Trk0PrOomVt7LKm_saoubcIZw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJV7jJwb8PY_8yLELCryv63RCRQhAS9R9g_FjDYihw=s88-c-k-c0x00ffffff-no-rj-mo",
            "https://yt3.ggpht.com/ytc/AL5GRJXx7mGZOLcoPNqxVLl2ZMeJ4IaRURPYVyxpsin_HA=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJXf1dta_cXCj-mknGO-Xg2x9MyWoY1cTcwGAKaSJw=s88-c-k-c0x00ffffff-no-rj-mo",
            "https://yt3.ggpht.com/ytc/AL5GRJXRok00Dg6ZVxaBWRERmHwZN71To0LpdRfyt1W0KQ=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/d9aIrGtZR0eI4k1Wnev5f_R4llIBsWnQOjkdsqkMycoAxA3g_zz-jyeBl8tEHfbm1iTg0SJj=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJUolaBKRs9tRgEA-9_tZsOykji2BQnoL1GXBvzjTw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/Z2QpYUZ4-jKoFR7Ms330gRQzjI2gZ4CB_uVP6f39YysxUe1u8icrtE07ffpRxCtpu9U65MWNDA=s88-c-k-c0x00ffffff-no-nd-rj",
            "https://yt3.ggpht.com/TlH8nz5O9UYo5JZ_5fo4JfXdT18N0Ck27wWrulni-c1g5bwes0tVmFiSKICzI1SW7itaTkk9GA=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/4wLMmSJkzy4vmWfWYkmzn6YO9T__jp1cORNuFXN7YyihwvhGkqXCxNBaklKoXlgdik-Fp0Zu=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/meRnxbRUm5yPSwq8Q5QpI5maFApm5QTGQV_LGblQFsoO0yAV4LI-nSZ70GYwMZ_tbfSa_O8MTCU=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/O7m_5HMY_O8yxR3Jhn9cEO1fLNL_GifMERExnAmfY7JrdTRsTjNijTcNYTPN97Llj3zGn8Susw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJVNfaDRC-fY8HtCqqKwTTr-QQR4LOT53cYRt2qVkQ=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/bMBMxmB1YVDVazU-8KbB6JZqUHn4YzmFiQRWwEUHCeqm5REPW7HHQChC5xE6e36aqqnXgK4a=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJWRETbnII0KtaCDehFPn2FKzDDkmXZ54awyT4GUOg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJUTRZn7fGT-7CjXjiFdkxgVryF-MoFrRgAKeRtjuA=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/roGS60A8a_lDbVakIg1JU3u3hbtjHSTilMGHMizuPKh7tuoY2nl46raxuW2f_83IKFGMjL6Z=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/R_IzGiw1xDQp0y9zVvGkF9e8Gj8wtr2_551Ez3X6gOMIj3e6jra1I1suuK_jH9FqigBj8ywg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/WO7ItKNmy6tW_NQ82g8c1y74CZSw6GsSdynsE5s2csuEok2fHRrAaGcBV3JJO-2BxEOXXA8lvw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/_xNtPLKQcQxMTnOr4tAcGz0GEeESsi0bQX9mJEP3fx_50a8GUfUyOG1eyLIld2cCz6GvKABwpQ=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/YK_UCAbw_pFBHSOw_LGWI-WCJDdvMP3y9mmODQ1IFEnNVvcf-M3-q22Db5TLWuAbfboMNFTMIg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJWGQ-2kdCjxXP5OqP0avmI6okZPuj9aYR0yWJizmQ=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/n_5KNxDFB0kCwGg4irLDJCL4y9S3sTOyKcPCtH6tbromGGIZxdogYvPi3di2B7TnrsZhiny8wQ=s88-c-k-c0x00ffffff-no-nd-rj",
            "https://yt3.ggpht.com/bF91weVtAIL7Uhnr2HVwtCTLVKK5kVsn4FC_Ze3Gl8rkSsEjDwyey3AbQ1PDfJQ1Oeac5cePeg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/okAbP3i7wWmBb4JaDuqjkFsGzMCg-05LOu5K0kKGoVwhGWsLUwun8pnXTzQ_uNBoimpiVoLp4D8=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/58uF1apTqtovpieDrBCSF5pUeNU2MA6n34bdj2EBEVnySKm-VvEznGNt2puk4v4tAnA3AYh5JA=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/sG7Yb1kCxTEP9ft03E-1Tr2Rho8GhMZ0_Kq9rf5MojWY9pf8vSL24xPG8e8GaE4jOxQKYlSvaL0=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/-IdVo-vK7pr0VRjJDdza1-t1Edjce1Rd1R1hon_3SRIzuQ-XVBTWOJj-UfwYPp8y40KM197_y4o=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/PxkGgLvMEUgmme35T0VPLR8d5brJw4YTzJC5PE48mkYRdy-mq8FsKv_Sy-bJmxqvlgtitqMWtg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/Zi6DMbqTrk8jpNKnJgbw_NxGnggsKX1omQnPeHxrZTmrVmon7zfmg5Q4XbqsHO9AMidW49zCPw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/8B_T08sx8R7XVi5Mwx_l9sjQm5FGWGspeujSvVDvd80Zyr-3VvVTRGVLOnBrqNRxZp6ZeXAV=s88-c-k-c0x00ffffff-no-nd-rj",
            "https://yt3.ggpht.com/w7TKJYU7zmamFmf-WxfahCo_K7Bg2__Pk-CCBNnbewMG-77OZLqJO9MLvDAmH9nEkZH8OkWgSQ=s88-c-k-c0x00ffffff-no-nd-rj",
            "https://yt3.ggpht.com/f4uYWHJxiGwyXm8NUlm818N1MRnywtgL6wM8JdWqWsKBzI7v1eg8dxDWG7igkWuukUSiufydqPg=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/uMUat6yJL2_Sk6Wg2-yn0fSIqUr_D6aKVNVoWbgeZ8N-edT5QJAusk4PI8nmPgT_DxFDTyl8=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/RZ4Fp3L6_zyq6YA7s5WnH8-22iezMLwdJhtkBgs_EAb06mvMCnF59JKMNu9YPCqb7nhaeXMdPvY=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/oC30wBZ04ibFN7AQVHAjdUX-3nS-h4DDjJBYVlsKt0OF6t1CZwrgzWlr3rS6Q12kXrw3-mt9gg=s88-c-k-c0x00ffffff-no-nd-rj",
            "https://yt3.ggpht.com/cBtserkb211p6If2OewgWd8oriIKRkfwTcP4_Vdq2YETG5TK9Q02v4cYmnLU03KBAJ0gcDha7oQ=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ntCVYU9_M3j3G_lYEKTaBsIRmB2ZA1W6uu3n7bHCwaT2HvzqL1t5ABhGaZ3ucfm1yP3-9hFQuw=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/owZmjfnG_SGVmfkl3eS7Lv47pGvIr2SrS36imh6O8i0H3Wy41fYKD26U7wnyRB627fXoq0aQ0Q=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/7gFSRIM3_DhczV8AYjeP4EaS0OL-u_xLvIh9JhG9zJhPYEfVwsoUOK61L6eBlLjnPHN-EDvytQ=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AL5GRJUfuX6ER-TKT-zgPQcvkP1mmq1lM4m7lDXfwfBvbA=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/zczPLp_sj4Qq3CyoGzfXifOdwE7aMHRpUdqbMD9UKvjddBG2NdMrCKElCMUOS6x85BMr2VGuAA=s88-c-k-c0x00ffffff-no-rj",
            "https://pbs.twimg.com/profile_images/1505507711764799489/_K2FdwDw_400x400.png",
            "https://pbs.twimg.com/profile_images/1556844597506019328/0X4oxIje_400x400.jpg"
        )

        val holonames = mutableListOf(
            "Tokino Sora", "Robocosan", "Yozora Mel", "Aki Rosenthal", "Akai Haato", "Shirakami Fubuki",
            "Natsuiro Matsuri", "Minato Aqua", "Murasaki Shion", "Nakiri Ayame", "Yuzuki Choco", "Oozora Subaru",
            "AZKi", "Ookami Mio", "Sakura Miko", "Nekomata Okayu", "Inugami Korone", "Hoshimachi Suisei",
            "Usada Pekora", "Shiranui Flare", "Shirogane Noel", "Houshou Marine", "Amane Kanata", "Tsunomaki Watame",
            "Tokoyami Towa", "Himemori Luna", "Yukihana Lamy", "Momosuzu Nene", "Shishiro Botan", "Omaru Polka",
            "La+ Darknesss", "Takane Lui", "Hakui Koyori", "Sakamata Chloe", "Kazama Iroha", "Ayunda Risu",
            "Moona Hoshinova", "Airani Iofifteen", "Kureiji Ollie", "Anya Melfissa", "Pavolia Reine", "Vestia Zeta",
            "Kaela Kovalskia", "Kobo Kanaeru", "Calliope Mori", "Kiara Takanashi", "Ina'nis Ninomae", "Gura Gawr",
            "Amelia Watson", "IRyS", "Fauna Ceres", "Ouro Kronii", "Mumei Nanashi", "Baelz Hakos",
            "Kiryu Coco", "Sana Tsukumo", "A-chan", "Harusaki Nodoka"
        )

        val holosubscount = mutableListOf(
            1060000, 90300, 803000, 732000, 1410000, 2070000,
            1330000, 1750000, 1090000, 1370000, 945000, 1440000,
            739000, 1070000, 1680000, 1550000, 1930000, 1770000,
            2170000, 961000, 1630000, 2290000, 1310000, 1330000,
            1200000, 891000, 1090000, 1020000, 1300000, 1070000,
            891000, 683000, 830000, 994000, 695000, 794000,
            1270000, 679000, 1240000, 604000, 738000, 683000,
            570000, 1840000, 2190000, 1450000, 1500000, 4270000,
            1730000, 913000, 688000, 844000, 780000, 682000,
            1420000, 402000, 1950000, 1950000
        )

        val hologens = mutableListOf(
            "Gen 0", "Gen 1", "Gen 2", "Gen 3", "Gen 4", "Gen 5", "HoloX", "Gamers",
            "HoloMyth", "Project: HOPE", "HoloCouncil",
            "Indonesia Gen 1", "Indonesia Gen 2", "Indonesia Gen 3",
            "Staff"
        )

        val holobirthdays = mutableListOf(
            "May 15th", "May 23rd", "October 31st", "February 17th", "August 10th", "October 5th",
            "July 22nd", "December 1st", "December 8th", "December 13th", "February 14th", "July 2nd",
            "July 1st", "August 20th", "March 5th", "February 22nd", "October 1st", "March 22nd",
            "January 12th", "April 2nd", "November 24th", "July 30th", "April 22nd", "June 6th",
            "August 8th", "October 10th", "November 15th", "March 2nd", "September 8th", "January 30th",
            "May 25th", "June 11th", "March 15th", "May 18th", "June 18th", "January 15th",
            "February 15th", "July 15th", "October 13th", "March 12th", "September 9th", "November 7th",
            "August 30th", "December 12th", "April 4th", "July 6th", "May 20th", "June 20th",
            "January 6th", "March 7th", "March 21st", "March 14th", "August 4th", "February 29th",
            "June 17th", "June 10th", "February 28th", "May 7th"
        )

        val holodebuts = mutableListOf(
            "September 7, 2017", "March 4, 2018", "May 13, 2018", "June 1, 2018", "June 2, 2018", "June 1, 2018",
            "June 1, 2018", "August 8, 2018", "August 17, 2018", "September 3, 2018", "September 4, 2018", "September 16, 2018",
            "November 15, 2018", "December 7, 2018", "August 1, 2018", "April 6, 2019", "April 13, 2019", "March 22, 2018",
            "July 17, 2019", "August 7, 2019", "August 8, 2019", "August 11, 2019", "December 27, 2019", "December 29, 2019",
            "January 3, 2020", "January 4, 2020", "August 12, 2020", "August 13, 2020", "August 14, 2020", "August 16, 2020",
            "November 26, 2021", "November 27, 2021", "November 28, 2021", "November 28, 2021", "November 30, 2021", "April 10, 2020",
            "April 11, 2020", "April 12, 2020", "December 4,2020", "December 5, 2020", "December 6, 2020", "March 25, 2022",
            "March 26, 2022", "March 27, 2022", "September 12, 2020", "September 12, 2020", "September 13, 2020", "September 13, 2020",
            "September 13, 2020", "July 11,2021", "August 23, 2021", "August 23, 2021", "August 23, 2021", "August 23, 2021",
            "December 28, 2019", "August 23, 2021", "February 28, 2018", "April 1, 2022"
        )

        val holoillustrators = mutableListOf(
            "Ordan", "Kuromaru9", "Ayamy", "Azumi Akitake", "Haruyuki", "Nagishiro Mito",
            "Minamura Haruki", "gaou", "Tam-U", "Nana Kagura", "Masuishi Kinoto", "Shigure Ui",
            "KasokuSato", "Izumi Sai", "Tanaka Yuuichi", "Kamioka Chiroru", "Fukahire", "Teshina Nari",
            "Yuuki Hagure", "lack", "Watao", "Akasa Ai", "Oshioshio", "fuumi",
            "rurudo", "Kanzaki Hiro", "Rin☆Yuu", "Nishizawa 5mm", "tomari", "Kou Mashiro",
            "Kurone Mishima", "Kakage", "Momoko", "Paseri", "Umibozu", "Yatomi",
            "Niyori", "Yano Mituki", "LAM", "Uekura Eku", "Pochi Lida", "Arutera",
            "Yasuda Suzuhito", "Ponkan⑧", "Yukisame", "huke", "Kuroboshi Kouhaku", "Amashiro Natsuki",
            "nabi", "redjuice", "Tohsaka Asagi", "WADARCO", "azure", "Mika Pikazo",
            "yaman", "pako", "Ordan", "Ordan"
        )

        val holostatus = mutableListOf(
            "active", "retired"
        )

        val holodesc = mutableListOf(
            getString(R.string.sora), getString(R.string.roboco), getString(R.string.mel), getString(R.string.aki), getString(R.string.haato), getString(R.string.fubuki),
            getString(R.string.matsuri), getString(R.string.aqua), getString(R.string.shion), getString(R.string.ayame), getString(R.string.choco), getString(R.string.subaru),
            getString(R.string.azki), getString(R.string.mio), getString(R.string.miko), getString(R.string.okayu), getString(R.string.korone), getString(R.string.suisei),
            getString(R.string.pekora), getString(R.string.flare), getString(R.string.noel), getString(R.string.marine), getString(R.string.kanata), getString(R.string.watame),
            getString(R.string.towa), getString(R.string.luna), getString(R.string.lamy), getString(R.string.nene), getString(R.string.botan), getString(R.string.polka),
            getString(R.string.laplus), getString(R.string.lui), getString(R.string.koyori), getString(R.string.chloe), getString(R.string.iroha), getString(R.string.risu),
            getString(R.string.moona), getString(R.string.iofi), getString(R.string.ollie), getString(R.string.anya), getString(R.string.reine), getString(R.string.zeta),
            getString(R.string.kaela), getString(R.string.kobo), getString(R.string.calli), getString(R.string.kiara), getString(R.string.ina), getString(R.string.gura),
            getString(R.string.amelia), getString(R.string.irys), getString(R.string.fauna), getString(R.string.kronii), getString(R.string.mumei), getString(R.string.bae),
            getString(R.string.coco), getString(R.string.sana), getString(R.string.frienda), getString(R.string.nodoka)
        )

        for (i in 0 .. 57) {
            if (i == 0 || i == 1 || i == 12 || i == 14 || i == 17) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[0], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[1], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[2], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 18 || i == 19 || i == 20 || i == 21) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[3], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 22 || i == 23 || i == 24 || i == 25 || i == 54) {
                if (i == 54) {
                    holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[4], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[1], holodesc[i]))
                }
                else {
                    holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[4], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
                }
            }
            else if (i == 26 || i == 27 || i == 28 || i == 29) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[5], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 30 || i == 31 || i == 32 || i == 33 || i == 34) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[6], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 13 || i == 15 || i == 16) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[7], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 44 || i == 45 || i == 46 || i == 47 || i == 48) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[8], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 49) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[9], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 50 || i == 51 || i == 52 || i == 53 || i == 55) {
                if (i == 55) {
                    holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[10], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[1], holodesc[i]))
                }
                else {
                    holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[10], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
                }
            }
            else if (i == 35 || i == 36 || i == 37) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[11], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 38 || i == 39 || i == 40) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[12], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 41 || i == 42 || i == 43) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[13], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else if (i == 56 || i == 57) {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], hologens[14], holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[0], holodesc[i]))
            }
            else {
                holomembers.add(createHolomember(holoimages[i], holonames[i], holosubscount[i], "Did not find", holobirthdays[i], holodebuts[i], holoillustrators[i], holostatus[1], holodesc[i]))
            }
        }

        val adapter = HoloAdapter(holomembers)
        recyclerView.adapter = adapter

        return view
    }
    private fun createHolomember(
        image: String,
        name: String,
        subscribers: Int,
        gen: String,
        birthday: String,
        debut: String,
        illustrator: String,
        status: String,
        description: String
    ) = Holomember(
        image = image,
        name = name,
        subscribers = subscribers,
        gen = gen,
        birthday = birthday,
        debut = debut,
        illustrator = illustrator,
        status = status,
        description = description
    )
}