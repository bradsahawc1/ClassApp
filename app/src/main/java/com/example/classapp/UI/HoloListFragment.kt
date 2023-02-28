package com.example.classapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classapp.UI.adapter.HoloAdapter
import com.example.classapp.model.Holomember
import com.example.classapp.R
import com.example.classapp.databinding.FragmentHoloListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoloListFragment : Fragment() {

    private var _binding: FragmentHoloListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHoloListBinding.inflate(inflater, container, false)

        binding.holomemberRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val holomembers = mutableListOf<Holomember>()

        val holoimages = mutableListOf(
            "https://pbs.twimg.com/profile_images/1621691465633243142/fbPb9E3Z_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1619119925473460225/p6wCqIBS_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1596800147190472704/4EuVKWKO_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1609202963746283531/J2acjzjY_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1528399864908103680/pemD2PzM_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1620372106684043264/t8II1co4_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1619022722696364034/f3md5xpo_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1604390688275464192/A5BL2Vtc_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1559094931196547072/SGbbEvDH_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1602554756001824768/RPICnpHu_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1625810164770312192/kBiz3RFU_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1620365616426393606/t_86j3vx_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1592837458298687488/VFvmjzhq_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1561929735503982598/TK1j5LXE_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1624168313088794625/fnnNodzC_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1628383781492260866/u3yPJleX_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1502928778346975240/5l1_2krP_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1630247328362921984/amn_1hOf_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1257493659206987776/-V8qqjEQ_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1459447923646042112/0UXz73jg_400x400.png",
            "https://pbs.twimg.com/profile_images/1515252078863876096/SOPY6Cug.jpg",
            "https://pbs.twimg.com/profile_images/1353776264474189832/fjRmj0SO_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1611270433780924416/mixlbOf__400x400.jpg",
            "https://pbs.twimg.com/profile_images/1341733161986830340/QJH6m-5G_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1629596956606750721/6XaDiOJf_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1622107042948485120/7qekiIrZ_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1628402215806455808/ql9z89it_400x400.jpg",
            "https://pbs.twimg.com/media/FklEy5tUUAIFFnt?format=jpg&name=small",
            "https://pbs.twimg.com/profile_images/1559867706177769473/OzzM4fy1_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1620384376134713350/WyJAErr0_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1589595670604050432/3-q80ST-_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1601837355916472320/o6R-vH6Q_400x400.jpg",
            "https://yt3.ggpht.com/WO7ItKNmy6tW_NQ82g8c1y74CZSw6GsSdynsE5s2csuEok2fHRrAaGcBV3JJO-2BxEOXXA8lvw=s400-c-k-c0x00ffffff-no-rj",
            "https://pm1.narvii.com/8295/06ce87c539136fe241dfbc17551ba210d72c6b74r1-400-400v2_hq.jpg",
            "https://pbs.twimg.com/profile_images/1538134538056265734/lx9tQHyM_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1594245571271065601/1plE5Odb_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1538698250710323201/W9o83ZLq_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1609447915910750210/nUVX2vWa_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1627908125520199682/F8mZIz2G_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1510143483759448070/pLZSdaf2_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1601233403143020547/6FUVfuIN_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1622292394531233792/MTrEp5So_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1575546046582706176/-1o3kGwL_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1612751002675089410/ImR-PGES_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1588388558972166149/eM2PwPYu_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1622057887123083266/RY5z5m1S_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1491177795447230464/CuUdYpmC_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1539701674679291904/ZrBJqhoc_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1612108697777614848/VWEDagXP_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1617881590256005120/IvmdYrHy_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1506076959171747846/L4YOzTGc_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1608782540126687232/Y9Z3lNev_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1609598940974034946/Jyy0hBrZ_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1584014248958898178/WesHK_a-_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1369675059896352769/rRp8PTCQ_400x400.jpg",
            "https://pbs.twimg.com/profile_images/1496174849106268163/NIfJDxaY_400x400.png",
            "https://pbs.twimg.com/profile_images/1505507711764799489/_K2FdwDw_400x400.png",
            "https://pbs.twimg.com/profile_images/1556844597506019328/0X4oxIje_400x400.jpg"
        )

        val holonames = mutableListOf(
            "Tokino Sora",
            "Robocosan",
            "Yozora Mel",
            "Aki Rosenthal",
            "Akai Haato",
            "Shirakami Fubuki",
            "Natsuiro Matsuri",
            "Minato Aqua",
            "Murasaki Shion",
            "Nakiri Ayame",
            "Yuzuki Choco",
            "Oozora Subaru",
            "AZKi",
            "Ookami Mio",
            "Sakura Miko",
            "Nekomata Okayu",
            "Inugami Korone",
            "Hoshimachi Suisei",
            "Usada Pekora",
            "Shiranui Flare",
            "Shirogane Noel",
            "Houshou Marine",
            "Amane Kanata",
            "Tsunomaki Watame",
            "Tokoyami Towa",
            "Himemori Luna",
            "Yukihana Lamy",
            "Momosuzu Nene",
            "Shishiro Botan",
            "Omaru Polka",
            "La+ Darknesss",
            "Takane Lui",
            "Hakui Koyori",
            "Sakamata Chloe",
            "Kazama Iroha",
            "Ayunda Risu",
            "Moona Hoshinova",
            "Airani Iofifteen",
            "Kureiji Ollie",
            "Anya Melfissa",
            "Pavolia Reine",
            "Vestia Zeta",
            "Kaela Kovalskia",
            "Kobo Kanaeru",
            "Calliope Mori",
            "Kiara Takanashi",
            "Ina'nis Ninomae",
            "Gura Gawr",
            "Amelia Watson",
            "IRyS",
            "Fauna Ceres",
            "Ouro Kronii",
            "Mumei Nanashi",
            "Baelz Hakos",
            "Kiryu Coco",
            "Sana Tsukumo",
            "A-chan",
            "Harusaki Nodoka"
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
            "May 15th",
            "May 23rd",
            "October 31st",
            "February 17th",
            "August 10th",
            "October 5th",
            "July 22nd",
            "December 1st",
            "December 8th",
            "December 13th",
            "February 14th",
            "July 2nd",
            "July 1st",
            "August 20th",
            "March 5th",
            "February 22nd",
            "October 1st",
            "March 22nd",
            "January 12th",
            "April 2nd",
            "November 24th",
            "July 30th",
            "April 22nd",
            "June 6th",
            "August 8th",
            "October 10th",
            "November 15th",
            "March 2nd",
            "September 8th",
            "January 30th",
            "May 25th",
            "June 11th",
            "March 15th",
            "May 18th",
            "June 18th",
            "January 15th",
            "February 15th",
            "July 15th",
            "October 13th",
            "March 12th",
            "September 9th",
            "November 7th",
            "August 30th",
            "December 12th",
            "April 4th",
            "July 6th",
            "May 20th",
            "June 20th",
            "January 6th",
            "March 7th",
            "March 21st",
            "March 14th",
            "August 4th",
            "February 29th",
            "June 17th",
            "June 10th",
            "February 28th",
            "May 7th"
        )

        val holodebuts = mutableListOf(
            "September 7, 2017",
            "March 4, 2018",
            "May 13, 2018",
            "June 1, 2018",
            "June 2, 2018",
            "June 1, 2018",
            "June 1, 2018",
            "August 8, 2018",
            "August 17, 2018",
            "September 3, 2018",
            "September 4, 2018",
            "September 16, 2018",
            "November 15, 2018",
            "December 7, 2018",
            "August 1, 2018",
            "April 6, 2019",
            "April 13, 2019",
            "March 22, 2018",
            "July 17, 2019",
            "August 7, 2019",
            "August 8, 2019",
            "August 11, 2019",
            "December 27, 2019",
            "December 29, 2019",
            "January 3, 2020",
            "January 4, 2020",
            "August 12, 2020",
            "August 13, 2020",
            "August 14, 2020",
            "August 16, 2020",
            "November 26, 2021",
            "November 27, 2021",
            "November 28, 2021",
            "November 28, 2021",
            "November 30, 2021",
            "April 10, 2020",
            "April 11, 2020",
            "April 12, 2020",
            "December 4,2020",
            "December 5, 2020",
            "December 6, 2020",
            "March 25, 2022",
            "March 26, 2022",
            "March 27, 2022",
            "September 12, 2020",
            "September 12, 2020",
            "September 13, 2020",
            "September 13, 2020",
            "September 13, 2020",
            "July 11,2021",
            "August 23, 2021",
            "August 23, 2021",
            "August 23, 2021",
            "August 23, 2021",
            "December 28, 2019",
            "August 23, 2021",
            "February 28, 2018",
            "April 1, 2022"
        )

        val holoillustrators = mutableListOf(
            "Ordan",
            "Kuromaru9",
            "Ayamy",
            "Azumi Akitake",
            "Haruyuki",
            "Nagishiro Mito",
            "Minamura Haruki",
            "gaou",
            "Tam-U",
            "Nana Kagura",
            "Masuishi Kinoto",
            "Shigure Ui",
            "KasokuSato",
            "Izumi Sai",
            "Tanaka Yuuichi",
            "Kamioka Chiroru",
            "Fukahire",
            "Teshina Nari",
            "Yuuki Hagure",
            "lack",
            "Watao",
            "Akasa Ai",
            "Oshioshio",
            "fuumi",
            "rurudo",
            "Kanzaki Hiro",
            "Rin☆Yuu",
            "Nishizawa 5mm",
            "tomari",
            "Kou Mashiro",
            "Kurone Mishima",
            "Kakage",
            "Momoko",
            "Paseri",
            "Umibozu",
            "Yatomi",
            "Niyori",
            "Yano Mituki",
            "LAM",
            "Uekura Eku",
            "Pochi Lida",
            "Arutera",
            "Yasuda Suzuhito",
            "Ponkan⑧",
            "Yukisame",
            "huke",
            "Kuroboshi Kouhaku",
            "Amashiro Natsuki",
            "nabi",
            "redjuice",
            "Tohsaka Asagi",
            "WADARCO",
            "azure",
            "Mika Pikazo",
            "yaman",
            "pako",
            "Ordan",
            "Ordan"
        )

        val holostatus = mutableListOf(
            "active", "retired"
        )

        val holodesc = mutableListOf(
            getString(R.string.sora),
            getString(R.string.roboco),
            getString(R.string.mel),
            getString(R.string.aki),
            getString(R.string.haato),
            getString(R.string.fubuki),
            getString(R.string.matsuri),
            getString(R.string.aqua),
            getString(R.string.shion),
            getString(R.string.ayame),
            getString(R.string.choco),
            getString(R.string.subaru),
            getString(R.string.azki),
            getString(R.string.mio),
            getString(R.string.miko),
            getString(R.string.okayu),
            getString(R.string.korone),
            getString(R.string.suisei),
            getString(R.string.pekora),
            getString(R.string.flare),
            getString(R.string.noel),
            getString(R.string.marine),
            getString(R.string.kanata),
            getString(R.string.watame),
            getString(R.string.towa),
            getString(R.string.luna),
            getString(R.string.lamy),
            getString(R.string.nene),
            getString(R.string.botan),
            getString(R.string.polka),
            getString(R.string.laplus),
            getString(R.string.lui),
            getString(R.string.koyori),
            getString(R.string.chloe),
            getString(R.string.iroha),
            getString(R.string.risu),
            getString(R.string.moona),
            getString(R.string.iofi),
            getString(R.string.ollie),
            getString(R.string.anya),
            getString(R.string.reine),
            getString(R.string.zeta),
            getString(R.string.kaela),
            getString(R.string.kobo),
            getString(R.string.calli),
            getString(R.string.kiara),
            getString(R.string.ina),
            getString(R.string.gura),
            getString(R.string.amelia),
            getString(R.string.irys),
            getString(R.string.fauna),
            getString(R.string.kronii),
            getString(R.string.mumei),
            getString(R.string.bae),
            getString(R.string.coco),
            getString(R.string.sana),
            getString(R.string.frienda),
            getString(R.string.nodoka)
        )

        for (i in 0..57) {
            if (i == 0 || i == 1 || i == 12 || i == 14 || i == 17) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[0],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[1],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[2],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 18 || i == 19 || i == 20 || i == 21) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[3],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 22 || i == 23 || i == 24 || i == 25 || i == 54) {
                if (i == 54) {
                    holomembers.add(
                        createHolomember(
                            holoimages[i],
                            holonames[i],
                            holosubscount[i],
                            hologens[4],
                            holobirthdays[i],
                            holodebuts[i],
                            holoillustrators[i],
                            holostatus[1],
                            holodesc[i]
                        )
                    )
                } else {
                    holomembers.add(
                        createHolomember(
                            holoimages[i],
                            holonames[i],
                            holosubscount[i],
                            hologens[4],
                            holobirthdays[i],
                            holodebuts[i],
                            holoillustrators[i],
                            holostatus[0],
                            holodesc[i]
                        )
                    )
                }
            } else if (i == 26 || i == 27 || i == 28 || i == 29) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[5],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 30 || i == 31 || i == 32 || i == 33 || i == 34) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[6],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 13 || i == 15 || i == 16) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[7],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 44 || i == 45 || i == 46 || i == 47 || i == 48) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[8],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 49) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[9],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 50 || i == 51 || i == 52 || i == 53 || i == 55) {
                if (i == 55) {
                    holomembers.add(
                        createHolomember(
                            holoimages[i],
                            holonames[i],
                            holosubscount[i],
                            hologens[10],
                            holobirthdays[i],
                            holodebuts[i],
                            holoillustrators[i],
                            holostatus[1],
                            holodesc[i]
                        )
                    )
                } else {
                    holomembers.add(
                        createHolomember(
                            holoimages[i],
                            holonames[i],
                            holosubscount[i],
                            hologens[10],
                            holobirthdays[i],
                            holodebuts[i],
                            holoillustrators[i],
                            holostatus[0],
                            holodesc[i]
                        )
                    )
                }
            } else if (i == 35 || i == 36 || i == 37) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[11],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 38 || i == 39 || i == 40) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[12],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 41 || i == 42 || i == 43) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[13],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else if (i == 56 || i == 57) {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        hologens[14],
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[0],
                        holodesc[i]
                    )
                )
            } else {
                holomembers.add(
                    createHolomember(
                        holoimages[i],
                        holonames[i],
                        holosubscount[i],
                        "Did not find",
                        holobirthdays[i],
                        holodebuts[i],
                        holoillustrators[i],
                        holostatus[1],
                        holodesc[i]
                    )
                )
            }
        }

        val adapter = HoloAdapter(holomembers) { position ->
            val holomember = holomembers[position]

            val bundle = bundleOf(
                "image" to holomember.image,
                "name" to holomember.name,
                "subs" to holomember.subscribers,
                "gen" to holomember.gen,
                "birthday" to holomember.birthday,
                "debut" to holomember.debut,
                "illustrator" to holomember.illustrator,
                "status" to holomember.status,
                "description" to holomember.description
            )

            val detailFragment = HoloDetailFragment()
            detailFragment.arguments = bundle

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, detailFragment)
                addToBackStack(null)
            }
        }
        binding.holomemberRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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