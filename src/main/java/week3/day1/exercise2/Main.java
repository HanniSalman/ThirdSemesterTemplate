package week3.day1.exercise2;

public class Main {
    public static void main(String[] args) {
        UnicornDAO unicornDAO = new UnicornDAO();


        //Create
        Unicorn unicorn = new Unicorn("Hans", 36, 70);
        Unicorn saveUnicorn = unicornDAO.save(unicorn);

        //Read
        Unicorn foundUnicorn = unicornDAO.findById(saveUnicorn.getId());
        System.out.println("Unicorn: " + foundUnicorn.getName());

        //Update
        foundUnicorn.setPowerStrength(20);
        Unicorn updateUnicorn = unicornDAO.update(foundUnicorn);
        System.out.println("Updated powerstrength: " + updateUnicorn.getPowerStrength());

        //Delete
        //unicornDAO.delete(updateUnicorn.getId());
    }
}
