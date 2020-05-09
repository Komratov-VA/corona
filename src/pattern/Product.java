package pattern;


//Шаблон Builder
//   Product product = new Product.Builder("car").price(10000).build();
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
public class Product {

    private final String name;
    private final int price;

    public static class Builder {
        private final String name;

        private int price = 0;
        public Builder(String name) {
            this.name = name;
        }

        public Builder price(int value){
            this.price = value;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }

    private Product(Builder builder){
        name = builder.name;
        price = builder.price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}

