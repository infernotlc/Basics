package com.tlh.xmlservice.services

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader
import java.lang.Exception

class XmlService {

    fun xmlLoad(url: String): Array<Currency> {
        val currencies = mutableListOf<Currency>()
        try {

            val strData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString()
            Log.d("xml", strData)
            val doc = Jsoup.parse(strData, Parser.xmlParser())
            val elements = doc.select("Currency")

            for (element in elements) {
                val currencyName = element.select("CurrencyName").text()
                val forexBuying = element.select("ForexBuying").text().toDouble()
                val forexSelling = element.select("ForexSelling").text().toDouble()
                val crossRateUSD = element.select("CrossRateUSD").text().toDouble()
                currencies.add(Currency(currencyName, forexBuying, forexSelling, crossRateUSD))
                Log.d(
                    "Currency",
                    "Currency Name: $currencyName, Forex Buying: $forexBuying, Forex Selling: $forexSelling, Cross Rate USD: $crossRateUSD"
                )
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return currencies.toTypedArray()
    }
}