package com.tlh.xmlservice.services

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import java.lang.Exception

class CdCatService {

    fun parseCdCat(url: String): Array<CdCatalogue>{

        val cdCat = mutableListOf<CdCatalogue>()

        try {
            val strData2 = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            Log.d("xml", strData2)
            val doc = Jsoup.parse(strData2, "", Parser.xmlParser())
            val cds = doc.select("CD")

            for (element in cds) {
                val title = element.select("TITLE").text()
                val artist = element.select("ARTIST").text()
                val country = element.select("COUNTRY").text()
                val company = element.select("COMPANY").text()
                val price = element.select("PRICE").text().toDouble()
                val year = element.select("YEAR").text().toDouble()
                cdCat.add(CdCatalogue(title, artist, country, company,price,year))
                Log.d(
                    "CD",
                    "CD title: $title, CD Artist: $artist, Cd Country: $country, CD Company: $company, CD Price: $price, CD Year:$year"
                )
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return cdCat.toTypedArray()
    }
}


