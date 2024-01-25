package kz.zhandos.features.weather.presentation.factory

import kz.zhandos.features.weather.presentation.model.CityDvo

interface CityFactory {

    fun createCityList(): List<CityDvo>
}

class DefaultCityFactory : CityFactory {
    override fun createCityList(): List<CityDvo> {
        return listOf(
            CityDvo("Almaty", CityDvo.GpsLocationDvo(43.2551, 76.9126)),
            CityDvo("Nur-Sultan", CityDvo.GpsLocationDvo(51.1694, 71.4491)),
            CityDvo("Shymkent", CityDvo.GpsLocationDvo(42.3176, 69.5907)),
            CityDvo("Karaganda", CityDvo.GpsLocationDvo(49.8027, 73.0892)),
            CityDvo("Aktobe", CityDvo.GpsLocationDvo(50.2797, 57.2072)),
            CityDvo("Taraz", CityDvo.GpsLocationDvo(42.9010, 71.3645)),
            CityDvo("Pavlodar", CityDvo.GpsLocationDvo(52.2814, 76.9524)),
            CityDvo("Ust-Kamenogorsk", CityDvo.GpsLocationDvo(49.9636, 82.6056)),
            CityDvo("Semey", CityDvo.GpsLocationDvo(50.4115, 80.2272)),
            CityDvo("Atyrau", CityDvo.GpsLocationDvo(47.1120, 51.9291)),
            CityDvo("Kostanay", CityDvo.GpsLocationDvo(53.2148, 63.6296)),
            CityDvo("Petropavl", CityDvo.GpsLocationDvo(54.8730, 69.1358)),
        )
    }
}