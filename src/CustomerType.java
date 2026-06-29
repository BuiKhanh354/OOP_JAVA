public enum CustomerType {

    NORMAL(0.0),
    SILVER(0.10),
    GOLD(0.15);

    private final double discount;

    CustomerType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
