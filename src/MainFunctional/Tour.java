package MainFunctional;

import MyUtils.MyUtils;

public class Tour {
    private final String country, city;
    private final int days, rating;
    private final double price;
    private final tourTransport transport;
    private final tourFood food;

    public Tour (String country, String city, tourTransport transport, int day, double price, int rating, tourFood food) {
        this.country = country;
        this.city = city;
        this.transport = transport;
        this.days = day;
        this.price = price;
        this.rating = rating;
        this.food = food;
    }

    public String getCountry () {
        return country;
    }
    public String getCity () {
        return city;
    }
    public int getDays () {
        return days;
    }
    public int getRating () {
        return rating;
    }
    public double getPrice () {
        return price;
    }
    public tourTransport getTransport () {
        return transport;
    }
    public tourFood getFood () {
        return food;
    }
    public String getTextData (tourIndex data) {
        switch (data) {
            case country:
                return country;
            case city:
                return city;
            case transport:
                return MyUtils.trans(transport);
            case days:
                return String.valueOf(days);
            case price:
                return String.valueOf(price);
            case rating:
                return String.valueOf(rating);
            case food:
                return MyUtils.trans(food);
            default:
                return "";
        }
    }
}
