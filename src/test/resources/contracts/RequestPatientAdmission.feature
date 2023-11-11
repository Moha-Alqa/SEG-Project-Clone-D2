Feature: Request Patient Admission

  Scenario: Charge Nurse puts a Patient in a request list for a bed at a division
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    And the Charge Nurse chooses to request patient admission
    And Charge Nurse provides required information upon request
    And HMS puts Patient in requested ward list of patients awaiting admission
    When the application command requestPatientAdmission is invoked
    Then a Patient is in a request list for admission at the requested division
    And HMS sends notification to requested ward Charge Nurse
  
  Scenario: Charge Nurse attempts puts a Patient in a request list for a bed at a division but provides incorrect information
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    And the Charge Nurse chooses to request patient admission
    And Charge Nurse provides incorrect information upon request
    When the application command requestPatientAdmission is invoked
    Then HMS displays information error message
    And the Patient will not be in a request list for admission at the requested division

  Scenario: Charge Nurse attempts puts a Patient in a request list for a bed at a division but patient is already admitted to a service
    Given the Charge Nurse is logged in
    And a patient registration is being displayed
    And the Charge Nurse chooses to request patient admission
    And patient is already admitted to a service
    When the application command requestPatientAdmission is invoked
    Then HMS displays patient already in ward error message
   
