package utils;

public enum Products {
    PRINTED_CHIFFON_DRESS("Printed Chiffon Dress",7);

    private String displayName;
    private int productID;

    private Products(String displayName, int productID) {
        this.displayName = displayName;
        this.productID = productID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getProductID() {
        return productID;
    }

    public static int getProductID(String displayName){

        for (Products product:Products.values())
        {
            if(product.getDisplayName().equalsIgnoreCase(displayName))

                return product.getProductID();
        }
        return -1;
    }
}
