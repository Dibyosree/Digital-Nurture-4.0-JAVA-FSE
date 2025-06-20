class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return productId + " - " + productName + " [" + category + "]";
    }
}

public class ECommerceSearch {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) return products[mid];
            else if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "Book", "Stationery"),
            new Product(105, "Shoes", "Footwear")
        };

        System.out.println(" Linear Search:");
        Product result1 = linearSearch(products, "Mobile");
        System.out.println(result1 != null ? "Found: " + result1 : "Not found");

        java.util.Arrays.sort(products, java.util.Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n Binary Search:");
        Product result2 = binarySearch(products, "Mobile");
        System.out.println(result2 != null ? "Found: " + result2 : "Not found");
        System.out.println("\n Analysis:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
        System.out.println("Use Binary Search for large, sorted datasets.");
    }
}
