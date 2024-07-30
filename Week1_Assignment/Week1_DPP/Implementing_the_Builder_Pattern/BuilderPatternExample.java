public class BuilderPatternExample {

    // Product class
    public static class Computer {
        // Attributes of the Computer
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String motherboard;
        private String powerSupply;
        private String caseType;

        // Private constructor to prevent direct instantiation
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.GPU = builder.GPU;
            this.motherboard = builder.motherboard;
            this.powerSupply = builder.powerSupply;
            this.caseType = builder.caseType;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU +
                    ", motherboard=" + motherboard + ", powerSupply=" + powerSupply + ", caseType=" + caseType + "]";
        }

        // Static nested Builder class
        public static class Builder {
            // Same attributes as in the Computer class
            private String CPU;
            private String RAM;
            private String storage;
            private String GPU;
            private String motherboard;
            private String powerSupply;
            private String caseType;

            // Methods to set each attribute, returning the Builder itself
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGPU(String GPU) {
                this.GPU = GPU;
                return this;
            }

            public Builder setMotherboard(String motherboard) {
                this.motherboard = motherboard;
                return this;
            }

            public Builder setPowerSupply(String powerSupply) {
                this.powerSupply = powerSupply;
                return this;
            }

            public Builder setCaseType(String caseType) {
                this.caseType = caseType;
                return this;
            }

            // Method to build the final Computer object
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Test class to demonstrate the creation of different configurations of Computer using the Builder pattern
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("ASUS ROG")
                .setPowerSupply("750W")
                .setCaseType("Mid Tower")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated")
                .setMotherboard("Gigabyte B450M")
                .setPowerSupply("500W")
                .setCaseType("Mini Tower")
                .build();

        // Print the configurations
        System.out.println(gamingComputer);
        System.out.println(officeComputer);
    }
}
