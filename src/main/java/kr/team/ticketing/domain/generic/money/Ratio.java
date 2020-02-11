package kr.team.ticketing.domain.generic.money;

public class Ratio {
    private double rate;

    public static Ratio valueOf(double rate){
        return new Ratio(rate);
    }

    Ratio(double rate){
        this.rate = rate;
    }

    Ratio() {

    }

    public Money of(Money price) {
        Money discount = price.times(rate);
        return price.minus(discount);
    }

    public double getRate() {
        return rate;
    }
}
