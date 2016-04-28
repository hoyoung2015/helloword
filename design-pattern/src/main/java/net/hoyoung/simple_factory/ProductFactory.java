package net.hoyoung.simple_factory;

/**
 * Created by hoyoung on 16-4-21.
 */
public class ProductFactory {
    public static Product getProduct(String arg){
        Product product = null;
        if("A".equalsIgnoreCase(arg)){
            product = new ConcreteProductA();
        }else if ("B".equalsIgnoreCase(arg)){
            product = new ConcreteProductB();
        }
        return product;
    }

    public static void main(String[] args) {
        Product product = ProductFactory.getProduct("A");
        product.methodDiff();
    }
}
