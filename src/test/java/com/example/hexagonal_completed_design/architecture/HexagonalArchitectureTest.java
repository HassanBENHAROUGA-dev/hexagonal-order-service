package com.example.hexagonal_completed_design.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.example.hexagonal_completed_design.order")
public class HexagonalArchitectureTest {

    @ArchTest
    static final ArchRule domain_should_not_depend_on_anything_external =
            noClasses().that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat().resideInAnyPackage(
                            "..application..",
                            "..adapter..",
                            "..infrastructure..",
                            "org.springframework..",
                            "jakarta.persistence.."
                    )
                    .because("Le Domaine est le cœur métier et doit être totalement agnostique.");

    @ArchTest
    static final ArchRule application_should_not_depend_on_adapters_or_infra =
            noClasses().that().resideInAPackage("..application..")
                    .should().dependOnClassesThat().resideInAnyPackage(
                            "..adapter..",
                            "..infrastructure.."
                    )
                    .because("L'Application orchestre via des Ports (Interfaces), elle ignore les détails techniques.");
}