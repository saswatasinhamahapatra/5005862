// Define the Image interface
interface Image {
    void display();
}

// Implement the RealImage class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        // Simulate loading image from a remote server
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Implement the ProxyImage class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Test the ProxyPattern implementation
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // The first time display is called, the image is loaded and displayed
        image1.display();
        System.out.println("");
        image2.display();
        System.out.println("");

        // The image is already loaded, so it is only displayed
        image1.display();
    }
}
