class ParkingLot {

    String[] spots = new String[10];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public void parkVehicle(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {
            index = (index + 1) % spots.length;
        }

        spots[index] = plate;

        System.out.println("Parked at spot " + index);
    }

    public void exitVehicle(String plate) {

        for (int i = 0; i < spots.length; i++) {

            if (plate.equals(spots[i])) {
                spots[i] = null;
                System.out.println("Vehicle exited spot " + i);
            }
        }
    }
}