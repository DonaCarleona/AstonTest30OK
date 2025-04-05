public class Park {
    Attraction[] attractions;

    class Attraction {
        private String name;
        private String workFrom;
        private String workTo;
        private float price;


        public Attraction(String name, String workFrom, String workTo, float price) {
            this.name = name;
            this.workFrom = workFrom;
            this.workTo = workTo;
            this.price = price;
        }
    }
}
