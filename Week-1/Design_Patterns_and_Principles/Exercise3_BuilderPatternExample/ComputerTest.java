public class ComputerTest {
    public static void main(String[] args) {
        Computer office = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .build();

        Computer gaming = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("2TB SSD")
                .setGpu("RTX 4080")
                .build();

        System.out.println(office);
        System.out.println(gaming);
    }
}
