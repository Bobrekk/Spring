package com.beginner;

import com.beginner.entity.Employee;
import com.beginner.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class WebFluxApp {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApp.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void appStart() {
        if (employeeRepository.count().block() == 0){
            IntStream.range(8, 100).mapToObj(this::generate)
                    .map(employeeRepository::save)
                    .collect(Collectors.toList())
                    .forEach(item -> item.subscribe(System.out::println));
        }
    }

    private Employee generate(int i) {
        return Employee.builder()
                .name("Name" + i)
                .lastname("Lastname" + i)
                .birthDate(LocalDate.now())
                .build();
    }
}
