package com.example.SpringBootPegasus;

import com.example.SpringBootPegasus.Entities.Customer;
import com.example.SpringBootPegasus.Entities.Rental;
import com.example.SpringBootPegasus.Entities.car;
import com.example.SpringBootPegasus.Repositories.CarRepository;
import com.example.SpringBootPegasus.Repositories.CustomerRepository;
import com.example.SpringBootPegasus.Repositories.RentalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarRepository carRepository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    private int calculateRentalCost(LocalDate rentalDate, LocalDate returnDate, int dailyRate) {
        long rentalDays = rentalDate.until(returnDate).getDays();
        return (int) (rentalDays * dailyRate);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Customer George = new Customer(
                "George", "Washington", "AAE 556"
        );

        Customer Alex = new Customer(
                "Alex", "Bellingham", "GBE 523"
        );

        Customer Rami = new Customer(
                "Rami", "Kaawache", "BFR 427"
        );
        Customer Kareem = new Customer(
                "Kareem", "Hamdan", "YCR 417"
        );
        Customer Moses = new Customer(
                "Jack", "Simpson", "RAR 126"
        );
        Customer Emilia = new Customer(
                "Emilia", "Velez", "BAW 445"
        );
        Customer Jessica = new Customer(
                "Jessica", "Potter", "OTA 467"
        );
        Customer Yosef = new Customer(
                "Yosef", "Bruce", "OTP 193"
        );
        Customer Lina = new Customer(
                "Lina", "Crawford", "OTU 842"
        );
        Customer Jack = new Customer(
                "Jack", "Golden", "EXE 827"
        );
        Customer Robin = new Customer(
                "Robin", "Dover", "ABC 923"
        );
        Customer John = new Customer(
                "John", "Hardin", "RAM 293"
        );
        Customer Tessa = new Customer(
                "Tessa", "Gates", "JGF 392"
        );
        Customer Mia = new Customer(
                "Mia", "Yang", "KLD 731"
        );
        Customer Monica = new Customer(
                "Monica", "Brown", "LKN 472"
        );

        customerRepository.saveAllAndFlush(List.of(George, Alex, Rami, Emilia, Jack, Mia, Jessica,
                John, Kareem, Lina, Moses, Tessa, Monica,
                Robin, Yosef));


        car Mustang = new car ("Mustang", 2021, "Ford", "Yellow", 90);
        car Bentley = new car ("Continental GT", 2022, "Bentley", "Black", 350);
        car RollsRoyce = new car ("Phantom", 2021, "Rolls-Royce", "White", 500);
        car Ferrari = new car ("488 Spider", 2022, "Ferrari", "Red", 600);
        car Lamborghini = new car ("Aventador", 2022, "Lamborghini", "Orange", 700);
        car AstonMartin = new car ("DBS Superleggera", 2021, "Aston Martin", "Blue", 450);
        car Porsche = new car ("911 Turbo S", 2022, "Porsche", "Silver", 400);
        car Maserati = new car( "GranTurismo", 2021, "Maserati", "Gray", 350);
        car Bugatti = new car( "Chiron", 2022, "Bugatti", "Black", 1000);
        car McLaren = new car( "720S", 2021, "McLaren", "Green", 650);
        car Maybach = new car( "S-Class", 2022, "Mercedes-Maybach", "Gold", 550);
        car Lexus = new car( "LC 500", 2021, "Lexus", "Brown", 300);
        car BMW = new car( "M8", 2022, "BMW", "White", 400);
        car Audi = new car( "R8", 2022, "Audi", "Blue", 450);
        car Jaguar = new car( "F-Type", 2021, "Jaguar", "Black", 350);
        car AlfaRomeo = new car( "Giulia", 2022, "Alfa Romeo", "Red", 350);
        car Volvo = new car( "XC90", 2021, "Volvo", "Gray", 250);
        car Tesla = new car("Model S", 2022, "Tesla", "Silver", 350);
        car Cadillac = new car( "CT6", 2021, "Cadillac", "Black", 300);
        car Infiniti = new car( "Q60", 2022, "Infiniti", "Blue", 300);
        car Genesis = new car( "G70", 2021, "Genesis", "White", 300);
        car LandRover = new car( "Range Rover", 2022, "Land Rover", "Green", 400);
        car Kia = new car( "Stinger", 2021, "Kia", "Red", 250);
        car Subaru = new car( "WRX STI", 2022, "Subaru", "Blue", 300);
        car MiniCooper = new car( "Cooper S", 2021, "Mini", "Yellow", 200);
        car Mitsubishi = new car( "Eclipse Cross", 2022, "Mitsubishi", "Red", 250);
        car Buick = new car( "Enclave", 2021, "Buick", "Gray", 300);
        car Hyundai = new car( "Genesis G80", 2022, "Hyundai", "White", 300);

        carRepository.saveAllAndFlush(
                List.of(Mustang, Bentley, RollsRoyce, Ferrari, Lamborghini, AstonMartin,
                        Porsche, Maserati, Bugatti, McLaren, Maybach, Lexus, BMW, Audi,
                        Jaguar, AlfaRomeo, Volvo, Tesla, Cadillac, Infiniti, Genesis,
                        LandRover, Kia, Subaru, MiniCooper, Mitsubishi, Buick, Hyundai)
        );


        Rental rental = new Rental(Mustang, George, LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 20),
                calculateRentalCost(LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 20), Mustang.getDailyRate()));
        Rental rental2 = new Rental(Bentley, Alex, LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 15),
                calculateRentalCost(LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 15), Bentley.getDailyRate()));
        Rental rental3 = new Rental(RollsRoyce, Rami, LocalDate.of(2023, 7, 5), LocalDate.of(2023, 7, 10),
                calculateRentalCost(LocalDate.of(2023, 7, 5), LocalDate.of(2023, 7, 10), RollsRoyce.getDailyRate()));
        Rental rental4 = new Rental(Ferrari, Kareem, LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 20),
                calculateRentalCost(LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 20), Ferrari.getDailyRate()));
        Rental rental5 = new Rental(Lamborghini, Moses, LocalDate.of(2023, 9, 10), LocalDate.of(2023, 9, 15),
                calculateRentalCost(LocalDate.of(2023, 9, 10), LocalDate.of(2023, 9, 15), Lamborghini.getDailyRate()));
        Rental rental6 = new Rental(AstonMartin, Emilia, LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 10),
                calculateRentalCost(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 10), AstonMartin.getDailyRate()));
        Rental rental7 = new Rental(Porsche, Jessica, LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 20),
                calculateRentalCost(LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 20), Porsche.getDailyRate()));
        Rental rental8 = new Rental(Maserati, Yosef, LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 15),
                calculateRentalCost(LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 15), Maserati.getDailyRate()));
        Rental rental9 = new Rental(Bugatti, Lina, LocalDate.of(2023, 1, 5), LocalDate.of(2023, 1, 10),
                calculateRentalCost(LocalDate.of(2023, 1, 5), LocalDate.of(2023, 1, 10), Bugatti.getDailyRate()));
        Rental rental10 = new Rental(McLaren, Jack, LocalDate.of(2023, 2, 15), LocalDate.of(2023, 2, 20),
                calculateRentalCost(LocalDate.of(2023, 2, 15), LocalDate.of(2023, 2, 20), McLaren.getDailyRate()));
        Rental rental11 = new Rental(Subaru, Robin, LocalDate.of(2023, 3, 10), LocalDate.of(2023, 3, 15),
                calculateRentalCost(LocalDate.of(2023, 3, 10), LocalDate.of(2023, 3, 15), Subaru.getDailyRate()));
        Rental rental12 = new Rental(Kia, John, LocalDate.of(2023, 4, 5), LocalDate.of(2023, 4, 10),
                calculateRentalCost(LocalDate.of(2023, 4, 5), LocalDate.of(2023, 4, 10), Kia.getDailyRate()));
        Rental rental13 = new Rental(Jaguar, Tessa, LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 20),
                calculateRentalCost(LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 20), Jaguar.getDailyRate()));
        Rental rental14 = new Rental(Hyundai, Mia, LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 15),
                calculateRentalCost(LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 15), Hyundai.getDailyRate()));
        Rental rental15 = new Rental(Subaru, Monica, LocalDate.of(2023, 7, 5), LocalDate.of(2023, 7, 10),
                calculateRentalCost(LocalDate.of(2023, 7, 5), LocalDate.of(2023, 7, 10), Subaru.getDailyRate()));

        rentalRepository.saveAll(List.of(rental, rental2, rental3, rental4, rental5,
                                         rental6, rental7, rental8, rental9, rental10,
                                          rental11, rental12, rental13, rental14, rental15));

    }
}
