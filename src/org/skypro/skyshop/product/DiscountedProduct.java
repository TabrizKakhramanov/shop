package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int productPrice;
    private int discount;

    public DiscountedProduct(String productName, int productPrice, int discount){
        super(productName);
        this.productPrice= productPrice;
        this.discount=discount;
    }

    @Override
    public int getProductPrice() {
        return productPrice*(100-discount)/100;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return getProductName()+": "+getProductPrice()+" скидка: "+getDiscount()+"%";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
