package com.botscrew.testtaskuniversity.util;

import com.botscrew.testtaskuniversity.model.Lector;
import com.botscrew.testtaskuniversity.model.spec_models.LectorDegreeStatisticsByDepartment;
import com.botscrew.testtaskuniversity.service.DepartmentService;
import com.botscrew.testtaskuniversity.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Helper {

    private static String MESSAGE_IF_NO_DATA_RETURNED = "Department doesn't exist or no lectors in this department right now.";

    DepartmentService departmentService;

    LectorService lectorService;

    @Autowired
    public Helper(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public void chooseRequest(String input) {
        if (input.contains("head")) {
            String departmentName = getLastWordFromString(input);
            Lector headLector = departmentService.findDepartmentHeadLectorByDepartmentName(departmentName);
            if (headLector == null) {
                System.out.println("Department doesn't exist or no head lector in this department right now.");
                return;
            }
            System.out.printf("Head of %s department is %s\n",
                    departmentName, joinNameAndSurname(headLector.getName(), headLector.getSurname()));
        } else if (input.contains("statistics")) {
            String departmentName = input.split(" ")[1];
            List<LectorDegreeStatisticsByDepartment> lectorDegreeStatistics =
                    departmentService.getLectorDegreeStatisticsByDepartmentName(departmentName);
            if (lectorDegreeStatistics.isEmpty()) {
                System.out.println(MESSAGE_IF_NO_DATA_RETURNED);
                return;
            }
            lectorDegreeStatistics.forEach(s -> System.out.println(s.getLectorDegree().degree + "s - " + s.getCount()));
        } else if (input.contains("salary")) {
            String departmentName = getLastWordFromString(input);
            Long avgSalary = departmentService.getAvgSalaryByDepartmentName(departmentName);
            if (avgSalary == null) {
                System.out.println(MESSAGE_IF_NO_DATA_RETURNED);
                return;
            }
            System.out.printf("The average salary for the department %s is %d\n", departmentName, avgSalary);
        } else if (input.contains("employee")) {
            String departmentName = getLastWordFromString(input);
            Long lectorCount = departmentService.getLectorCountByDepartmentName(departmentName);
            if (lectorCount == null) {
                System.out.println(MESSAGE_IF_NO_DATA_RETURNED);
                return;
            }
            System.out.println(lectorCount);
        } else if (input.contains("search")) {
            String template = getLastWordFromString(input);
            List<Lector> lectors = lectorService.findLectorsByNameOrSurnameContaining(template);
            if (lectors.isEmpty()) {
                System.out.println("No such lector with this template.");
                return;
            }
            String collect = lectors.stream().map(l -> joinNameAndSurname(l.getName(), l.getSurname()))
                    .collect(Collectors.joining(", "));
            System.out.println(collect);
        } else {
            System.out.println("Invalid input. For help write -h or --help");
        }
    }

    private String getLastWordFromString(String string) {
        return string.substring(string.lastIndexOf(" ") + 1).replaceAll("\\p{Punct}", "");
    }

    private String joinNameAndSurname(String name, String surname) {
        return name + " " + surname;
    }
}
