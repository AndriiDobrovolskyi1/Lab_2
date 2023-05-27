package com.andrii.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {


    val countries:List<Countries> =
        listOf(
            Countries(
                "Ukraine", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALYAAAB5CAMAAACjkCtXAAAAGFBMVEX+8gAAfML/+QCYu2gAcs4GgMYEf8MAddExiS+nAAAAdUlEQVR4nO3OwRGDMBAAsUsIuP+O6YHHMs5IFWjOz4bOeXvwjHZJu6Rd0i5pl7RL2iXtknZJu6Rd0i5pl7RL2iXtknZJu6Rd0i5pl7RL2iXtknZJu6Rd0i7N9fbgiWvWb0Nrji3Nd0sDAAAAAAAAAAAAwP+6Ac1QMHED96LoAAAAAElFTkSuQmCC","Kyiv","Ukraine is a country with a rich history, enchanting nature, and hospitable people. Kyiv, the capital of Ukraine, is known for its historical landmarks such as the St. Sophia Cathedral and Kyiv Pechersk Lavra. Cultural diversity, delicious Ukrainian cuisine, and versatility are just some of the features that attract tourists from around the world to Ukraine and its capital."),
            Countries(
                "Poland", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARwAAACxCAMAAAAh3/JWAAAADFBMVEX////cFDzup6/bAC47xqeuAAAA0UlEQVR4nO3QMQHAMAzAsLTjz3kI4qO3BEEzAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPLms5mM1h5WcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICfICXKCnCAnyAlygpwgJ8gJcoKcICf8zMtmEUHJBe8AAAAASUVORK5CYII=","Warsaw","Poland boasts a captivating history, breathtaking landscapes, and welcoming locals. From the historic streets of Warsaw to the majestic beauty of the Tatra Mountains, Poland offers a unique blend of cultural heritage and natural wonders."),
            Countries(
                "Italy", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAFVBMVEX///8AkkbOKzcAjj1/wJndeoDNIC4fGYjbAAAA/klEQVR4nO3QSQ0AIAADsHH6l4yKPUhaCc2oWTs9586aOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHy4ckD5KrN4eD2boIAAAAASUVORK5CYII=","Rome","Italy is a country of history, stunning architecture, and exquisite cuisine. Rome, the capital, is known for its iconic landmarks and rich heritage. From the canals of Venice to the coastlines of the Amalfi Coast, Italy offers diverse beauty and culinary delights."),
            Countries(
                "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAFVBMVEX///8AJlTOESYAGU16gpXefILNABnwlnA6AAAA/klEQVR4nO3QSQ0AIAADsHH6l4yKPUhaCc2oWTs9586aOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHixIkTJ06cOHHy4ckD5KrN4eD2boIAAAAASUVORK5CYII=","Paris","France is a country of culture, culinary delights, and romantic charm. Paris, the capital, is famous for its iconic landmarks and world-class art. From vineyards to the French Riviera, France offers a mix of stunning landscapes and sophistication."),
            Countries(
                "German", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQ4AAAC7CAMAAACjH4DlAAAAmVBMVEUAAAD/zgDdAACtAADhAADnUAD/1QD/////zADo2dnu3d3n5+fx8fH04NXx3dTh4eEyMjLmQgD/yQD4+Pi7u7uJiYlJSUkUFBQ/Pz9tbW1iYmKSkpI5OTkPDw9GRkbOzs6qqqrt4OT46uT7uwD8wQDyuSL4wi/zyI351I/zuUD5xUX55dPxxWX4y3L37+v37u32xlX42a392HygnSnKAAACZUlEQVR4nO3XW1LbQBgF4SG3MSBjkDEESCCxjUMSLoH9Ly5jYws1G/inSv096fFU10hTSrkzPZ2dnaeBOf86O23eGqTdw+Qielmcy8n7HLPoSbGukKP5Fr0n2lkvR/M9ek2842mX4zh6Sw2udzkG/BHtm73muIneUYvDTY7r6Bm1uFznmESvqEdTclxFj6jHj5LDa6VzUXJEb6hJTk30hJrkdBg9oSZTc/Q15ugzB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHNAk/Y/qnOQ9j+pU3J8UMccYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5gDzAHmAHOAOcAcYA4wB5QcJ5+1dXKQxl/UGaej0Z62RuboMweYA8wB5gBzgDnAHGAOMAeYA8wB5gBzgDnAHGAOMAeYA8wB5gBzgDnAHGAOMAeYA8wB5gBzgDnAHGAOMAeYA8wB5gBzgDnAHGAOMAeYA8wB5gBzQMnx0xyd0TzlRfSIeixzyrfRI+qxKjl+RY+ox13JMW6jV9SinZcc+Xf0jFr8yescRx6PjfbvJke+jx5Sh4f8msPLZW2VdzkefV32lo9djvw0+POx2tTY5sj5YdAHpL3bZtjlyPN/gw3S3s/z+xzljXl+uV0M7YduuXh5fnpr8B9Zf/AvuGoNeAAAAABJRU5ErkJggg==","Berlin","Germany is a country of efficiency, innovation, and rich culture. Berlin, the capital, is known for its vibrant art scene and historical landmarks. From the Black Forest to fairy-tale castles, Germany offers diverse beauty and engineering excellence."),
            Countries(
                "Czech", "data:image/jpeg;base64,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","Prague","Czech Republic is a country with rich history, stunning architecture, and excellent beer. Prague, the capital, boasts medieval charm and iconic landmarks like Prague Castle and Charles Bridge. From picturesque spa towns to enchanting landscapes, Czech Republic offers a captivating blend of culture and natural beauty."),
            Countries(
                "", "","",""),


            )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = Adapter(countries)
        return view
    }


}