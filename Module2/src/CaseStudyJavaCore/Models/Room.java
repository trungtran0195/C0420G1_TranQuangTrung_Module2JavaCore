package CaseStudyJavaCore.Models;

public class Room extends Services{
        private String freeService;

        public Room(String id, String nameService, double areaUsed, double rentalCosts, int maxNumberOfPeople, String typeRent, String freeService) {
            super(id, nameService, areaUsed, rentalCosts, maxNumberOfPeople, typeRent);
            this.freeService = freeService;
        }

        public Room() {
        }

        public String getFreeService() {
            return freeService;
        }

        public void setFreeService(String freeService) {
            this.freeService = freeService;
        }

        @Override
        public void showInfo() {
            System.out.println(
                    "Service Id: " + super.getId() +
                            "\nService Name: " + super.getServiceName() +
                            "\nArea Used: " + super.getAreaUsed() +
                            "\nRental Costs: " + super.getRentalCosts() +
                            "\nMax Number Of People: " + super.getMaxNumberOfPeople() +
                            "\nType Rent: " + super.getRentType() +
                            "\nRoom Standard: " + this.freeService
            );
        }
    }
